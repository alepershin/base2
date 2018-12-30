package com.urise.webapp.storage;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class AbstractArrayStorageTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(AbstractArrayStorage.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void size() {
    }

    @Test
    public void get() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void update() {
    }

    @Test
    public void save() {
    }

    @Test
    public void delete() {
    }
}
