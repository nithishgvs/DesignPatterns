package com.company.designpatterns.creational.abstractfactory;

public class Hdfc implements Bank {

  private final String BNAME;

  public Hdfc() {
    BNAME = "HDFC BANK";
  }

  @Override
  public String getBankName() {
    return BNAME;
  }
}
