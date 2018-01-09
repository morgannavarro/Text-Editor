package edu.columbia.msn2139;

import java.io.IOException;

/**
 * <h1>Tiny Text Editing System</h1>
 * This system is a tiny text editor with basic commands for getting a file,
 * printing a file, printing a line, inserting a line, replacing a line,
 * deleting a line, moving up a line, moving down a line, saving a file
 * to a directory, and exiting the system.
 * The system takes in user input and edits the text based on the commands
 * given by the user.
 * This runner class calls upon the necessary helper classes and methods
 * for the system to work as described.
 * 
 * Test Cases:
 * Test 1 - Creates a new file and inserts lines into the file.  Utilizes all of the available
 * commands of the Text Editor. Saves the file as "myFile" (size 25 bytes).
 * 
 * Test 2 - Gets a file named "yodaText" from the directory and manipulates the file using
 * the editor's commands.  Changes a line in the file and saves the file under the name
 * "newYodaText" (size 128 bytes).
 * 
 * Test 3 - Creates a new file and saves the empty file as "blankText" (size 0 KB).
 * 
 * @author Morgan Navarro (msn2139)
 * @version 1.0
 */
public class TextEditorRunner {

	/**
	 * Constructor for TextEditor that creates new instances of a start screen and user input.
	 * This constructor also displays the start screen and calls the method to prompt for input.
	 */
	public TextEditorRunner() throws IOException {
		StartScreen start = new StartScreen();
		start.displayScreen();
		UserInputEditor input = new UserInputEditor();
		input.runPrompt();
	}

	/**
	 * Main method that creates a new instance of TextEditorRunner.
	 */
	public static void main(String[] args) throws IOException {
		new TextEditorRunner();
		
	}
	
}
