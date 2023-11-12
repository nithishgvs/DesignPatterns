package com.company.designpatterns.creational.singleton;

class SingletonEagar {

  private static SingletonEagar instance = new SingletonEagar();

  private SingletonEagar() {
  }

  public static SingletonEagar getInstance() {
    return instance;
  }
}

/**
 * Lazy Initialization
 */
class Singleton {

  private static Singleton instance;

  private Singleton() {
  }

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }

    return instance;
  }
}

class SingletonSynchronizedMethod {

  private static SingletonSynchronizedMethod instance;

  private SingletonSynchronizedMethod() {
  }

  /**
   * One thread can access this method & this is thread safe
   */
  public static synchronized SingletonSynchronizedMethod getInstance() {
    if (instance == null) {
      instance = new SingletonSynchronizedMethod();
    }
    return instance;
  }
}

/**
 * Synchronized block
 */
class SingletonSynchronized {

  private static SingletonSynchronized instance;

  private SingletonSynchronized() {
  }

  public static SingletonSynchronized getInstance() {
    /**
     * Synchronized only during creation of the object, read need not be synchronized
     */
    if (instance == null) {
      synchronized (SingletonSynchronized.class) {
        if (instance == null) {
          instance = new SingletonSynchronized();
        }
      }
    }
    //Read is not synchronized because same object will be returned for all threads
    return instance;
  }
}

public class SingletonExample {

  public static void main(String[] args) {
    SingletonSynchronized instance = SingletonSynchronized.getInstance();

    System.out.println(instance);

    SingletonSynchronized instance1 = SingletonSynchronized.getInstance();

    System.out.println(instance1);
  }
}
