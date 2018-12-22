package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void addResume(int index, Resume r){
        int i = -index - 1;
        if (i <= size - 1) {
            if (size - i >= 0) System.arraycopy(storage, i, storage, i + 1, size - i);
        }
        storage[i] = r;
    }

    @Override
    protected void delResume(int index){
        if (size - 1 - index >= 0) System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
    }
}