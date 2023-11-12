package com.company.designpatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Original Object will not be changed we take this Original object and create new object by
 * cloning this original
 */
class Vehicle implements Cloneable {

  private List<String> vehicleList;

  public Vehicle() {
    this.vehicleList = new ArrayList<>();
  }

  public Vehicle(List<String> list) {
    this.vehicleList = list;
  }

  public void insertData() {
    vehicleList.add("Honda amaze");
    vehicleList.add("Audi A4");
    vehicleList.add("Hyundai Creta");
    vehicleList.add("Maruti Baleno");
    vehicleList.add("Renault Duster");
  }

  public List<String> getVehicleList() {
    return this.vehicleList;
  }

  /**
   * Deep copy of vehicleList into tempList
   */
  @Override
  public Object clone() {
    List<String> tempList = new ArrayList<>();

    for (String s : this.getVehicleList()) {
      tempList.add(s);
    }

    return new Vehicle(tempList);
  }
}

public class PrototypePatternExample {

  public static void main(String[] args) throws CloneNotSupportedException {
    Vehicle a = new Vehicle();
    a.insertData();

    Vehicle b = (Vehicle) a.clone();
    List<String> list = b.getVehicleList();
    list.add("Honda new Amaze");

    System.out.println(a.getVehicleList());
    System.out.println(list);

    b.getVehicleList().remove("Audi A4");
    System.out.println(list);
    System.out.println(a.getVehicleList());
  }

}
