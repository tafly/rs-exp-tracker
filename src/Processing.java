import java.net.*;
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

	void processURL(String player) {

		String content = null;
		URLConnection connection = null;
		
		try {
			connection = new URL("http://services.runescape.com/m=hiscore_oldschool/index_lite.ws?player=" + player).openConnection();
			
			Scanner scanner = new Scanner(connection.getInputStream());
			
			scanner.useDelimiter("\\Z");
			
			content = scanner.next();
			
			scanner.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println(content);

	}
	
	void updateCML(String player) {

		
		try {
			URL url = new URL("http://www.crystalmathlabs.com/tracker/api.php?type=update&player=" + player);
			URLConnection yc = url.openConnection();
			yc.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			// open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(yc.getInputStream()));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                    //System.out.println(inputLine);
            	System.out.println(player + " updated on CML (" + inputLine + ")");
            }
            br.close();

                     
            
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
}
