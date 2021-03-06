package edu.psgv.sweng861;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
/**
 * This class demonstrates how to read an ASCII text file and print it to the console.
 * @author Robert Rodini
 *
 */
public class TextFileReadPrint {
/**
 * main() accepts a single commmand line parameter.
 * @param arg[0] path to the input text file.
 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Missing command line argument w/ file name");
			System.exit(1);;
		}
		String lines;
		// Read text file into a String
		lines = readTextFile(args[0]);
		// Write file from string to text file
		printTextFile(lines);
	}
/**
 * readTextFile() reads the contents of a text file and returns a long string containing the lines of the file.
 * @param filePath path to the input file.
 * @return string with all lines from file.
 */
	private static String readTextFile(String filePath) {
		String lines = "";
		String line = "";
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(filePath);
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				// Don't forget to add the newline at the end.
				lines = lines + line + "\n";
			}
			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + filePath + "'");
			System.exit(2);
		} catch (IOException ex) {
			System.out.println("Error reading file '" + filePath + "'");
			System.exit(3);
		}
		return lines;
	}
/** 
 * printTextFile() prints the string line by line.
 * @param lines string with the lines of the input file. Each line is separated by a linefeed.
 */
	private static void printTextFile(String lines) {
		BufferedReader bufferedReader = new BufferedReader(new StringReader(lines));
		String line;
		try {
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("Error reading string");
			System.exit(4);
		}
	}

}
