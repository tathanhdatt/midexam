package com.mylist;

public interface MyList {
  void add(Object obj);
  void add(Object obj, int x);
  Object get(int i);
  void remove(int x);
  int size();
}
