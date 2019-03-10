package com.urise.webapp;

import java.io.File;
import java.io.PrintStream;

public class MainFile {
    public static void findFiles(File file, PrintStream output) {
        if (file.isDirectory()) {
            File[] list = file.listFiles();
            for (int i = list.length; --i >= 0; ) {
                findFiles(list[i], output);
            }
        } else {
            output.println(file.getName());
        }
    }

    public static void main(String[] args) {
        File pathFile = new File("C:\\basejava");
        try {
            findFiles(pathFile, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
