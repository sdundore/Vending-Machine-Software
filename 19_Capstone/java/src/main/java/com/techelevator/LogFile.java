package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class LogFile {
	
	public boolean writeToFile(String msg) {
		boolean isWritten = true;
		String fileName = "log.txt";
		File file = new File(fileName);
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileOutputStream(file, true));
			writer.append(msg);
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("File cannot be written to");
			isWritten = false;
		} 
		return isWritten;
	}

}
