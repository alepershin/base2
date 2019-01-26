package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new AbstractArrayStorage.Resume("fullName"));
            }
        } catch (StorageException e) {
            Assert.fail("Array overflow!");
        }
        storage.save(new AbstractArrayStorage.Resume("fullName"));
    }
}