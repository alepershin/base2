package com.urise.webapp.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<AbstractArrayStorage.Resume> list = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid))
                return i;
        }
        return null;
    }

    @Override
    protected void doUpdate(AbstractArrayStorage.Resume resume, Object searchKey) {
        list.set((Integer) searchKey, resume);
    }

    @Override
    protected void doSave(AbstractArrayStorage.Resume resume, Object searchKey) {
        list.add(resume);
    }

    @Override
    protected Object doGet(Object searchKey) {
        return list.get((Integer) searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        list.remove(((Integer) searchKey).intValue());
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public List<AbstractArrayStorage.Resume> getAllSorted() {
        Collections.sort(list);
        return list;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

}
