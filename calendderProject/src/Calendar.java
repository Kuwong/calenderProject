import java.util.Scanner;
import java.util.ArrayList;

//import java.io.FileNotFoundException;

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
	
	// Error message strings
	public static final String ERR_INVALID = "Invalid command. Type \"help\" for the list of valid commands.";
	public static final String ERR_MONTH = "Invalid month (should be between 1-12).";
	public static final String ERR_DATE = "Invalid date.";
	public static final String ERR_EVENT_NOT_FOUND = "Event(s) does not exist.";
	public static final String ERR_CREATE = "Event could not be created.";
	public static final String FILE_NOT_FOUND = "Event file could not be found.";
	
	// Misc message strings
	public static final String HELP = "Your commands are:\n\nhelp\ndisplayMonth\ndisplayDay\ndisplayEvents\ncreateEvent\neditEvent\ndeleteEvent\ndone\n";
	public static final String ENTER = "Enter your command: \n";
	
	/**
	 * Displays the calendar view of a month, and displays any events for that month underneath.
	 * 
	 * @param month
	 * @param year
	 * @param events
	 */
	public static void displayMonth(int month, int year, ArrayList<String> events) {
		
	}
	
	/**
	 * Displays the events for a given day to console.
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @param events
	 */
	public static void displayDay(int day, int month, int year, ArrayList<String> events) {
		
	}
	
	/**
	 * Displays the list of all events stored.
	 * 
	 * @param events
	 */
	public static void displayEvents(ArrayList<String> events) {
		
	}
	
	/**
	 * Receives input from console.
	 * Continuously waits for valid command.
	 * Outputs error when input != a valid command.
	 * Executes commands when input = command.
	 * Terminates after use of the "done" command.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		// A string is needed for the input so that the scanner only checks for input once.
		String lastInput = "";
		// Boolean used so that the program doesn't stop until the user is done.
		boolean done = false;
		
		System.out.println("Welcome to your Planner.");
		System.out.println(HELP);
		
		while (done == false){
			
			System.out.println(ENTER);
			lastInput = input.next();
			
			// Displays all valid commands.
			if (lastInput.equals("help")) {
				System.out.println(HELP);
			}
			// Asks for the month and year and passes these parameters to displayMonth method.
			if (lastInput.equals("displayMonth")) {
				System.out.println(ERR_MONTH);
			}
			// Asks for day, month, and year and passes these parameters to displayDay method.
			if (lastInput.equals("displayDay")) {
				System.out.println(ERR_DATE);
			}
			// Calls createEvent method in the createEvents class.
			if (lastInput.equals("createEvent")) {
				System.out.println(ERR_CREATE);
			}
			// Calls deleteEvent method in the createEvents class.
			if (lastInput.equals("deleteEvent")){
				System.out.println(ERR_EVENT_NOT_FOUND);
			}
			// Calls editEvent method in the createEvent class.
			if (lastInput.equals("editEvent")){
				System.out.println(ERR_EVENT_NOT_FOUND);
			}
			// Calls displayEvents method.
			if (lastInput.equals("displayEvents")) {
				System.out.println(ERR_EVENT_NOT_FOUND);
			}
			// Asks for verification, then saves events ArrayList to File with updateFile method in storeEvents, then terminates program.
			if (lastInput.equals("done")){
				System.out.println("Are you sure you want to exit? (Y/N)");
				if (input.next().toUpperCase().equals("Y")){
					done = true;
				}
			}
		}
		
		System.out.println("Done!");
		input.close();
		
	}
}