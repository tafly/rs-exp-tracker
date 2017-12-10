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

	String processURL(String player) {
		/*
		String content = null;
		URLConnection connection = null;

		String stats = null;
		
		
		try {
			connection = new URL("http://services.runescape.com/m=hiscore_oldschool/index_lite.ws?player=" + player).openConnection();
			
			Scanner scanner = new Scanner(connection.getInputStream());
			scanner.useDelimiter("\\Z");
			//stats = scanner.next();
			
			scanner.close();			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		*/
		String stats = null;
		
		try {
			URL url = new URL("http://services.runescape.com/m=hiscore_oldschool/index_lite.ws?player=" + player);
			URLConnection urlConn = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));
			
			String inputLine;
			StringBuilder a = new StringBuilder();
			
			while ((inputLine = in.readLine()) != null) {
				a.append(inputLine + "\n");
			}
			
			in.close();
			
			stats = a.toString();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return stats;

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

	void processSkill(String player) {
		String stats = processURL(player);
		String[] statsArray = stats.split("\n");
		int statnumber = 0;
		boolean skillexists;
		skillexists = false;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Skill?");
		String skill = input.next();
		
		
		switch (skill) {
		case "Cooking":
			statnumber = 8;	
			skillexists = true;
			break;
		case "Woodcutting":
			statnumber = 9;	
			skillexists = true;
			break;
		case "Fletching":
			statnumber = 10;	
			skillexists = true;
			break;
		case "Fishing":
			statnumber = 11;	
			skillexists = true;
			break;
		case "Firemaking":
			statnumber = 12;	
			skillexists = true;
			break;
		case "Crafting":
			statnumber = 13;	
			skillexists = true;
			break;
		case "Smithing":
			statnumber = 14;	
			skillexists = true;
			break;
		case "Mining":
			statnumber = 15;	
			skillexists = true;
			break;
		case "Herblore":
			statnumber = 16;	
			skillexists = true;
			break;
		case "Agility":
			statnumber = 17;	
			skillexists = true;
			break;
		case "Thieving":
			statnumber = 18;	
			skillexists = true;
			break;
		case "Slayer":
			statnumber = 19;	
			skillexists = true;
			break;
		case "Farming":
			statnumber = 20;	
			skillexists = true;
			break;
		case "Runecraft":
			statnumber = 21;	
			skillexists = true;
			break;
		case "Hunter":
			statnumber = 22;	
			skillexists = true;
			break;
		case "Construction":
			statnumber = 23;
			skillexists = true;
			break;
		default:
			System.out.println("Unknown skill!");
		}
		
		
		if (skillexists = true) {
			String[] statsplit = statsArray[statnumber].split(",");
			
			System.out.println(skill + " rank is " + String.format("%,d",Integer.parseInt(statsplit[0])));
			System.out.println(skill + " level is " + String.format("%,d",Integer.parseInt(statsplit[1])));
			System.out.println(skill + " xp is " + String.format("%,d",Integer.parseInt(statsplit[2])));
		}
		
		input.close();
	}

}
