package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    static final int maxCountResume = 10_000;
    private Resume[] storage = new Resume[maxCountResume];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void update(Resume resume) {
        int j = findUuid(resume.getUuid());
        if (j != -1) {
            storage[j] = resume;
        } else {
            System.out.println("ERROR: Резюме не найдено");
        }
    }

    public void save(Resume resume) {
        if (findUuid(resume.getUuid()) != -1) {
            System.out.println("ERROR: Резюме уже существует");
        } else {
            if (size < maxCountResume) {
                storage[size] = resume;
                size++;
            } else {
                System.out.println("ERROR: Переполнение");
            }
        }
    }

    public Resume get(String uuid) {
        int j = findUuid(uuid);
        if (j != -1) {
            return storage[j];
        } else {
            System.out.println("Резюме не найдено");
            return null;
        }
    }

    public void delete(String uuid) {
        int j = findUuid(uuid);
        if (j != -1) {
            storage[j] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("ERROR: Резюме не найдено");
        }
    }

    private int findUuid(String uuid) {
        for (int i = 0; i < size; i++)
            if (storage[i].getUuid().equals(uuid)) return i;
        return -1;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }
}
