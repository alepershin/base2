package com.urise.webapp;

import com.urise.webapp.storage.AbstractArrayStorage;
import com.urise.webapp.storage.ArrayStorage;

/**
 * Test for your com.urise.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        AbstractArrayStorage.Resume r1 = new AbstractArrayStorage.Resume("uuid1", "fullName1");
        AbstractArrayStorage.Resume r2 = new AbstractArrayStorage.Resume("uuid2", "fullName2");
        AbstractArrayStorage.Resume r3 = new AbstractArrayStorage.Resume("uuid3", "fullName3");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println(ARRAY_STORAGE.getAllSorted().toString());
    }

/*
    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
*/
}
