package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    public void clear() {

    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index > -1) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            int i = -index - 1; //Индекс, который должен быть у вставляемого элемента
            System.out.println("Место вставки элемента " + r.getUuid() + " " + i);
            if (i <= size - 1) {
                for (int j = size; j > i; j--) {
                    storage[j] = storage[j-1];
                }
            }
            storage[i] = r;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
