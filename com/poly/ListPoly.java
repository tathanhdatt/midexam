package com.poly;

import java.util.ArrayList;
import java.util.List;

public class ListPoly extends AbstractPoly {
  private List<Integer> coefficients;

  public ListPoly(int[] coefficients) {
    this.coefficients = new ArrayList<>();
    for (int coefficient : coefficients) {
      this.coefficients.add(coefficient);
    }
    super.degree = coefficients.length - 1;
  }

  public ListPoly plus(ListPoly other) {
    reduce();
    int maxDegree = Math.max(super.degree, other.degree());
    int[] newCoefficients = new int[maxDegree + 1];

    for (int i = 0; i < maxDegree; i++) {
      newCoefficients[i] = this.coefficients.get(i) + other.coefficient(i);
    }

    return new ListPoly(newCoefficients);
  }

  public ListPoly minus(ListPoly other) {
    reduce();
    int maxDegree = Math.max(super.degree, other.degree());
    int[] newCoefficients = new int[maxDegree + 1];

    for (int i = 0; i < maxDegree; i++) {
      newCoefficients[i] = this.coefficients.get(i) - other.coefficient(i);
    }

    return new ListPoly(newCoefficients);
  }

  public ListPoly times(ListPoly other) {
    reduce();
    int maxDegree = Math.max(super.degree, other.degree());
    int[] newCoefficients = new int[maxDegree + 1];

    for (int i = 0; i < maxDegree; i++) {
      newCoefficients[i] = this.coefficients.get(i) * other.coefficient(i);
    }

    return new ListPoly(newCoefficients);
  }

  private void reduce() {
    for (int i = degree; i >= 0; i--) {
      if (this.coefficients.get(i) == 0) {
        super.degree = i;
      } else {
        break;
      }
    }
  }

  @Override
  public Poly derivative() {
    reduce();
    int[] newCoefficients = new int[degree + 1];
    for (int i = 0; i <= degree; i++) {
      newCoefficients[i] = i * coefficients()[i];
    }
    return new ListPoly(newCoefficients);
  }

  @Override
  public int coefficient(int degree) {
    return this.coefficients.get(degree);
  }

  @Override
  public int[] coefficients() {
    reduce();
    int[] arrayCoefficients = new int[super.degree + 1];
    for (int i = 0; i < super.degree; i++) {
      arrayCoefficients[i] = this.coefficients.get(i);
    }
    return arrayCoefficients;
  }

  public String type() {
    return "List Poly";
  }
}