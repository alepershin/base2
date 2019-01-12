package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListStorageTest {
    private ListStorage list = new ListStorage();

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
        list.clear();
        list.save(RESUME_1);
        list.save(RESUME_2);
        list.save(RESUME_3);
    }

    @Test
    public void size() {
        assertEquals(3, list.size());
    }

    @Test
    public void get() throws Exception {
        assertEquals(RESUME_1, list.get(RESUME_1.getUuid()));
    }

    @Test
    public void getAll() {
        Resume[] array = list.getAll();
        Resume[] resumes = {RESUME_1, RESUME_2, RESUME_3};
        Assert.assertTrue(list.size() == array.length);
        Assert.assertArrayEquals(resumes, array);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        list.get(UUID_4);
    }

    @Test
    public void getSearchKey() {
        assertTrue(list.getSearchKey(RESUME_1.getUuid()) == 0);
        assertTrue(list.getSearchKey(RESUME_2.getUuid()) == 1);
        assertTrue(list.getSearchKey(RESUME_3.getUuid()) == 2);
        assertTrue(list.getSearchKey(RESUME_4.getUuid()) == null);
    }

    @Test
    public void clear() {
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void update() throws Exception {
        Resume newResume = new Resume(UUID_1, "fullName1");
        list.update(newResume);
        assertSame(newResume, list.get(newResume.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        list.update(RESUME_4);
    }

    @Test
    public void save() throws Exception {
        list.save(RESUME_4);
        assertEquals(4, list.size());
        assertEquals(RESUME_4, list.get(RESUME_4.getUuid()));
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        list.save(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        list.delete(UUID_1);
        assertEquals(2, list.size());
        list.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        list.delete(UUID_4);
    }
}