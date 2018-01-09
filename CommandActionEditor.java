package edu.columbia.msn2139;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <h1>Command Actions for Editor</h1>
 * This class contains the methods that correspond to the available commands for the editor.
 * The actual inputed text is stored in an ArrayList titled text.
 *  
 * @author Morgan Navarro (msn2139)
 * @version 1.0
 */
public class CommandActionEditor {

	public int lineNum = 0;
	private ArrayList<String> text = new ArrayList<String>();
	private String line = "";
	
	/**
	 * Loads a file from the directory.
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
		lineNum = text.size()-1;
		inFile.close();
	}
	
	/**
	 * Prints the full file in its text form.
	 */
	public void printFile() {
		for (String output : text) {
			System.out.println(output);
		}
	}
	
	/**
	 * Prints the current line of the file.
	 */
	public void printLine() {
		System.out.println(text.get(lineNum));
	}
	
	/**
	 * Inserts a new line after the current line.
	 * Increments the line number.
	 * 
	 * @param sentence Line that is to be inserted (as inputed by user).
	 */
	public void insertAfter(String sentence) {
		if (text.isEmpty()) {
			text.add(0, sentence);
			lineNum++;
		}
		else {
			lineNum = text.size()-1;
			text.add(lineNum+1, sentence);
			lineNum++;
		}
	}
	
	/**
	 * Replaces the current line with the line that has been inputed by the user.
	 * 
	 * @param sentence Line that is to replace the current line (as inputed by user).
	 */
	public void replaceLine(String sentence) {
		text.set(lineNum, sentence);
	}
	
	/**
	 * Deletes the current line.
	 */
	public void deleteLine() {
		text.remove(lineNum);
		lineNum--;
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

	}
	
	/**
	 * Saves the file to the directory with .txt extension.
	 * Closes the system after the file has been saved.
	 * 
	 * @param fileName Desired name to save the file under.
	 */
	public void setFile(String fileName) throws IOException {
		PrintWriter outFile = new PrintWriter(new File(fileName + ".txt"));
		
		for (String output : text) {
			outFile.println(output);
		}
			
		System.out.println(fileName + " written. Goodbye!");
		outFile.close();
		System.exit(0);
	}
	
}