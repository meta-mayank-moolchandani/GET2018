package virtualCommandPrompt;

import java.util.*;

public class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		VirtualCommandPrompt cmd = new VirtualCommandPrompt();

		do {
			System.out.print(cmd.getCurrentPath());

			String inputCommand = scan.nextLine().trim();

			if (!("".equals(inputCommand))) {

				if (cmd.isValidCommand(inputCommand)) {

					String input[] = inputCommand.split(" ");

					switch (input[0]) {
					case "cd":
						try {
							cmd.moveToDirectory(input[1]);

						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						System.out.println();
						break;
					case "mkdir":
						try {
							cmd.createDirectory(input[1]);
						} catch (Exception e) {
							System.out.print(e.getMessage());
						}
						System.out.println();
						break;
					case "bk":
						cmd.moveBackToParentDirectory();
						System.out.println();
						break;
					case "tree":
						System.out.println(cmd.getTree());
						System.out.println();
						break;
					case "find":
						System.out.println(cmd.findPaths(input[1]));
						break;
					case "ls":
						System.out.println(cmd.getListOfAllDirectoryOfFirstLevel());
						break;
					case "exit":
						System.exit(1);
						break;

					case "":
						System.out.println();
					default:
						System.out.println("ERROR: Invalid Command Input");

					}
				} else {
					System.out.println("ERROR : Invalid Command Input");
				}
			}

		} while (true);

	}
}
