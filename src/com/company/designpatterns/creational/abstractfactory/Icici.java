package com.company.designpatterns.creational.abstractfactory;

public class Icici implements Bank {

  private final String BNAME;

  Icici() {
    BNAME = "ICICI BANK";
  }

  @Override
  public String getBankName() {
    return BNAME;
  }
}
