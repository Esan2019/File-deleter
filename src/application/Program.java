package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        printSpace();
        printMessage("Enter folder path that contains the files to delete: ");
        String folderPath = sc.nextLine();

        printSpace();
        printMessage("Enter file extension to delete (without dot): ");
        String fileExtension = sc.nextLine();

        FileManager fileManager = new FileManager(folderPath, fileExtension);

        ArrayList<File> filteredFiles = fileManager.filterFiles();
        final int amountOfFilteredFiles = filteredFiles.size();

        printSpace();

        printResultHeadlineBasedOn(amountOfFilteredFiles);
        printFilesNames(filteredFiles);

        if (amountOfFilteredFiles > 1) {
            printSpace();
            printMessage("Total files found: " + amountOfFilteredFiles);
        }

        printSpace();

        printDeleteConfirmationBasedOn(amountOfFilteredFiles);
        String userChoice = sc.nextLine();
        printSpace();

        if(userChoice.toLowerCase().charAt(0) == 'y') {
            fileManager.deleteFilteredFiles();
            printMessage("Successfully deleted " + amountOfFilteredFiles + " files.");
        } else {
            printMessage("Operation aborted.");
        }

        sc.close();
    }

    private static void printSpace() {
        System.out.println();
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printResultHeadlineBasedOn(int fileCount) {
        if (fileCount < 1) {
            printMessage("No file with the given extension was found.");
            System.exit(0);
        } else if (fileCount == 1) {
            printMessage("Only one file found:");
        } else {
            printMessage("List of files found:");
        }
    }

    private static void printDeleteConfirmationBasedOn(int fileCount) {
        final String prefix = "Are you sure you want to permanently delete";
        final String suffix = "? (y/n) ";

        if (fileCount > 1) {
            printMessage(prefix + " these files" + suffix);
        } else if (fileCount == 1) {
            printMessage(prefix + " this file" + suffix);
        }
    }

    private static void printFilesNames(ArrayList<File> files) {
        files.forEach(f -> printMessage(f.getName()));
    }
}
