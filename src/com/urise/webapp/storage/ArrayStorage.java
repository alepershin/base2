package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    public void clear() {
        for(int i=0;i<size;i++){
            storage[i]=null;
        }
        size = 0;
    }

    public void update(Resume r) {
        // TODO check if resume present
        int i = 0;
        while (i < size && !r.equals(storage[i])) {
            i++;
        }
        if (i == size) {
            System.out.println("ERROR: Резюме не найдено");
        }
    }

    public void save(Resume r) {
        // TODO check if resume not present
        int i = 0;
        while (i < size && r.equals(storage[i]) == false) {
            i++;
        }
        if (i == size) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("ERROR: Резюме уже существует");
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        int i = 0;
        while (i < size && storage[i].getUuid() != uuid) {
            i++;
        }
        if (i == size) {
            System.out.println("ERROR: Резюме не найдено");
        } else {
            storage[i] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] st = new Resume[size];
        for (int i = 0; i < size; i++) {
            st[i] = storage[i];
        }
        return st;
    }

    public int size() {
        return size;
    }
}
