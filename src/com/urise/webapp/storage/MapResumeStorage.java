package com.urise.webapp.storage;

import java.util.*;

import static com.urise.webapp.storage.AbstractArrayStorage.*;

public class MapResumeStorage extends AbstractStorage {
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
        map.remove(uuid);
    }

    @Override
    protected void doSave(Resume resume, Object uuid) {
        map.put((String) uuid, resume);
    }

    @Override
    protected Resume doGet(Object uuid) {
        return map.get(uuid);
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
    protected boolean isExist(Object uuid){
        if (map.containsKey(uuid)) return true;
        return false;
    }
}
