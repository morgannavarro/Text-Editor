package edu.columbia.msn2139;

import java.io.IOException;

/**
 * <h1>File Converter System</h1>
 * This system is a file converter that converts a .txt file to a .cmp compressed file.
 * The compressed file has a dictionary at the top with all of the unique words in the
 * text and numbers below that are references to the dictionary.
 * 
 * Test Cases:
 * Test 1 - Loads the file named "yodaText.txt" (size 129 bytes) from the directory and converts it
 * to the compressed file "yodaText.cmp" (size 111 bytes).
 * 
 * 
 * @author Morgan Navarro (msn2139)
 * @version 1.0
 */
public class FileConverterRunner {

	/**
	 * Constructor for FileConverterRunner that creates a new instance FileConverter.
	 * This constructor also calls upon the promptUser() method to ask the user for
	 * his/her file name.
	 */
	public FileConverterRunner() throws IOException {
		FileConverter convert = new FileConverter();
		convert.promptUser();
	}
	
	/**
	 * Main method that creates a new instance of FileConverterRunner.
	 */
	public static void main(String[] args) throws IOException {
		new FileConverterRunner();
		
	} 
}
