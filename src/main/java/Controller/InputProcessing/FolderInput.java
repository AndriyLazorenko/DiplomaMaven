package Controller.InputProcessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Master on 28-Apr-15.
 */
public class FolderInput extends PathProcessing {

    public String inputFolder() throws IOException {
        do {
            setLocationIsCorrect(true);
            System.out.println("Insert folder location from Windows Explorer");
            setFileLocation(getBr().readLine());
            setAdjustedFileLocation(getFileLocation().replaceAll("\\\\", "\\\\\\\\"));

            //In case filepath given, not folder path

            if(getAdjustedFileLocation().contains(".txt"))
            setAdjustedFileLocation(getAdjustedFileLocation().substring(0,getAdjustedFileLocation().lastIndexOf("\\")-1));

            //Checking the file path (may consider extra checks)

            File f = new File (getAdjustedFileLocation());
            String [] namesOfFilesInFolder = f.list();
            for (String s: namesOfFilesInFolder){
                if (s.contains(".txt")){
                    setLocationIsCorrect(true);
                    break;
                }
                else setLocationIsCorrect(false);
            }
        } while (isLocationIsCorrect() == false);
        return getAdjustedFileLocation();
    }

    public Map<String,FileReader> input(String folderLocation){

        //Determining size of array depending on number of files to process

        Map <String,FileReader> forRet = new LinkedHashMap<>();
        int counterOfTxtFiles=0;
        File f = new File (getAdjustedFileLocation());
        String [] namesOfFilesInFolder = f.list();
        for (String s:namesOfFilesInFolder){
            if (s.contains(".txt")&&!s.contains("Info")){       //extra check so that our program doesn't include info file
                counterOfTxtFiles++;
            }
        }
        String [] usefulFiles = new String[counterOfTxtFiles];
        FileReader[] frArray = new FileReader[counterOfTxtFiles];

        //Creating a map of file destinations (key) and file contents (value)

        int position=0;
        for (String s:namesOfFilesInFolder){
            if (s.contains(".txt")&&!s.contains("Info")){       //extra check so that our program doesn't include info file
                usefulFiles[position] = folderLocation+"\\\\" + s;
                try {
                    frArray[position]= new FileReader(usefulFiles[position]);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                forRet.put(usefulFiles[position],frArray[position]);
                position++;
            }
        }
        return forRet ;
    }
}
