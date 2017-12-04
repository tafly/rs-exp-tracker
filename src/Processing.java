import java.io.*;
import java.util.Scanner;
import java.util.Date;

public class Processing {
	void logSkill(String skill) {
		String fileName = "xprecords.txt";
		String xpRecord;

		// String line = null;
		Date now = new Date();

		Scanner input = new Scanner(System.in);

		Commands commands = new Commands();

		try {
			FileWriter fileWriter = new FileWriter(fileName, true);

			// Always wrap FileReader in BufferedReader.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			// write details to file
			System.out.println("What is current xp?");
			xpRecord = (skill + "," + input.next() + "," + now.toString());
			bufferedWriter.write(xpRecord);
			bufferedWriter.newLine();

			// Always close files.
			bufferedWriter.close();

			commands.showCommands();

		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}

		input.close();
	}
}
