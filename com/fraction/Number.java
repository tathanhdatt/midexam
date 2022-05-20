package com.fraction;

public abstract class Number {
  private long serialVersionUaID;

  public Number(){
  }

  public byte byteValue(){
    return 0;
  }

  public abstract double doubleValue();

  public abstract float floatValue();

  public abstract int intValue();

  public abstract long longValue();

  public abstract short shortValue();
}
