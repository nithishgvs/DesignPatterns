package com.company.designpatterns.creational.builder;


class Employee {

  //optional
  private int age;
  private String firstName;
  private String lastName;
  //optional
  private int salary;

  public int getAge() {
    return age;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getSalary() {
    return salary;
  }

  public Employee(EmployeeBuilder employeeBuilder) {
    this.age = employeeBuilder.age;
    this.firstName = employeeBuilder.firstName;
    this.lastName = employeeBuilder.lastName;
    this.salary = employeeBuilder.salary;
  }

  public static class EmployeeBuilder {

    private int age;
    private String firstName;
    private String lastName;
    private int salary;

    public EmployeeBuilder(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public EmployeeBuilder setAge(int age) {
      this.age = age;
      return this;
    }

    public EmployeeBuilder setSalary(int salary) {
      this.salary = salary;
      return this;
    }

    public Employee build() {
      return new Employee(this);
    }
  }

}


public class EmployeeBuilderExample {

  public static void main(String[] args) {
    Employee employee = new Employee.EmployeeBuilder("sai", "nithish").setAge(32).setSalary(1000)
        .build();
    Employee employee2 = new Employee.EmployeeBuilder("sai", "kiran").setAge(32).setSalary(1500)
        .build();
    System.out.println(employee.getAge());
  }


}
