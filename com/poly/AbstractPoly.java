package com.poly;

public class AbstractPoly implements Poly {
  protected int degree;

  public AbstractPoly(){
  }

  int[] differentiate() {
    int[] newCoefficients = new int[degree + 1];
    for (int i = 0; i <= degree; i++) {
      newCoefficients[i] = i * coefficients()[i];
    }
    return newCoefficients;
  }

  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (this.degree != ((Poly)obj).degree()) {
      return false;
    }

    for (int i = 0; i < degree; i++) {
      if (this.coefficient(i) != ((Poly) obj).coefficient(i)) {
        return false;
      }
    }

    return true;
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();

    str.append("Poly[");

    if (degree == 0) {
      str.append(coefficients()[0]).append(']');
      return str.toString();
    }

    str.append(coefficients()[0]).append(" + ");

    if (degree == 1) {
      str.append(coefficients()[1]).append("x]");
      return str.toString();
    }

    for (int i = 1; i < degree; i++) {
      if (i == 1) {
        str.append(coefficients()[1]).append("x + ");
      } else {
        str.append(coefficients()[i]).append("x^").append(i).append(" + ");
      }
    }

    str.append(coefficients()[degree]).append("x^").append(degree);
    str.append(']');

    return str.toString();
  }

  @Override
  public int coefficient(int i) {
    return this.coefficients()[i];
  }

  @Override
  public int[] coefficients() {
    return new int[degree];
  }

  @Override
  public int degree() {
    return this.degree;
  }

  @Override
  public Poly derivative() {
    return null;
  }

  @Override
  public double evaluate(double x) {

    int evaluate = 0;

    for (int i = 0; i <= this.degree; i++) {
      evaluate += this.coefficient(i);
    }

    return evaluate;
  }
}
