package com.mylist;

public abstract class MyAbstractList implements MyList {

  public boolean checkBoundaries(int index, int limit) {
    return 0 <= index && index <= limit;
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append('[');
    for (int i = 0; i < size() - 1; i++) {
      str.append(get(i)).append("][");
    }
    str.append(get(size() - 1)).append(']');
    return str.toString();
  }
}