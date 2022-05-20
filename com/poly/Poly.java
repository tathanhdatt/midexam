package com.poly;

public interface Poly {
  public abstract int coefficient(int i);
  public abstract int[] coefficients();
  public abstract int degree();
  public abstract Poly derivative();
  public abstract double evaluate(double x);
}
