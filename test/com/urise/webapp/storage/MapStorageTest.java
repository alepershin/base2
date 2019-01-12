package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MapStorageTest {
    private MapStorage mapStorage = new MapStorage();

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
        mapStorage.clear();
        mapStorage.save(RESUME_1);
        mapStorage.save(RESUME_2);
        mapStorage.save(RESUME_3);
    }

    @Test
    public void size() {
        assertEquals(3, mapStorage.size());
    }

    @Test
    public void get() throws Exception {
        assertEquals(RESUME_1, mapStorage.get(RESUME_1.getUuid()));
    }

    @Test
    public void getAll() {
        Resume[] array = mapStorage.getAll();
        Resume[] resumes = {RESUME_1, RESUME_2, RESUME_3};
        Assert.assertTrue(mapStorage.size() == array.length);
        Arrays.sort(array);
        Arrays.sort(resumes);
        Assert.assertArrayEquals(array, resumes);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        mapStorage.get(UUID_4);
    }

    @Test
    public void getSearchKey() {
        assertTrue(mapStorage.getSearchKey(RESUME_1.getUuid())==UUID_1);
        assertTrue(mapStorage.getSearchKey(RESUME_2.getUuid())==UUID_2);
        assertTrue(mapStorage.getSearchKey(RESUME_3.getUuid())==UUID_3);
    }

    @Test
    public void clear() {
        mapStorage.clear();
        assertEquals(0, mapStorage.size());
    }

    @Test
    public void update() throws Exception {
        Resume newResume = new Resume(UUID_1, "fullName1");
        mapStorage.update(newResume);
        assertSame(newResume, mapStorage.get(newResume.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        mapStorage.update(RESUME_4);
    }

    @Test
    public void save() throws Exception {
        mapStorage.save(RESUME_4);
        assertEquals(4, mapStorage.size());
        assertEquals(RESUME_4, mapStorage.get(RESUME_4.getUuid()));
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        mapStorage.save(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        mapStorage.delete(UUID_1);
        assertEquals(2, mapStorage.size());
        mapStorage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        mapStorage.delete(UUID_4);
    }
}