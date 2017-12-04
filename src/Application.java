import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		String command;
		Scanner input = new Scanner(System.in);

		System.out.println("What would you like to do?");
		command = input.next();

		switch (command) {
		case "1":
			System.out.println("Which skill?");
			break;

		default:
			System.out.println("What's that mean?");
			break;
		}
		
		input.close();
	}

}
