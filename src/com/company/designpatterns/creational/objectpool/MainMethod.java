package com.company.designpatterns.creational.objectpool;

public class MainMethod {

  public static void main(String[] args) {
    OliphauntPool pool = new OliphauntPool();
    Oliphaunt oliphaunt1 = pool.checkOut();
    Oliphaunt oliphaunt2 = pool.checkOut();
    Oliphaunt oliphaunt3 = pool.checkOut();
    Oliphaunt oliphaunt4 = pool.checkOut();
    Oliphaunt oliphaunt5 = pool.checkOut();
    pool.checkIn(oliphaunt1);
    pool.checkIn(oliphaunt2);
    Oliphaunt oliphaunt6 = pool.checkOut();
    Oliphaunt oliphaunt7 = pool.checkOut();
  }
}
