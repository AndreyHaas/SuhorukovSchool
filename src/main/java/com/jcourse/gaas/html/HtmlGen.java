package com.jcourse.gaas.html;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class HtmlGen {
    public static void main(String[] args) {
        File dir = new File(".");
        if (dir.isDirectory()) {
            File[] filesInDirectory = dir.listFiles();
            if (filesInDirectory != null) {
                Arrays.sort(filesInDirectory, (fileOne, fileTwo) -> fileOne.getName().compareTo(fileTwo.getName()));
            }

            for (File file : filesInDirectory) {
                Date date = new Date(file.lastModified());
                System.out.println("file name: " + file.getName());
                System.out.println("last modified file date: " + date);
                System.out.println("file length: " + file.length());
            }
        }
    }
}
