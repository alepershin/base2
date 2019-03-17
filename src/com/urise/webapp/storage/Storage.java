package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.io.IOException;
import java.util.List;

public interface Storage {

    void clear() throws IOException;

    void update(Resume resume) throws IOException;

    void save(Resume resume);

    Resume get(String uuid) throws IOException;

    void delete(String uuid) throws IOException;

    List<Resume> getAllSorted() throws IOException;

    int size();
}
