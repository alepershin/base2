package com.urise.webapp.storage;

import java.util.*;

import static com.urise.webapp.storage.AbstractArrayStorage.*;

public class MapUuidStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        map.put((String) searchKey, resume);
    }

    @Override
    protected void doDelete(Object uuid) {
        map.remove((String) uuid);
    }

    @Override
    protected void doSave(Resume resume, Object uuid) {
        map.put((String) uuid, resume);
    }

    @Override
    protected Resume doGet(Object uuid) {
        return map.get((String) uuid);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = new ArrayList<>(map.values());
        Collections.sort(list);
        return list;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected boolean isExist(Object uuid) {
        return map.containsKey(uuid);
    }
}
