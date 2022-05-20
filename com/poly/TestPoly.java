package com.poly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestPoly {
  public static void main(String[] args) {
    List<Poly> polyList = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
      int[] coefficients = createRandomArray(i);
      if (i < 6) {
        polyList.add(createArrayPoly(coefficients));
      } else {
        polyList.add(createListPoly(coefficients));
      }
    }

    for (int i = 0; i < 10; i++) {
      System.out.println("Poly " + (i + 1));
      System.out.println(polyList.get(i));
      System.out.println(polyList.get(i).derivative());
      int x = (int)(Math.random() * 10);
      System.out.println(x);
      System.out.println(polyList.get(i).evaluate(x));
    }
  }

  public static ArrayPoly createArrayPoly(int[] coefficients) {
    return new ArrayPoly(coefficients);
  }

  public static ListPoly createListPoly(int[] coefficients) {
    return new ListPoly(coefficients);
  }

  public static int[] createRandomArray(int length) {
    int[] array = new int[length];
    for (int i = 0; i < length; i++) {
      array[i] = (int)(Math.random() * 10);
    }
    return array;
  }
}
