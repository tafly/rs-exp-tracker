import java.io.*;
import java.util.Scanner;

public class Commands {
	void showCommands() {
		String command;
		Scanner input = new Scanner(System.in);

		System.out
				.println("What would you like to do? (1=Log XP Update, 2=Get Player Stats, 3=Update CML, q=quit)");
		command = input.next();

		Processing process = new Processing();

		switch (command) {
		case "1":
			System.out.println("Which skill?");

			process.logSkill(input.next());
			break;
		case "2":
			System.out.println("Which player?");

			process.processURL(input.next());
			break;
		case "3":

			try {
				BufferedReader br = new BufferedReader(new FileReader(
						"zplayers.txt"));

				for (String line = br.readLine(); line != null; line = br
						.readLine()) {
					process.updateCML(line);
				}

				br.close();
			} catch (IOException ex) {

			}

			
			break;
		case "q":
			System.out.println("Program is terminating!");
			break;

		default:
			System.out.println("What's that mean?");
			break;
		}

		input.close();
	}
}
