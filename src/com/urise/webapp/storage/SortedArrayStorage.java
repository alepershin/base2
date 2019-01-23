package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "fullname");
        return Arrays.binarySearch(storage, 0, size, searchKey, Resume::compareTo);
    }

    @Override
    protected void insertElement(Resume r, int index) {
        int i = -index - 1;
        System.arraycopy(storage, i, storage, i + 1, size - i);
        storage[i] = r;
    }

    @Override
    protected void fillDeletedElement(int index) {
        int i = size - 1 - index;
        if (i > 0) System.arraycopy(storage, index + 1, storage, index, i);
    }
}