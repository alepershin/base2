package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    private int findResume(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (resume.getUuid().equals(storage[i].getUuid())) {
                return i;
            }
        }
        return size;
    }

    private int findUuid(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void update(Resume resume) {
        int j = findResume(resume);
        if (j < size) {
            storage[j] = resume;
        } else {
            System.out.println("ERROR: Резюме не найдено");
        }
    }

    public void save(Resume resume) {
        if (findResume(resume) < size) {
            System.out.println("ERROR: Резюме уже существует");
        } else {
            if (size < 10_000) {
                storage[size] = resume;
                size++;
            } else {
                System.out.println("ERROR: Переполнение");
            }
        }
    }

    public Resume get(String uuid) {
        int j = findUuid(uuid);
        if (j < size) {
            return storage[j];
        } else {
            System.out.println("Резюме не найдено");
            return null;
        }
    }

    public void delete(String uuid) {
        int j = findUuid(uuid);
        if (j < size) {
            storage[j] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("ERROR: Резюме не найдено");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.stream(storage, 0, size).toArray(Resume[]::new);
    }

    public int size() {
        return size;
    }
}
