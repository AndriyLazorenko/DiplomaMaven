package Controller.InputProcessing;

import java.io.*;

/**
 * Abstract class that has common variables and methods for classes FileInput and FolderInput
 * It is responsible for correct input of data
 * @author andriylazorenko
 */

public abstract class PathProcessing {

    /**
     * Variables
     */

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private boolean locationIsCorrect;
    private String fileLocation;
    private String adjustedFileLocation;
    private String fileName;
    private FileReader fileReader;

    /**
     * Getters and Setters
     */

    public BufferedReader getBr() {
        return br;
    }

    public boolean isLocationIsCorrect() {
        return locationIsCorrect;
    }

    public void setLocationIsCorrect(boolean locationIsCorrect) {
        this.locationIsCorrect = locationIsCorrect;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getAdjustedFileLocation() {
        return adjustedFileLocation;
    }

    public void setAdjustedFileLocation(String adjustedFileLocation) {
        this.adjustedFileLocation = adjustedFileLocation;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    /**
     * Method checks if location is correct and returns FileReader object if all the checks are passed
     * @return FileReader object from source file with data
     * @throws IOException
     */

    public FileReader input() throws IOException {

        do {
            setLocationIsCorrect(true);
            System.out.println("Insert file location from Windows Explorer");
            setFileLocation(getBr().readLine());
            setAdjustedFileLocation(getFileLocation().replaceAll("\\\\", "\\\\\\\\"));
            if (getAdjustedFileLocation().contains(".txt")) {

            } else {
                System.out.println("Insert file name in following format: Filename.txt");
                setFileName(getBr().readLine());
                setAdjustedFileLocation(getAdjustedFileLocation() + "\\\\\\\\" + getFileName());
            }

            //Checking the file path

            try {
                setFileReader(new FileReader(getAdjustedFileLocation()));
            } catch (FileNotFoundException e) {
                System.err.println("File location is incorrect. Try again =)");
                setLocationIsCorrect(false);
            }
        } while (isLocationIsCorrect() == false);

        return getFileReader();
    }

}
