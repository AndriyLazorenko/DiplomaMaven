package View.Executable;

import Controller.GenomeDinucleotideFreq.ResultsProcessor;
import Controller.GenomeDinucleotideFreq.ProcessingDinucleotideFreq;
import Controller.InputProcessing.FileInput;
import Controller.InputProcessing.FolderInput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Class that runs process of gathering statistical data on occurrences of all dinucleotides
 * in given data.
 * @author andriylazorenko
 */

public class MainDinucleotideFreqs {

    public static void main(String[] args) {

        ResultsProcessor container = new ResultsProcessor();
        boolean continues = true;
        while (continues) {
            //Variables
            ProcessingDinucleotideFreq controller;
            String allFolder = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Do you want to process ENTIRE folder? Y/N");
            try {
                allFolder = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Block processing a folder

            if (allFolder.toLowerCase().startsWith("y")) {

                FolderInput folder = new FolderInput();
                String folderLocation = "";

                //Asking for folder location with a simple verification

                try {
                    folderLocation = folder.inputFolder();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Map<String, FileReader> files = folder.input(folderLocation);
                for (String s : files.keySet()) {
                    controller = new ProcessingDinucleotideFreq(s, files.get(s));
                    controller.addToDataContainer(container);
                }
            }

            //Block processing a file

            else {

                //Inputing file path + verification

                FileInput fileInput = new FileInput();
                FileReader fileReader = null;

                try {
                    fileReader = fileInput.input();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String oldFileName = "";
                oldFileName = fileInput.getAdjustedFileLocation();

                controller = new ProcessingDinucleotideFreq(oldFileName, fileReader);
                controller.addToDataContainer(container);

            }
            container.printContainerToConsole();
            container.writeContainerToFile();

            System.out.println("Do you want to continue? Y/N");
            String goOn = null;
            try {
                goOn = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (goOn.toLowerCase().startsWith("y")){
                continues = true;
            }
            else {
                continues = false;
            }
        }
    }
}
