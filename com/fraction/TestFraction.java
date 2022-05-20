package com.fraction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestFraction {
  public static void main(String[] args) {
    List<Fraction> fractions = new ArrayList<>();

    for (int i = 0; i < 30; i++) {
      int numerator = (int) (Math.random() * 1000) + 1;
      int denominator = (int) (Math.random() * 1000) + 1;
      fractions.add(new Fraction(numerator, denominator));
    }

    for (Fraction fraction : fractions) {
      System.out.print(fraction + " ");
    }
    System.out.println();

    Collections.sort(fractions);

    for (Fraction fraction : fractions) {
      System.out.print(fraction + " ");
    }
    System.out.println();

    for (int i = 0; i < fractions.size() - 1; i++) {
      for (int j = i + 1; j < fractions.size(); j++) {
        if (fractions.get(i).getDenominator() > fractions.get(j).getDenominator()) {
          Fraction term = fractions.get(i);
          fractions.set(i, fractions.get(j));
          fractions.set(j, term);
        }
      }
    }

    for (Fraction fraction : fractions) {
      System.out.print(fraction + " ");
    }
  }
}
