package org.example.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HashTable implements Iterable {
    Object[] slot = new Object[10];

    public HashTable() {
        for (int i = 0; i < slot.length; i++) {
            slot[i] = new ArrayList();
        }

    }

    public void add(Object item) {
        int hashCode = item.hashCode();
        int index = hashCode % 10;
        List list = (List) slot[index];
        if (list.isEmpty()) {
            list.add(item);
        } else {
            boolean found = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(item)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                list.add(item);
            }
        }
    }

    public void remove(Object item) {
        int hashCode = item.hashCode();
        int index = hashCode % 10;
        List list = (List) slot[index];
        System.out.println("Remove");
        if (contain(item)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(item)) {
                    list.remove(i);
                    System.out.println("Removed\n");
                    break;
                }
            }
        } else {
            System.out.println("This item not contain in slot\n");
        }
    }

    public boolean contain(Object item) {
        int hasCode = item.hashCode();
        int index = hasCode % 10;
        List list = (List) slot[index];
        System.out.println("Item : " + item);
        System.out.println("index : " + index);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null && list.get(i).equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int currentIndex;
            int currentSubIndex;

            @Override
            public boolean hasNext() {
                return currentIndex < slot.length;
            }

            @Override
            public Object next() {
                List currentSlot = (List) slot[currentIndex];
                while (currentSlot.isEmpty()) {
                    currentIndex++;
                    currentSubIndex = 0;
                    currentSlot = (List) slot[currentIndex];
                    return null;
                }
                if (currentIndex < slot.length) {
                    if (currentSubIndex < currentSlot.size()) {
                        if (currentSubIndex == currentSlot.size() - 1) {
                            currentIndex++;
                        }
                        Object item = currentSlot.get(currentSubIndex++);
                        if (currentSubIndex == currentSlot.size()) {
                            currentSubIndex = 0;
                        }
                        return item;
                    }
                }
                return null;
            }
        };
    }
}
