package Controller;


import Controller.GenomeDinucleotideFreq.AllResultsContainer;
import Controller.InputProcessing.FileInput;
import Controller.InputProcessing.FolderInput;
import Controller.InputProcessing.AlleleValidation;
import Properties.Results;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * A giant super-duper-class, UBER - controller, who knows just about everyone and pulls all the
 * stuff together. A clear anti-pattern applied here. Scheduled for massive refactoring and decoupling
 * Functions as a console - user interface, controller logic to access all other classes.
 * Contains internal classes: abstract class Processing, FolderProcessing and FileProcessing
 * @author andriylazorenko
 */

public class Controller {

    /**
     * Variables
     */

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
    protected BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private AllResultsContainer adjustedFreq = new AllResultsContainer();

    /**
     * Main method. Does everything
     * @throws IOException
     */

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

                folderProcessing = new FolderProcessing(allele,folder,adjustedFreq);
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

                fileProcessing = new FileProcessing(allele,adjustedFreq);
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

    /**
     * The internal abstract class contains common methods and variables for both FileProcessing
     * internal class and FolderProcessing internal class.
     * @author andriylazorenko
     */

    private abstract class Processing {

        /**
         * Variables
         */

        protected String allele;
        protected Allele chosenAllele;
        protected ResultsDB chosenResultsDB;
        protected AllResultsContainer adjustedFreq;

        /**
         * Getters and Setters
         */

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

        /**
         * Method for creating chosenAllele object and chosenResults DB object
         * @parameter allele - String value is required for correct work of method
         * @parameter adjustedFreq - AllResultsContainer object is required for correct work of method
         */

        protected void setVariables(){
            if (allele.equals("R")||allele.equals("Y")||
                    allele.equals("K")||allele.equals("M")||
                    allele.equals("W")||allele.equals("S")){
                setChosenAllele(new Allele(allele));
                setChosenResultsDB(new ResultsDB(allele,adjustedFreq));
            }
        }

        /**
         * Abstract method for processing a specific Allele
         * @throws IOException
         */

        protected abstract void processingAllele () throws IOException;
    }

    /**
     * A class for processing a folder as an input source. Contains controller logic as well as
     * console user interface necessary for processing a folder
     * @author andriylazorenko
     */

    private class FolderProcessing extends Processing {

        /**
         * Variables
         */

        private FolderInput folder;

        /**
         * Constructor accepts String with variation allele, FolderInput object and AllResultsContainer
         * object containing info on frequency of dinucleotides' statistical appearance.
         * @param s - String with variation allele info
         * @param f - FolderInput object
         * @param adjustedFreq - AllResultsContainer object with statistical info
         */

        public FolderProcessing (String s, FolderInput f, AllResultsContainer adjustedFreq) {
            this.allele = s;
            this.folder = f;
            this.adjustedFreq= adjustedFreq;
        }

        /**
         * Method for processing Allele
         * @throws IOException
         */

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
                getChosenResultsDB().toFile(folderLocation + "/" + "smth.txt");
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

    /**
     * Class for processing only one file from filepath.
     * @author andriylazorenko
     */

    private class FileProcessing extends Processing{

        /**
         * Constructor accepts String with variation allele info as well as AllResultsContainer object
         * with info on statistical frequency of occurrence of dinucleotides
         * @param s
         * @param adjustedFreq
         */

        public FileProcessing (String s, AllResultsContainer adjustedFreq) {
            this.allele = s;
            this.adjustedFreq = adjustedFreq;
        }

        /**
         * Method that processes allele
         * @throws IOException
         */

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
