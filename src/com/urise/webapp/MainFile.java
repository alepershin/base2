package com.urise.webapp;

import java.io.File;

public class MainFile {
    private static void printDirectoryDeeply(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                for (char c : file.getAbsolutePath().toCharArray()) {
                    if (c == '\\') {
                        System.out.print(" ");
                    }
                }
                System.out.println(file.getName());
                if (file.isDirectory()) {
                    printDirectoryDeeply(file);
                }
            }
        }
    }

    public static void main(String[] args) {
        File pathFile = new File("C:\\basejava");
        try {
            printDirectoryDeeply(pathFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}