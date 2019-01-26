package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public List<Resume> getAllSorted() {
        Arrays.sort(storage);
        return Arrays.asList(storage);
    }

    @Override
    public Resume doGet(Object index) {
        return storage[(Integer) index];
    }

    @Override
    public void doSave(Resume resume, Object searchKey) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insertElement(resume, (Integer) searchKey);
            size++;
        }
    }

    @Override
    public void doDelete(Object index) {
        fillDeletedElement((Integer) index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        storage[(Integer) searchKey] = resume;
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index > -1;
    }

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void fillDeletedElement(int index);

    public static class Resume implements Comparable<Resume> {

        // Unique identifier
        private final String uuid;

        private final String fullName;

        public Resume(String fullName) {
            this(UUID.randomUUID().toString(), "fullName");
        }

        public Resume(String uuid, String fullName) {
            this.uuid = uuid;
            this.fullName = fullName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Resume resume = (Resume) o;

            if (!uuid.equals(resume.uuid)) return false;
            return fullName.equals(resume.fullName);
        }

        @Override
        public int hashCode() {
            int result = uuid.hashCode();
            result = 31 * result + fullName.hashCode();
            return result;
        }

        public String getUuid() {
            return uuid;
        }

        @Override
        public String toString() {
            return uuid;
        }

        @Override
        public int compareTo(Resume o) {
            int i = fullName.compareTo(o.fullName);
            return i != 0 ? i : uuid.compareTo(o.uuid);
        }
    }
}