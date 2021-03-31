import java.io.BufferedReader;
import java.io.File.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadCSV{
    Scanner src=null;

// method processFilesForValidation where we are going to paramaterize it with an csv, json,
    public static void processFilesForValidation(String inputFileName , PrintWriter json, PrintWriter log,
                                                 Scanner csv)
    {

    }



    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("----------------------CSV2JSON--------------------");
        System.out.println("Hello, welome to CSV2JSON software, where will we transform your CSV files to JSON files ");
        Scanner src = new Scanner(System.in);
        System.out.println("Can you please enter the number of files that we will be working with today :): ");
        int length = Integer.parseInt(src.nextLine());
        //Create the three arrays of each file
        String[] fileName = new String[length];
        Scanner[] csvFile = new Scanner[length];
        PrintWriter[] jsonFile = new PrintWriter[length];

        for (int i = 0; i < length; i++) {
            System.out.print("Enter the name of file " + (i + 1) + " :");
            fileName[i] = src.nextLine();
            try {
                csvFile[i] = new Scanner(new FileInputStream(fileName[i]));
            } catch (Exception e) {
                System.out.println("Could not open " + fileName[i] + " for reading");
                System.out.println("Please check if file exists! Program will terminate after closing all opened files");
                for (int j = i - 1; j >= 0; j--) {
                    csvFile[j].close();
                }
                System.exit(0);
            }
        }
        for (int i = 0; i < length; i++) {
            String s = fileName[i].substring(0, fileName[i].length() - 3) + "json";
            try {
                jsonFile[i] = new PrintWriter(new FileOutputStream(s));
            } catch (FileNotFoundException e) {
                System.out.println("Could not be create" + s + " for writing");
                System.out.println("Program will terminate after deleting all the files that were created and closing all that were opened");
                for (int j = i - 1; j >= 0; j--) {
                    jsonFile[j].close();
                    Files.deleteIfExists(Path.of(fileName[j].substring(0, fileName[j].length() - 3) + "json"));
                }
                for (int k = length - 1; k >= 0; k--) {
                    csvFile[k].close();
                }
                System.exit(0);
            }
        }
    }
}







