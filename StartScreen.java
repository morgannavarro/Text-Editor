package edu.columbia.msn2139;

/**
 * <h1>Start Screen</h1>
 * This class is the start screen for both the text editing and compressing systems.
 * The class displays the available commands for the system.
 * 
 * @author Morgan Navarro (msn2139)
 * @version 1.0
 */
public class StartScreen {

	/**
	 * Displays the start screen and prints the commands to the user's screen.
	 */
	public void displayScreen() {
		System.out.println("Welcome to the Text Editor!");
		System.out.println();
		System.out.println("Available Commands Include:");
		System.out.println("g - Get file from directory");
		System.out.println("p - Print entire file to console");
		System.out.println("c - Print current line to console:");
		System.out.println("i - Insert after this line");
		System.out.println("r - Replace this line");
		System.out.println("d - Delete this line");
		System.out.println("^ - Go up one line");
		System.out.println("v - Go down one line");
		System.out.println("s - Set file to directory");
		System.out.println("w - Change word");
		System.out.println("q - Quit program");
		System.out.println();
		System.out.println();
		System.out.println("Start editing!");
	}
	
}
