package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ArrayStorage;

import java.io.IOException;

/**
 * Test for your com.urise.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) throws IOException {
        Resume r1 = new Resume("uuid1", "fullName1");
        Resume r2 = new Resume("uuid2", "fullName2");
        Resume r3 = new Resume("uuid3", "fullName3");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println(ARRAY_STORAGE.getAllSorted().toString());
    }
}
