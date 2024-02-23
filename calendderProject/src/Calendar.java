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
	
	public static final String HELP = "Your commands are:\n\nhelp\ndisplayMonth\ndisplayDay\ncreateEvent\neditEvent\ndeleteEvent\ndone\n";
	public static final String ENTER = "Enter your command: \n";
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		String lastInput = "";
		boolean done = false;
		
		System.out.println("Welcome to your Planner.");
		System.out.println(HELP);
		
		while (done == false){
			
			System.out.println(ENTER);
			lastInput = input.next();

			if (lastInput.equals("help")) {
				System.out.println(HELP);
			}
			if (lastInput.equals("displayMonth")) {
				System.out.println(ERR_MONTH);
			}
			if (lastInput.equals("displayDay")) {
				System.out.println(ERR_DATE);
			}
			if (lastInput.equals("createEvent")) {
				System.out.println(ERR_CREATE);
			}
			if (lastInput.equals("deleteEvent")){
				System.out.println(ERR_EVENT_NOT_FOUND);
			}
			if (lastInput.equals("editEvent")){
				System.out.println(ERR_EVENT_NOT_FOUND);
			}
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