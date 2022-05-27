package com.mylist;

public class MyArrayList extends MyAbstractList {
  static final int INITIAL_SIZE = 1;
  Object[] elements;
  int size;

  public MyArrayList() {
    this.elements = new Object[1];
    this.size = 0;
  }

  @Override
  public void add(Object o) {
    if (size >= elements.length - 1) {
      enlarge();
    }
    elements[size++] = o;
  }

  @Override
  public void add(Object o, int index) {
    size++;
    if (size >= elements.length - 1) {
      enlarge();
    }

    for (int i = size - 1; i > index; i--) {
      elements[i] = elements[i - 1];
    }
    elements[index] = o;
  }

  @Override
  public Object get(int index) throws IndexOutOfBoundsException {
    if (!super.checkBoundaries(index, this.size)) {
      throw new IndexOutOfBoundsException("Index " + index + " out of length " + size);
    }
    return elements[index];
  }

  @Override
  public void remove(int index) {
    size--;
    for (int i = index; i < size; i++) {
      elements[i] = elements[i + 1];
    }
  }

  @Override
  public int size() {
    return this.size;
  }

  void enlarge() {
    Object[] tmp = new Object[elements.length * 2];
    System.arraycopy(elements, 0, tmp, 0, elements.length);
    elements = tmp;
  }
}
