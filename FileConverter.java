package edu.columbia.msn2139;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>File Converter</h1>
 * This class converts a file of type .txt to a compressed file of .cmp.
 * The class prompts the user for the file name to be converted and then
 * compresses the file and saves it with the .cmp extension.
 *  
 * @author Morgan Navarro (msn2139)
 * @version 1.0
 */
public class FileConverter {

	private ArrayList<String> text = new ArrayList<String>();
	private String line = "";
	private List<String> finalWords;
	private List<String> words = new ArrayList<String>();
	private List<String> wordLine = new ArrayList<String>();
	
	/**
	 * Prompts the user for the name of the file they want to convert.
	 * This method checks to make sure that the file name is valid and
	 * then it calls the convertFile method to begin the conversion
	 * process.
	 */
	public void promptUser() throws IOException {
		Scanner input = new Scanner(System.in);
		String fileName = "";
		
		System.out.println("Enter file name (no extension)> ");
		fileName = input.nextLine() + ".txt";
		File inFile = new File(fileName);
		
		if (inFile.exists()) {
			convertFile(inFile, fileName);
		}
		else {
			System.out.println("Invalid File Name");
			promptUser();
		}
		input.close();
	}
	
	/**
	 * Runs the methods needed to convert the file.
	 * Loads the file, prints the original file, compresses the file,
	 * prints the compressed file, and saves the compressed file.
	 * 
	 * @param file File that is being loaded.
	 * @param fileName Name of the file being loaded.
	 */
	private void convertFile(File file, String fileName) throws IOException {
		getFile(file);
		System.out.println("Original File:");
		for (String output : text) {
			System.out.println(output);
		}
		compressFile();
		System.out.println();
		System.out.println("Compressed File:");
		printFile();
		setFile(fileName);
	}
	
	/**
	 * Loads a file from the directory.
	 * 
	 * @param fileName File that is being loaded.
	 */
	private void getFile(File fileName) throws FileNotFoundException {
		File txtFile = fileName;
		Scanner inFile = new Scanner(txtFile);
	
		while (inFile.hasNextLine()) {
			line = inFile.nextLine();
			text.add(line);
		}
		inFile.close();
	}
	
	/**
	 * Compresses the file and creates a new ArrayList with the dictionary words.
	 * Each line in the text ArrayList is split into its components and added to a
	 * LinkedHashSet that does not allow for duplicate values.
	 */
	private void compressFile() {
		words = new ArrayList<String>();
		for (String line : text){
			words.addAll(Arrays.asList(line.split(" ")));
		}
		finalWords = new ArrayList<String>(new LinkedHashSet<String>(words));
	}
	
	/**
	 * Prints the full file in its compressed form.
	 * Calls upon the wordToNumber method to print the number references that 
	 * correspond to the dictionary words.
	 */
	public void printFile() {
		for (String output : finalWords) {
			System.out.print(output + " ");
		}
		System.out.println();
		
		for (int i=0; i<text.size(); i++) {
			wordToNumber(i);
			System.out.println();
		}	
	}
	
	/**
	 * Saves the file to the directory with .cmp extension.
	 * This method calls on the printToFile method to run through the ArrayList and print
	 * the dictionary and numerical values. Closes the system after the file has been saved.
	 * 
	 * @param fileName Desired name to save the file under.
	 */
	private void setFile(String fileName) throws IOException {
		PrintWriter outFile = new PrintWriter(new File(fileName.substring(0, fileName.length()-4) + ".cmp"));
		compressFile();
		
		for (String output : finalWords) {
			outFile.print(output + " ");
		}
		outFile.println();
		
		for (int i=0; i<text.size(); i++) {
			outFile.print(printToFile(i) + " ");
			outFile.println();
		}	
		System.out.println();
		System.out.println(fileName.substring(0, fileName.length()-4) + ".cmp written. Goodbye!");
		outFile.close();
		System.exit(0);
	}
	
	/**
	 * Determines the numerical value of each word in the text.
	 * Compares each word to the list of dictionary words and prints the number value for
	 * each word.
	 * 
	 * @param lineNumber Current lineNumber to be printed.
	 */
	private void wordToNumber(int lineNumber) {
		wordLine = new ArrayList<String>();
		wordLine.addAll(Arrays.asList(text.get(lineNumber).split(" ")));
		
		for (int i=0; i<wordLine.size(); i++) {
			for (int j=0; j<finalWords.size(); j++) {
				if (wordLine.get(i).equalsIgnoreCase(finalWords.get(j))) {
					System.out.print(j + " ");
				}
			}
		}
	}
	
	/**
	 * Creates a string of the numerical values for each line of the text.
	 * Returns this string in order for the system to print it out.
	 * 
	 * @param sentence Line that is to replace the current line (as inputed by user).
	 * @return String that consists of all of the number values.
	 */
	private String printToFile(int lineNumber) {
		wordLine = new ArrayList<String>();
		wordLine.addAll(Arrays.asList(text.get(lineNumber).split(" ")));
		String outputText = "";
		
		for (int i=0; i<wordLine.size(); i++) {
			for (int j=0; j<finalWords.size(); j++) {
				if (wordLine.get(i).equalsIgnoreCase(finalWords.get(j))) {
					outputText = outputText + j + " ";
				}
			}
		}
		return outputText;
	}
}
