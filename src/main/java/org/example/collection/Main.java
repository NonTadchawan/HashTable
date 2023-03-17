package org.example.collection;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.add("A");
        hashTable.add("f");
        hashTable.add("B");
        hashTable.add("H");
        hashTable.add("C");
        hashTable.add("I");
        hashTable.add("x");
        hashTable.add("Y");
        hashTable.add("J");
        hashTable.add("m");
        hashTable.add("s");
        hashTable.add("z");
        hashTable.add(new String("N"));
        hashTable.add("Y");

        hashTable.remove("m");

        for (Object item : hashTable.slot) {
            System.out.println(item);
        }
        for (Object item : hashTable) {
            System.out.println(item);
        }
        System.out.println();
        System.out.println("Contain in slot : " + hashTable.contain("m") + "\n");
        System.out.println("Contain in slot : " + hashTable.contain("Y"));
    }
}
