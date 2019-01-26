package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public abstract class AbstractStorageTest {
    Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final AbstractArrayStorage.Resume RESUME_1 = new AbstractArrayStorage.Resume(UUID_1, "fullName1");

    private static final String UUID_2 = "uuid2";
    private static final AbstractArrayStorage.Resume RESUME_2 = new AbstractArrayStorage.Resume(UUID_2, "fullName2");

    private static final String UUID_3 = "uuid3";
    private static final AbstractArrayStorage.Resume RESUME_3 = new AbstractArrayStorage.Resume(UUID_3, "fullName3");

    private static final String UUID_4 = "uuid4";
    private static final AbstractArrayStorage.Resume RESUME_4 = new AbstractArrayStorage.Resume(UUID_4, "fullName4");

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void get() throws Exception {
        assertEquals(RESUME_1, storage.get(RESUME_1.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get(UUID_4);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        AbstractArrayStorage.Resume newResume = new AbstractArrayStorage.Resume(UUID_1, "fullName1");
        storage.update(newResume);
        assertSame(newResume, storage.get(newResume.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.update(RESUME_4);
    }

    @Test
    public void save() throws Exception {
        storage.save(RESUME_4);
        assertEquals(4, storage.size());
        assertEquals(RESUME_4, storage.get(RESUME_4.getUuid()));
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_1);
        assertEquals(2, storage.size());
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete(UUID_4);
    }
}