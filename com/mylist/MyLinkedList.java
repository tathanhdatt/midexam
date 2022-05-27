package com.mylist;

public class MyLinkedList extends MyAbstractList {
  protected MyLinkedListNode head;
  protected int size;

  public MyLinkedList() {
    this.head = null;
    this.size = 0;
  }

  @Override
  public void add(Object obj) {
    if (this.size == 0) {
      this.head = new MyLinkedListNode(obj);
      this.size++;
      return;
    }

    MyLinkedListNode lastNode = this.head;

    for (int i = 1; i < size; i++) {
      lastNode = lastNode.getNext();
    }

    lastNode.setNext(new MyLinkedListNode(obj));
    this.size++;
  }

  @Override
  public void add(Object obj, int index) {
    index++;
    this.add(obj);
    MyLinkedListNode node = this.head;
    for (int i = 1; i < index; i++) {
      node = node.getNext();
    }
    Object prevPayload = node.getPayload();
    Object nextPayload;

    for (int i = index; i < this.size; i++) {
      node = node.getNext();
      nextPayload = node.getPayload();
      node.setPayload(prevPayload);
      prevPayload = nextPayload;
    }

    MyLinkedListNode indexNode = this.head;
    for (int i = 1; i < index; i++) {
      indexNode = indexNode.getNext();
    }

    indexNode.setPayload(obj);
  }

  @Override
  public Object get(int index) throws IndexOutOfBoundsException {
    if (!super.checkBoundaries(index, size)) {
      throw new IndexOutOfBoundsException("Index " + index + " out of length " + size);
    }
    MyLinkedListNode iNode = this.head;
    for (int j = 0; j < index; j++) {
      iNode = iNode.getNext();
    }
    return iNode.getPayload();
  }

  @Override
  public void remove(int index) throws IndexOutOfBoundsException {
    if (!super.checkBoundaries(index, this.size)) {
      throw new IndexOutOfBoundsException("Index " + index + " out of length " + size);
    }
    index++;
    MyLinkedListNode node = this.head;
    for (int i = 1; i < index; i++) {
      node = node.getNext();
    }

    for (int i = index; i < this.size; i++) {
      node.setPayload(node.getNext().getPayload());
      node = node.getNext();
    }
    this.size--;
  }

  @Override
  public int size() {
    return this.size;
  }
}
