package application;

import java.io.File;
import java.util.ArrayList;

public class FileManager {
    private final File[] files;
    private final String extension;
    private final ArrayList<File> filteredFiles = new ArrayList<>();

    FileManager(String workingDirectoryPath, String extension) {
        File workingDirectory = new File(workingDirectoryPath);
        this.files = workingDirectory.listFiles();
        this.extension = extension;
    }

    public void deleteFilteredFiles() {
        for (File f : filteredFiles) {
            f.delete();
        }
    }

    public ArrayList<File> filterFiles() {
        return filterFiles(files);
    }

    private ArrayList<File> filterFiles(File[] files) {
        for (File f : files) {
            if (f.isDirectory()) {
                filterFiles(f.listFiles());
            } else if (fileHasCorrectExtension(f)) {
                filteredFiles.add(f);
            }
        }

        return filteredFiles;
    }

    private boolean fileHasCorrectExtension(File file) {
        return file.getName().contains("." + extension);
    }
}
