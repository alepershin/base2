package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapResumeStorageTest {
    private MapResumeStorage mapResumeStorage = new MapResumeStorage();

    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME_1 = new Resume(UUID_1, "fullName1");

    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME_2 = new Resume(UUID_2, "fullName2");

    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME_3 = new Resume((UUID_3), "fullName3");

    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_4 = new Resume((UUID_4), "fullName4");

    @Before
    public void setUp() throws Exception {
        mapResumeStorage.clear();
        mapResumeStorage.save(RESUME_1);
        mapResumeStorage.save(RESUME_2);
        mapResumeStorage.save(RESUME_3);
    }

    @Test
    public void size() {
        assertEquals(3, mapResumeStorage.size());
    }

    @Test
    public void get() throws Exception {
        assertEquals(RESUME_1, mapResumeStorage.get(RESUME_1.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        mapResumeStorage.get(UUID_4);
    }

    @Test
    public void getSearchKey() {
        assertTrue(mapResumeStorage.getSearchKey(RESUME_1.getUuid())==UUID_1);
        assertTrue(mapResumeStorage.getSearchKey(RESUME_2.getUuid())==UUID_2);
        assertTrue(mapResumeStorage.getSearchKey(RESUME_3.getUuid())==UUID_3);
    }

    @Test
    public void clear() {
        mapResumeStorage.clear();
        assertEquals(0, mapResumeStorage.size());
    }

    @Test
    public void update() throws Exception {
        Resume newResume = new Resume(UUID_1, "fullName1");
        mapResumeStorage.update(newResume);
        assertSame(newResume, mapResumeStorage.get(newResume.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        mapResumeStorage.update(RESUME_4);
    }

    @Test
    public void save() throws Exception {
        mapResumeStorage.save(RESUME_4);
        assertEquals(4, mapResumeStorage.size());
        assertEquals(RESUME_4, mapResumeStorage.get(RESUME_4.getUuid()));
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        mapResumeStorage.save(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        mapResumeStorage.delete(UUID_1);
        assertEquals(2, mapResumeStorage.size());
        mapResumeStorage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        mapResumeStorage.delete(UUID_4);
    }
}