package com.company.designpatterns.creational.abstractfactory;

public class Sbi implements Bank {

  private final String BNAME;

  public Sbi() {
    BNAME = "SBI BANK";
  }

  @Override
  public String getBankName() {
    return BNAME;
  }
}
