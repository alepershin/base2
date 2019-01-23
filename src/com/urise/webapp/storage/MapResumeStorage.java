package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {
    private Map<Integer, Resume> map = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        map.put((Integer) searchKey, r);
    }

    @Override
    protected void doDelete(Object uuid) {
        map.remove((Integer) uuid);
    }

    @Override
    protected void doSave(Resume r, Object uuid) {
        map.put((Integer) uuid, r);
    }

    @Override
    protected Resume doGet(Object uuid) {
        return map.get((Integer) uuid);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = new ArrayList<Resume>(map.values());
        Collections.sort(list);
        return list;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected boolean isExist(Object uuid){
        if (map.containsKey(uuid)) return true;
        return false;
    }
}
