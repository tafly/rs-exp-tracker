import java.util.Scanner;


public class Commands {
	void showCommands() {
		String command;
		Scanner input = new Scanner(System.in);

		System.out.println("What would you like to do?");
		command = input.next();
		
		Processing process = new Processing();
		

		switch (command) {
		case "1":
			System.out.println("Which skill?");
			
			process.logSkill(input.next());
			break;

		default:
			System.out.println("What's that mean?");
			break;
		}
		
		input.close();
	}
}
