package Controller;


import Controller.InputProcessing.FileInput;
import Controller.InputProcessing.FolderInput;
import Controller.InputProcessing.AlleleValidation;
import Properties.Results;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Service {

    private AlleleValidation av = new AlleleValidation();
    private FolderProcessing folderProcessing;
    private FileProcessing fileProcessing;

    private String allele;
    private FileReader fileReader;
    private String oldFileName;
    private Results results;
    private String goOn;
    private boolean carryOn = true;
    private String allFolder;
    private String folderLocation;
    private Map<String,FileReader> folderFiles;
    private int counterOfFilesProcessed=0;
    private String variationAllele;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void consoleMenu () throws IOException {
        while (carryOn) {

            //Algorithm for processing entire folder

            System.out.println("Do you want to process ENTIRE folder? Y/N");
            allFolder = br.readLine();
            if (allFolder.equals("y") || allFolder.equals("Y")) {

                FolderInput folder = new FolderInput();

                //Asking for folder location with a simple verification

                folderLocation = folder.inputFolder();

                // Asking for Variation Allele + verification

                allele = av.ask();

                //Processing specific Allele depending on input

                folderProcessing = new FolderProcessing(allele,folder);
                folderProcessing.setVariables();
                folderProcessing.processingAllele();
            }
            else {

                //Inputing file path + verification

                FileInput fileInput = new FileInput();

                fileReader = fileInput.input();
                oldFileName = fileInput.getAdjustedFileLocation();

                // Asking for Variation Allele + verification

                allele = av.ask();

                //Processing specific Allele depending on input

                fileProcessing = new FileProcessing(allele);
                fileProcessing.setVariables();
                fileProcessing.processingAllele();

            }

            //Offer to continue work

            System.out.println("Do you want to continue? Y/N");
            goOn = br.readLine();
            if (goOn.equals("Y")||goOn.equals("y")){
                carryOn = true;
            }
            else {
                carryOn = false;
            }
        }
    }


    private abstract class Processing {

        //setVariables method can be improved to include multiple alleles

        protected String allele;
        private Allele chosenAllele;
        private ResultsDB chosenResultsDB;

        public Allele getChosenAllele() {
            return chosenAllele;
        }

        public void setChosenAllele(Allele chosenAllele) {
            this.chosenAllele = chosenAllele;
        }

        public ResultsDB getChosenResultsDB() {
            return chosenResultsDB;
        }

        public void setChosenResultsDB(ResultsDB chosenResultsDB) {
            this.chosenResultsDB = chosenResultsDB;
        }

        protected void setVariables(){
            if (allele.equals("R")){
                setChosenAllele(new Allele(allele));
                setChosenResultsDB(new ResultsDB(allele));
            }
            else if (allele.equals("Y")){
                setChosenAllele(new Allele(allele));
                setChosenResultsDB(new ResultsDB(allele));
            }
            else if (allele.equals("K")){
                setChosenAllele(new Allele(allele));
                setChosenResultsDB(new ResultsDB(allele));
            }
            else if (allele.equals("M")){
                setChosenAllele(new Allele(allele));
                setChosenResultsDB(new ResultsDB(allele));
            }
            else if (allele.equals("W")){
                setChosenAllele(new Allele(allele));
                setChosenResultsDB(new ResultsDB(allele));
            }
            else if (allele.equals("S")){
                setChosenAllele(new Allele(allele));
                setChosenResultsDB(new ResultsDB(allele));
            }
        }
        protected abstract void processingAllele () throws IOException;
    }


    private class FolderProcessing extends Processing {

        //setVariables method can be improved to include multiple alleles

        private FolderInput folder;

        public FolderProcessing (String s, FolderInput f) {
            this.allele = s;
            this.folder = f;
        }

        protected void processingAllele ()throws IOException {
        variationAllele = getChosenAllele().getVariationAllele();
            folderFiles = folder.input(folderLocation);
        for (String s : folderFiles.keySet()) {
            getChosenAllele().fastProcess(folderFiles.get(s), s);
            results = getChosenAllele().methodOfSearch();//Returns result
            getChosenResultsDB().parsingDBBehaviour.addToDB(results);//Passing results to database
            System.out.println(counterOfFilesProcessed++);
            getChosenAllele().erase();//all variables get killed
        }
        System.out.println(counterOfFilesProcessed + " files processed from folder");
        counterOfFilesProcessed = 0;

        //Working with database upon choice

        System.out.println("Do you want to work with database? Y/N");
        String choiceWork = br.readLine();
        if (choiceWork.equals("Y") || choiceWork.equals("y")) {

            //Printing database upon choice

            System.out.println("Do you want to print database? Y/N");
            String choicePrint = br.readLine();
            if (choicePrint.equals("Y") || choicePrint.equals("y")) {
                getChosenResultsDB().parsingDBBehaviour.compute();
                getChosenResultsDB().setResults(getChosenResultsDB().parsingDBBehaviour.creatingResults(variationAllele));
                getChosenResultsDB().print();
                getChosenResultsDB().clearResults();
            }

            //Writing database to file upon choice

            System.out.println("Do you want to write database to file? Y/N");
            String choiceWrite = br.readLine();
            if (choiceWrite.equals("Y") || choiceWrite.equals("y")) {
                getChosenResultsDB().parsingDBBehaviour.compute();
                getChosenResultsDB().setResults(getChosenResultsDB().parsingDBBehaviour.creatingResults(variationAllele));
                getChosenResultsDB().toFile(folderLocation + "\\\\\\\\" + "smth.txt");
                getChosenResultsDB().clearResults();
            }

            //Erasing database upon choice

            System.out.println("Do you want to ERASE ENTIRE DATABASE? Y/N");
            String choiceErase = br.readLine();
            if (choiceErase.equals("Y") || choiceErase.equals("y")) {
                getChosenResultsDB().erase();
            }
        }
    }
    }

    private class FileProcessing extends Processing{

        //setVariables method can be improved to include multiple alleles

        public FileProcessing (String s) {
            this.allele = s;
        }

        protected void processingAllele() throws IOException {

            variationAllele = getChosenAllele().getVariationAllele();
            getChosenAllele().fastProcess(fileReader, oldFileName);
            results = getChosenAllele().methodOfSearch();
            getChosenAllele().orderedPrint();

            //Printing a file upon choice

            System.out.println("Do you want to print these results to file? Y/N");
            String printChoice = br.readLine();
            if (printChoice.equals("Y") || printChoice.equals("y")) {
                getChosenAllele().toFile();
            }

                //Adding to database upon choice

                System.out.println("Do you want to add these results to overall "+getChosenAllele().getVariationAllele()+"-allele results database? Y/N");
                String choice = br.readLine();
                if (choice.equals("Y") || choice.equals("y")) {
                    getChosenResultsDB().parsingDBBehaviour.addToDB(results);
                }

                //Working with database upon choice

                System.out.println("Do you want to work with database? Y/N");
                String choiceWork = br.readLine();
                if (choiceWork.equals("Y") || choiceWork.equals("y")) {

                    //Printing database upon choice

                    System.out.println("Do you want to print database? Y/N");
                    String choicePrint = br.readLine();
                    if (choicePrint.equals("Y") || choicePrint.equals("y")) {
                        getChosenResultsDB().parsingDBBehaviour.compute();
                        getChosenResultsDB().setResults(getChosenResultsDB().parsingDBBehaviour.creatingResults(variationAllele));
                        getChosenResultsDB().print();
                        getChosenResultsDB().clearResults();
                    }

                    //Writing database to file upon choice

                    System.out.println("Do you want to write database to file? Y/N");
                    String choiceWrite = br.readLine();
                    if (choiceWrite.equals("Y") || choiceWrite.equals("y")) {
                        getChosenResultsDB().parsingDBBehaviour.compute();
                        getChosenResultsDB().setResults(getChosenResultsDB().parsingDBBehaviour.creatingResults(variationAllele));
                        getChosenResultsDB().toFile(oldFileName);
                        getChosenResultsDB().clearResults();
                    }

                    //Erasing database upon choice

                    System.out.println("Do you want to ERASE ENTIRE DATABASE? Y/N");
                    String choiceErase = br.readLine();
                    if (choiceErase.equals("Y") || choiceErase.equals("y")) {
                        getChosenResultsDB().erase();
                    }
                }
            getChosenAllele().erase();
        }
    }
}
