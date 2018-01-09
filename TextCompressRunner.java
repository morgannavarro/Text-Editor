package edu.columbia.msn2139;

import java.io.IOException;

/**
 * <h1>Tiny Text Compressing System</h1>
 * This system is a tiny text compressor with basic commands for getting a file,
 * printing a file, printing a line, inserting a line, replacing a line,
 * deleting a line, moving up a line, moving down a line, saving a file
 * to a directory, and exiting the system.
 * The system takes in user input and edits the text based on the commands
 * given by the user.
 * This runner class calls upon the necessary helper classes and methods
 * for the system to work as described.
 * The file is printed as a compressed file with a dictionary at the top
 * and numbers corresponding to the words being printed underneath.
 * 
 * Test Cases:
 * Test 1 - Creates a new file and inserts lines into the file.  Utilizes all of the available
 * commands of the Text Editor. Saves the file as "myFileCmp" (size 40 bytes). This file was 
 * not smaller than the non-compressed file created using the TextEditorRunner because this file
 * is very small and it only has one line.  The non-compressed file is saved as a file with one
 * line; however, the compressed file has to include the dictionary and the numerical references
 * for the words - which creates a file that is larger.
 * 
 * Test 2 - Gets a file named "yodaText" from the directory and manipulates/compresses the file using
 * the editor's commands.  Changes a line in the file and saves the file under the name
 * "newYodaTextCmp" (size 115 bytes). This compressed file was actually smaller than the
 * non-compressed file by about 13 bytes.
 * 
 * Test 3 - Creates a new file and saves the empty file as "blankText" (size 1 byte). This compressed
 * empty file is most likely larger than its non-compressed version because of the .cmp file type.
 * 
 * @author Morgan Navarro (msn2139)
 * @version 1.0
 */
public class TextCompressRunner {

	/**
	 * Constructor for TextCompress that creates new instances of a start screen and user input.
	 * This constructor also displays the start screen and calls the method to prompt for input.
	 */
	public TextCompressRunner() throws IOException {
		StartScreen start = new StartScreen();
		start.displayScreen();
		UserInputCompress input = new UserInputCompress();
		input.runPrompt();
	}

	/**
	 * Main method that creates a new instance of TextCompressRunner.
	 */
	public static void main(String[] args) throws IOException {
		new TextCompressRunner();
		
	}
	
}
