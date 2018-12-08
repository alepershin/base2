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
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void update(Resume r) {
        // TODO check if resume present
        for (int i = 0; i < size; i++) {
            if (r.getUuid().equals(storage[i].getUuid())) {
                storage[i]=r;
                return;
            }
        }
        System.out.println("ERROR: Резюме не найдено");
    }

    public void save(Resume r) {
        // TODO check if resume not present
        for (int i = 0; i < size; i++) {
            if (r.getUuid().equals(storage[i].getUuid())) {
                System.out.println("ERROR: Резюме уже существует");
                return;
            }
        }

        if (size < 9_999) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("ERROR: Переполнение");
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return storage[i];
            }
        }
        System.out.println("Резюме не найдено");
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("ERROR: Резюме не найдено");
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
