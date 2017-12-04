import java.io.*;

public class Processing {
	void logSkill(String skill) {
		String fileName = "xprecords.txt";
		String line = null;

		switch (skill) {
		case "Agility":
			System.out.println("Agility");

			try {
				FileWriter fileWriter = new FileWriter(fileName);

				// Always wrap FileReader in BufferedReader.
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

				bufferedWriter.write("Test");

				// Always close files.
				bufferedWriter.close();

			} catch (IOException ex) {
				System.out.println("Error reading file '" + fileName + "'");
				// Or we could just do this:
				// ex.printStackTrace();
			}

			break;

		default:
			System.out.println("Unknown skill!");
		}
	}
}
