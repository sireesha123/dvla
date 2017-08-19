package websiteFiles.stepDefinitions;

import websiteFiles.utils.fileDetails;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class dvla {

    public HashMap<String, fileDetails>  fileDetails() throws IOException {
        HashMap<String, fileDetails> sizesByExtension;

        String Directory = System.getProperty("user.dir") + "/src/main/resources/testData";

        sizesByExtension = sizesForDirectory(Directory, true);
        for (String ext : sizesByExtension.keySet()) {
        }
        return sizesByExtension;
    }

    private static HashMap<String, fileDetails> sizesForDirectory (String directory,boolean recurseInSubDirectories)
            throws IOException {

        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();

        HashMap<String, fileDetails> sizesByExtension = new HashMap<String, fileDetails>();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (!file.isDirectory()) {
                    String extension = file.getName().replaceAll(".*\\.", "");
                    String fileName = file.getName();
                    Long fileSize = file.length();
                    String memeType = file.toURL().openConnection().getContentType();
                    sizesByExtension.put(extension, new fileDetails(fileSize, fileName, memeType));
                }
            }
        }

        return sizesByExtension;
    }
}

