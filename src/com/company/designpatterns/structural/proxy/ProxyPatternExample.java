package com.company.designpatterns.structural.proxy;

interface DatabaseExecutor {

  public void executeDatabase(String query) throws Exception;
}

class DatabaseExecutorImpl implements DatabaseExecutor {

  @Override
  public void executeDatabase(String query) {
    System.out.println("Going to execute Query: " + query);
  }

}

class DatabaseExecutorProxy implements DatabaseExecutor {

  boolean ifAdmin;
  DatabaseExecutorImpl dbExecutor;

  public DatabaseExecutorProxy(String name, String passwd) {
    if (name == "Admin" && passwd == "Admin@123") {
      ifAdmin = true;
    }
    dbExecutor = new DatabaseExecutorImpl();
  }

  @Override
  public void executeDatabase(String query) throws Exception {
    if (ifAdmin) {
      dbExecutor.executeDatabase(query);
    } else {
      if (query.equals("DELETE")) {
        throw new Exception("DELETE not allowed for non-admin user");
      } else {
        dbExecutor.executeDatabase(query);
      }
    }
  }
}

public class ProxyPatternExample {

  public static void main(String[] args) throws Exception {
    DatabaseExecutor nonAdminExecutor = new DatabaseExecutorProxy("NonAdmin", "Admin@123");
    nonAdminExecutor.executeDatabase("DELEE");

    DatabaseExecutor nonAdminExecutorDELETE = new DatabaseExecutorProxy("NonAdmin", "Admin@123");
    nonAdminExecutorDELETE.executeDatabase("DELETE");

    DatabaseExecutor adminExecutor = new DatabaseExecutorProxy("Admin", "Admin@123");
    adminExecutor.executeDatabase("DELETE");

  }

}