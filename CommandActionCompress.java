package edu.columbia.msn2139;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <h1>Command Actions for Compressor</h1>
 * This class contains the methods that correspond to the available commands for the compressor.
 * The actual inputed text is stored in an ArrayList titled text and the dictionary words are
 * stored in an ArrayList called finalWords.  The ArrayList wordLine holds all of the words in one
 * line of the text and the ArrayList words holds all of the words in the text.
 *  
 * @author Morgan Navarro (msn2139)
 * @version 1.0
 */
public class CommandActionCompress {

	public int lineNum = 0;
	private ArrayList<String> text = new ArrayList<String>();
	private String line = "";
	private List<String> finalWords;
	private List<String> words = new ArrayList<String>();
	private List<String> wordLine = new ArrayList<String>();
	
	/**
	 * Loads a file from the directory and compresses the file.
	 * Sets the line number equal to the last line of the text.
	 * 
	 * @param file The name of the file in the directory
	 */
	public void getFile(String file) throws FileNotFoundException {
		File fileName = new File(file);
		Scanner inFile = new Scanner(fileName);
	
		while (inFile.hasNextLine()) {
			line = inFile.nextLine();
			text.add(line);
		}
		compressFile();
		lineNum = text.size()-1;
		inFile.close();
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
	 * Prints the current line of the file.
	 * Calls upon the wordToNumber method to print the number references of the dictionary words.
	 */
	public void printLine() {
		for (String output : finalWords) {
			System.out.print(output + " ");
		}
		System.out.println();
		wordToNumber(lineNum);
		System.out.println();
	}
	
	/**
	 * Inserts a new line after the current line and compresses the file again.
	 * Increments the line number.
	 * 
	 * @param sentence Line that is to be inserted (as inputed by user).
	 */
	public void insertAfter(String sentence) {
		if (text.isEmpty()) {
			text.add(0, sentence);
			lineNum++;
			compressFile();
		}
		else {
			lineNum = text.size()-1;
			text.add(lineNum+1, sentence);
			lineNum++;
			compressFile();
		}
	}
	
	/**
	 * Replaces the current line with the line that has been inputed by the user.
	 * Compresses the file again.
	 * 
	 * @param sentence Line that is to replace the current line (as inputed by user).
	 */
	public void replaceLine(String sentence) {
		text.set(lineNum, sentence);
		compressFile();
	}
	
	/**
	 * Deletes the current line.
	 * Compresses the file again and lowers the line number by 1.
	 */
	public void deleteLine() {
		text.remove(lineNum);
		lineNum--;
		compressFile();
	}
	
	/**
	 * Allows the user to go up on line by lowering the line number by 1.
	 */
	public void goUp() {
		lineNum--;
	}
	
	/**
	 * Allows the user to go down one line by increasing the line number by 1.
	 */
	public void goDown() {
		lineNum++;
	}
	
	/**
	 * Replaces the first word in the command with the second word.
	 * Compresses file after replacing the word.
	 * 
	 * @param ln Line that holds both words, the first word is the word being replaced by
	 * 			the second word.
	 */
	public void changeWord(String ln) {
		String oldWord = "";
		String newWord = "";
		String newLine = "";
		String[] change = ln.split(" ");
		oldWord = change[0];
		newWord = change[1];
		
		List<String> sentence = new ArrayList<String>();
		
		for (int i=0; i<text.size(); i++){
			newLine = "";
			sentence.clear();
			sentence.addAll(Arrays.asList(text.get(i).split(" ")));
			while(sentence.contains(oldWord)) {
				sentence.set(sentence.indexOf(oldWord), newWord);
			}
			for (String element : sentence) {
				newLine += element + " ";
			}
			text.set(i, newLine);
		}
		compressFile();

	}
	
	/**
	 * Saves the file to the directory with .cmp extension.
	 * This method calls on the printToFile method to run through the ArrayList and print
	 * the dictionary and numerical values. Closes the system after the file has been saved.
	 * 
	 * @param fileName Desired name to save the file under.
	 */
	public void setFile(String fileName) throws IOException {
		PrintWriter outFile = new PrintWriter(new File(fileName + ".cmp"));
		compressFile();
		
		for (String output : finalWords) {
			outFile.print(output + " ");
		}
		outFile.println();
		
		for (int i=0; i<text.size(); i++) {
			outFile.print(printToFile(i) + " ");
			outFile.println();
		}	
		System.out.println(fileName + " written. Goodbye!");
		outFile.close();
		System.exit(0);
	}
	
	/**
	 * Compresses the file and creates a new ArrayList with the dictionary words.
	 * Each line in the text ArrayList is split into its components and added to a
	 * LinkedHashSet that does not allow for duplicate values.
	 */
	public void compressFile() {
		words = new ArrayList<String>();
		for (String line : text){
			words.addAll(Arrays.asList(line.split(" ")));
		}
		finalWords = new ArrayList<String>(new LinkedHashSet<String>(words));
	}
	
	/**
	 * Determines the numerical value of each word in the text.
	 * Compares each word to the list of dictionary words and prints the number value for
	 * each word.
	 * 
	 * @param lineNumber Current lineNumber to be printed.
	 */
	public void wordToNumber(int lineNumber) {
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
	public String printToFile(int lineNumber) {
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
