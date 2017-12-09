import java.io.*;
import java.util.Scanner;

public class Commands {
	void showCommands() {
		String command;
		Scanner input = new Scanner(System.in);

		System.out
				.println("What would you like to do? (1=Log XP Update, 2=Get Player stat By Skill, 3=Get Player Stats, 4=Update CML, q=quit)");
		command = input.next();

		Processing process = new Processing();

		switch (command) {
		case "1":
			// command to log an xp update to the txt file
			System.out.println("Which skill?");

			process.logSkill(input.next());
			break;
		case "2":
			// command to get players stat by skill, i.e. agility
			System.out.println("Which player?");

			
			break;
		case "3":
			// command to get all player stats
			System.out.println("Which player?");

			process.processURL(input.next());
			break;
		case "4":
			// command to update top level 3's in CML
			try {
				BufferedReader br = new BufferedReader(new FileReader(
						"toplvl3.txt"));

				for (String line = br.readLine(); line != null; line = br
						.readLine()) {
					process.updateCML(line);
				}

				br.close();
			} catch (IOException ex) {

			}

			
			break;
		case "q":
			// command to quit the application
			System.out.println("Program is terminating!");
			break;

		default:
			System.out.println("What's that mean?");
			break;
		}

		input.close();
	}
}
