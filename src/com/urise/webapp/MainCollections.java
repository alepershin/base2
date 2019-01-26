package com.urise.webapp;

import com.urise.webapp.storage.AbstractArrayStorage;

import java.util.*;

public class MainCollections {
    private static final String UUID_1 = "uuid1";
    private static final AbstractArrayStorage.Resume RESUME_1 = new AbstractArrayStorage.Resume(UUID_1, "fullName1");

    private static final String UUID_2 = "uuid2";
    private static final AbstractArrayStorage.Resume RESUME_2 = new AbstractArrayStorage.Resume(UUID_2, "fullName2");

    private static final String UUID_3 = "uuid3";
    private static final AbstractArrayStorage.Resume RESUME_3 = new AbstractArrayStorage.Resume(UUID_3, "fullName3");

    private static final String UUID_4 = "uuid4";
    private static final AbstractArrayStorage.Resume RESUME_4 = new AbstractArrayStorage.Resume(UUID_4, "fullName4");

    public static void main(String[] args) {
        Collection<AbstractArrayStorage.Resume> collection = new ArrayList<>();
        collection.add(RESUME_1);
        collection.add(RESUME_2);
        collection.add(RESUME_3);

        for (AbstractArrayStorage.Resume r : collection) {
            System.out.println(r);
            if (Objects.equals(r.getUuid(), UUID_1)) {
                collection.remove(r);
            }
        }

/*
        Iterator<Resume> iterator = collection.iterator();
        while (((Iterator) iterator).hasNext()){
            Resume r = iterator.next();
            System.out.println(r);
            if (Object.equals(r.getUuid(), UUID_1)) {
                iterator.remove();
            }
        }
        System.out.println(collection.toString());
*/

        Map<String, AbstractArrayStorage.Resume> map = new HashMap<>();
        map.put(UUID_1, RESUME_1);
        map.put(UUID_2, RESUME_2);
        map.put(UUID_3, RESUME_3);

        // Bad!
        for (String uuid : map.keySet()) {
            System.out.println(map.get(uuid));
        }

        for (Map.Entry<String, AbstractArrayStorage.Resume> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

        List<AbstractArrayStorage.Resume> resumes = Arrays.asList(RESUME_1, RESUME_2, RESUME_3);

    }
}