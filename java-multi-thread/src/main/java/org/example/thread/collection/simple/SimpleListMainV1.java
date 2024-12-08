package org.example.thread.collection.simple;

import org.example.thread.collection.simple.list.BasicList;
import org.example.thread.collection.simple.list.SimpleList;

public class SimpleListMainV1 {
  public static void main(String[] args) {
    SimpleList list = new BasicList();
    list.add("A");
    list.add("B");

    System.out.println(list);
  }
}
