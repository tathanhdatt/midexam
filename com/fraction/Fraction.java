package com.fraction;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Fraction extends Number implements Comparable<Fraction> {

  private int numerator;
  private int denominator;

  public Fraction(Fraction another) {
    this.numerator = another.getNumerator();
    this.denominator = another.getDenominator();
  }

  public Fraction(int numerator, int denominator) {
    this.denominator = denominator;
    this.numerator = numerator;
  }

  public Fraction(int numerator) {
    this.numerator = numerator;
    this.denominator = 1;
  }

  public int getNumerator() {
    return this.numerator;
  }

  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }

  public int getDenominator() {
    return this.denominator;
  }

  public void setDenominator(int denominator) {
    this.denominator = denominator;
  }

  public String toString() {
    return "Fraction[" + this.numerator + '/' + this.denominator + ']';
  }

  public boolean equals(Fraction other) {
    return this.numerator == other.getNumerator()
            && this.denominator == other.getDenominator();
  }

  public double doubleValue() {
    return (double)(this.numerator) / this.denominator;
  }

  public float floatValue() {
    return (float)(this.numerator) / this.denominator;
  }

  public int intValue() {
    return this.numerator / this.denominator;
  }

  public long longValue() {
    return (long)(this.numerator / this.denominator);
  }

  public short shortValue() {
    return (short)(this.numerator / this.denominator);
  }

  public int compareTo(Fraction other) {
    if (this.numerator * other.getDenominator() >
            other.getNumerator() * this.denominator
    ) {
      return 1;
    } else if (this.numerator * other.getDenominator() ==
            other.getNumerator() * this.denominator
    ) {
      return 0;
    } else {
      return -1;
    }
  }

  private static int gcd(int m, int n) {
    int temp;
    while(n != 0) {
      temp = m % n;
      m = n;
      n = temp;
    }
    return m;
  }

  private void simplify() {
    while (gcd(this.numerator, this.denominator) != 1) {
      int gcd = gcd(this.numerator, this.denominator);
      this.numerator /= gcd;
      this.denominator /= gcd;
    }
  }

  public Fraction add(Fraction other) {
    int newNumerator = this.numerator * other.getDenominator()
            + other.getNumerator() * this.denominator;
    int newDenominator = this.denominator * other.getDenominator();

    Fraction newFraction = new Fraction(newNumerator, newDenominator);
    newFraction.simplify();

    return newFraction;
  }

  public Fraction add(int other) {
    return this.add(new Fraction(other, 1));
  }

  /*
   *   Our main method tests our class and demonstrates behavior
   * */
  public static void main(String[] args) {
    Fraction f1 = new Fraction(1, 2);
    Fraction f2 = new Fraction(2, 3);
    Fraction f3 = new Fraction(1, 4);

    System.out.println(f1.add(1));
    System.out.println(f1.intValue());
    System.out.println(f1.doubleValue());

    List<Fraction> myFractions = new ArrayList<>();
    myFractions.add(f1);
    myFractions.add(f2);
    myFractions.add(f3);
    Collections.sort(myFractions);

    for (Fraction f : myFractions) {
      System.out.println(f);
    }
  }
}