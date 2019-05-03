package com.urise.webapp;

import java.io.File;

public class MainFile {
    private static void printDirectoryDeeply(File dir, String offset) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(offset + file.getName());
                if (file.isDirectory()){
                    printDirectoryDeeply(file, offset + "\t");
                }
            }
        }
    }

    public static void main(String[] args) {
        File pathFile = new File("C:\\basejava");
        try {
            printDirectoryDeeply(pathFile, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}