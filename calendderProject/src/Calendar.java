import java.util.Scanner;

public class Calendar{
	
	/**
	 * Commands:
	 * 	help
	 * 	displayMonth
	 * 	displayDay
	 * 	createEvent
	 * 	editEvent
	 * 	deleteEvent
	 * 	done
	 */
	
	public static final String ERR_INVALID = "Invalid command. Type \"help\" for the list of valid commands.";
	public static final String ERR_MONTH = "Invalid month (should be between 1-12).";
	public static final String ERR_DATE = "Invalid date.";
	public static final String ERR_EVENT_NOT_FOUND = "Event does not exist.";
	public static final String ERR_CREATE = "Event could not be created.";
	
	public static final String HELP = "Your commands are:\n\nhelp\ndisplayMonth\ndisplayDay\ncreateEvent\neditEvent\ndeleteEvent\ndone";
	public static final String ENTER = "Enter your command: ";
	
	public static final String help = "help";
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		String lastInput = "";
		boolean done = false;
		
		System.out.println("Welcome to your Planner.");
		System.out.println(HELP);
		lastInput = input.next();
		
		while (done == false){
			lastInput = input.next();
			System.out.println(lastInput);
			if (lastInput.equals(help)) {
				System.out.println(HELP);
			}
		}
		
	}
}