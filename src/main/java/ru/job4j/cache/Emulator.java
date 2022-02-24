package ru.job4j.cache;

import java.io.File;
import java.util.Scanner;

/**
 * 1. Реализация кеша на SoftReference [#1592]
 */
public class Emulator {
    public static void main(String[] args) {
        String directory = enterDirectory();
        DirFileCache dirFileCache = new DirFileCache(directory);
        while (true) {
            showListFiles(directory);
            String fileName = chooseFileName();
            System.out.println(dirFileCache.get(fileName));
            System.out.println();
        }
    }

    private static String enterDirectory() {
        String dir;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Укажите рабочую директорию или Exit для выхода: ");
            if (in.hasNextLine()) {
                dir = in.nextLine();
                if ("Exit".equalsIgnoreCase(dir)) {
                    System.exit(0);
                } else if (!new File(dir).isDirectory()) {
                    System.out.println("Директория не найдена.");
                } else {
                    break;
                }
            }
        }
        return dir;
    }

    private static String chooseFileName() {
        String fileName = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя файла или Exit для выхода: ");
        if (in.hasNextLine()) {
            fileName = in.nextLine();
            if ("Exit".equalsIgnoreCase(fileName)) {
                System.exit(0);
            }
        }
        return fileName;
    }

    private static void showListFiles(String directory) {
        File[] files = new File(directory).listFiles();
        System.out.println("Список файлов в директории:");
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }

}
