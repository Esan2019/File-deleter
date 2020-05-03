package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    private static String fileFormat;
    private static ArrayList<File> filteredFiles = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter folder path that contains the files to delete: ");
        File folder = new File(sc.nextLine());
        System.out.print("Enter file format to delete (without dot): ");
        fileFormat = sc.nextLine();
        ArrayList<File> files = filterFiles(folder.listFiles());
        for (File f : files) {
            System.out.println(f.getName());
        }
        System.out.println();
        System.out.println("Total files found: " + files.size());
        System.out.println();
        System.out.print("Are you sure you want to delete all these files? (y/n) ");
        if(sc.nextLine().charAt(0) == 'y') {
            files.forEach(file -> file.delete());
            System.out.println("Successfully deleted " + files.size() + " files.");
        }
        sc.close();
    }

    private static ArrayList<File> filterFiles(File[] files) throws NullPointerException {
        for (File f : files) {
            if (f.isDirectory()) {
                File directory = new File(f.getAbsolutePath());
                filterFiles(directory.listFiles());
            }
            if (f.getName().contains("." + fileFormat)) {
                filteredFiles.add(f);
            }
        }
        return filteredFiles;
    }
}
