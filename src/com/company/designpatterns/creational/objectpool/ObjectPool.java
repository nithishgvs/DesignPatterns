package com.company.designpatterns.creational.objectpool;

import java.util.HashSet;
import java.util.Set;

public abstract class ObjectPool<T> {

  private Set<T> available = new HashSet<>();

  private Set<T> inUse = new HashSet<>();

  private int size = 4;

  protected abstract T create();

  /**
   * Checkout object from pool
   */
  public synchronized T checkOut() {
    if (inUse.size() == size) {
      return null;
    }
    if (available.isEmpty()) {
      available.add(create());
    }
    T instance = available.iterator().next();
    available.remove(instance);
    inUse.add(instance);
    return instance;
  }

  public synchronized void checkIn(T instance) {
    inUse.remove(instance);
    available.add(instance);
  }

  @Override
  public String toString() {
    return String.format("Pool available=%d inUse=%d", available.size(), inUse.size());
  }

}
