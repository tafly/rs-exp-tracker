import java.io.*;
import java.util.Scanner;
import java.util.Date;

public class Processing {
	void logSkill(String skill) {
		String fileName = "xprecords.txt";
		//String line = null;
		Date now = new Date();
		
		Scanner input = new Scanner(System.in);
		
		Commands commands = new Commands();
		
		
		switch (skill) {
		case "Agility":
			System.out.println("Agility");

			try {
				FileWriter fileWriter = new FileWriter(fileName, true);

				// Always wrap FileReader in BufferedReader.
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

				// write details to file
				bufferedWriter.write(skill);
				bufferedWriter.newLine();
				System.out.println("What is current xp?");
				bufferedWriter.write(input.next());
				bufferedWriter.newLine();
				bufferedWriter.write(now.toString());
				bufferedWriter.newLine();
				
				// Always close files.
				bufferedWriter.close();
				
				commands.showCommands();
				
			} catch (IOException ex) {
				System.out.println("Error reading file '" + fileName + "'");
				// Or we could just do this:
				// ex.printStackTrace();
			}

			break;

		default:
			System.out.println("Unknown skill!");
		}
		
		input.close();
	}
}
