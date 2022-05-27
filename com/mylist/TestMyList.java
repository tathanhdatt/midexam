package com.mylist;

public class TestMyList {
  public static void main(String[] args) {
    MyLinkedList myLinkedList = new MyLinkedList();
    myLinkedList.add(1);
    myLinkedList.add(2);
    myLinkedList.add(3);
    myLinkedList.add(4);
    myLinkedList.add(5);
    myLinkedList.add(6);
    myLinkedList.add(7);
    myLinkedList.add(8);
    myLinkedList.add(9);
    myLinkedList.add(10);
    System.out.println(myLinkedList);

    myLinkedList.add(11, 2);
    System.out.println(myLinkedList);
    myLinkedList.remove(5);
    System.out.println(myLinkedList);

    MyArrayList myArrayList = new MyArrayList();
    myArrayList.add(1);
    myArrayList.add(2);
    myArrayList.add(3);
    myArrayList.add(4);
    myArrayList.add(5);
    System.out.println(myArrayList);
    myArrayList.add(13, 2);
    System.out.println(myArrayList);
    myArrayList.remove(2);
    myArrayList.remove(2);
    System.out.println(myArrayList);

  }
}
