package edu.columbia.msn2139;

import java.io.IOException;
import java.util.*;

/**
 * <h1>User Input for Compressor</h1>
 * This class sets up the user input for the commands that manipulate the text in the
 * text compressor system.  The class has a method that prompts the user for their
 * command and a method that runs the prompt until the user presses Q for quit.
 * 
 * @author Morgan Navarro (msn2139)
 * @version 1.0
 */
public class UserInputCompress {
	private String commandString = "";
	public Command userCommand;
	CommandActionCompress runCommand = new CommandActionCompress();
	
	/**
	 * Enumeration for the available commands in the system.
	 * G is get file, P is print file, C is print line, I is insert line, R is replace line
	 * D is delete line, U(^) is go up one line, V is go down one line, S is set the file to directory,
	 * W is change word to another word, and Q is quit.
	 *
	 */
	private enum Command {
		G, P, C, I, R, D, U, V, S, W, Q;
		
	}
	
	/**
	 * Method of type command that prompts the user for their command.
	 * This method checks to make sure that the input was valid and it returns the command that
	 * was selected. The method also runs the command by calling upon the desired command action
	 * found in the CommandActionCompress class.
	 * 
	 * @return The user's selected command
	 */
	private Command promptUser() throws IOException {
		Scanner input = new Scanner(System.in);
		
		System.out.print(">");
		commandString = input.nextLine();
		
		
		if (commandString.charAt(0) == 'G' || commandString.charAt(0) == 'g' || commandString.charAt(0) == 'P' || commandString.charAt(0) == 'p' || commandString.charAt(0) == 'C' || commandString.charAt(0) == 'c' || commandString.charAt(0) == 'I' || commandString.charAt(0) == 'i' || commandString.charAt(0) == 'R' || commandString.charAt(0) == 'r' || commandString.charAt(0) == 'D' || commandString.charAt(0) == 'd' || commandString.charAt(0) == '^' || commandString.charAt(0) == 'V' || commandString.charAt(0) == 'v' || commandString.charAt(0) == 'S' || commandString.charAt(0) == 's' || commandString.charAt(0) == 'W' || commandString.charAt(0) == 'w'|| commandString.charAt(0) == 'Q' || commandString.charAt(0) == 'q') {
			
			if (commandString.charAt(0) == 'G' || commandString.charAt(0) == 'g') {
				if (commandString.length() > 2) {
					runCommand.getFile(commandString.substring(2));
					return Command.G;
				}
				else if (commandString.length() < 2) {
					//Create new file
					return Command.G;
				}
				
			}
			else if (commandString.charAt(0) == 'P' || commandString.charAt(0) == 'p') {
				runCommand.printFile();
				return Command.P;
			}
			else if (commandString.charAt(0) == 'C' || commandString.charAt(0) == 'c') {
				runCommand.printLine();
				return Command.C;
			}
			else if (commandString.charAt(0) == 'I' || commandString.charAt(0) == 'i') {
				runCommand.insertAfter(commandString.substring(2));
				return Command.I;
			}
			else if (commandString.charAt(0) == 'R' || commandString.charAt(0) == 'r') {
				runCommand.replaceLine(commandString.substring(2));
				return Command.R;
			}
			else if (commandString.charAt(0) == 'D' || commandString.charAt(0) == 'd') {
				runCommand.deleteLine();
				return Command.D;
			}
			else if (commandString.charAt(0) == '^') {
				runCommand.goUp();
				return Command.U;
			}
			else if (commandString.charAt(0) == 'V' || commandString.charAt(0) == 'v') {
				runCommand.goDown();
				return Command.V;
			}
			else if (commandString.charAt(0) == 'S' || commandString.charAt(0) == 's') {
				runCommand.setFile(commandString.substring(2));
				return Command.S;
			}
			else if (commandString.charAt(0) == 'W' || commandString.charAt(0) == 'w') {
				runCommand.changeWord(commandString.substring(2));
				return Command.W;
			}
			else if (commandString.charAt(0) == 'Q' || commandString.charAt(0) == 'q') {
				System.out.println("Goodbye!");
				return Command.Q;
			}
		}
		return promptUser(); //Prompt user again if input was invalid
	}
	
	/**
	 * Runs the user prompt until the user presses Q for quit.
	 *
	 */
	public void runPrompt() throws IOException {
		
		do {
			userCommand = promptUser();
			
		} while (!userCommand.equals(Command.Q));
		
	}
	
}