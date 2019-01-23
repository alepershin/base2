package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapUuidStorageTest {
    private MapUuidStorage mapUuidStorage = new MapUuidStorage();

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
        mapUuidStorage.clear();
        mapUuidStorage.save(RESUME_1);
        mapUuidStorage.save(RESUME_2);
        mapUuidStorage.save(RESUME_3);
    }

    @Test
    public void size() {
        assertEquals(3, mapUuidStorage.size());
    }

    @Test
    public void get() throws Exception {
        assertEquals(RESUME_1, mapUuidStorage.get(RESUME_1.getUuid()));
    }

/*
    @Test
    public void getAll() {
        Resume[] array = mapUuidStorage.getAll();
        Resume[] resumes = {RESUME_1, RESUME_2, RESUME_3};
        Assert.assertTrue(mapUuidStorage.size() == array.length);
        Arrays.sort(array);
        Arrays.sort(resumes);
        Assert.assertArrayEquals(array, resumes);
    }
*/

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        mapUuidStorage.get(UUID_4);
    }

    @Test
    public void getSearchKey() {
        assertTrue(mapUuidStorage.getSearchKey(RESUME_1.getUuid())==UUID_1);
        assertTrue(mapUuidStorage.getSearchKey(RESUME_2.getUuid())==UUID_2);
        assertTrue(mapUuidStorage.getSearchKey(RESUME_3.getUuid())==UUID_3);
    }

    @Test
    public void clear() {
        mapUuidStorage.clear();
        assertEquals(0, mapUuidStorage.size());
    }

    @Test
    public void update() throws Exception {
        Resume newResume = new Resume(UUID_1, "fullName1");
        mapUuidStorage.update(newResume);
        assertSame(newResume, mapUuidStorage.get(newResume.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        mapUuidStorage.update(RESUME_4);
    }

    @Test
    public void save() throws Exception {
        mapUuidStorage.save(RESUME_4);
        assertEquals(4, mapUuidStorage.size());
        assertEquals(RESUME_4, mapUuidStorage.get(RESUME_4.getUuid()));
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        mapUuidStorage.save(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        mapUuidStorage.delete(UUID_1);
        assertEquals(2, mapUuidStorage.size());
        mapUuidStorage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        mapUuidStorage.delete(UUID_4);
    }
}