package com.jcourse.gaas.html;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class HtmlGen {
    public static void main(String[] args) {
        File dir = new File(".");
        if (dir.isDirectory()) {
            File[] filesInDirectory = dir.listFiles();
            Arrays.sort(filesInDirectory, new Comparator<File>() {
                @Override
                public int compare(File fileOne, File fileTwo) {
                    return fileOne.getName().compareTo(fileTwo.getName());
                }
            });

            for (File file : filesInDirectory) {
                Date date = new Date(file.lastModified());
                System.out.println("file name: " + file.getName());
                System.out.println("last modified file date: " + date);
                System.out.println("file length: " + file.length());
            }
        }
    }
}
