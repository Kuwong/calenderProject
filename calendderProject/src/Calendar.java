import java.util.Scanner;
import java.util.ArrayList;

//import java.io.FileNotFoundException;

public class Calendar {

	// Error message strings
	public static final String ERR_INVALID = "Invalid command. Type \"help\" for the list of valid commands.";
	public static final String ERR_MONTH = "Invalid month (should be between 1-12).";
	public static final String ERR_DATE = "Invalid date.";
	public static final String ERR_EVENT_NOT_FOUND = "Event(s) does not exist.";
	public static final String ERR_CREATE = "Event could not be created. Please ensure date is valid (Contains only numbers and \"/\" and is in format of mm/dd/yyyy)";
	public static final String FILE_NOT_FOUND = "Event file could not be found.";

	// Misc message strings
	public static final String HELP = "Your commands are:\n\nhelp\ndisplayMonth\ndisplayDay\ndisplayEvents\ncreateEvent\neditEvent\ndeleteEvent\ndone\n";
	public static final String ENTER = "Enter your command: \n";

	/**
	 * Display the calendar view of a month, and displays any events for that month
	 * underneath.
	 * 
	 * @param month
	 * @param year
	 * @param events
	 */
	public static void displayMonth(int month, int year) {
		//Prints the month and year as a header
        System.out.println("   " + getMonthName(month) + " " + year);
        System.out.println(" S  M  T  W  T  F  S");

        //Gets the starting day of the week for the first day of the month
        int startDay = getStartDay(month, year);

        //Gets the number of days in the month
        int daysInMonth = getDaysInMonth(month, year);

        //Prints leading spaces before the first day
        for (int i = 0; i < startDay; i++) {
            System.out.print("   ");
        }

        //Prints the days of the month
        for (int day = 1; day <= daysInMonth; day++) {
            //Adds padding for single-digit days
            if (day < 10) {
                System.out.print(" ");
            }
            //Prints the day
            System.out.print(day + " ");

            //Prints a new line and resets indentation for the next week
            if ((day + startDay) % 7 == 0 || day == daysInMonth) {
                System.out.println();
            }
        }
    }
	
	/**
	 * Returns the first day of the month
	 * 
	 * @param month
	 * @param year
	 */
	private static int getStartDay(int month, int year) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month - 1, 1);
        return cal.get(java.util.Calendar.DAY_OF_WEEK) - 1;
    }

	/**
	 * Returns the number of days in the month
	 * 
	 * @param month
	 * @param year
	 */    
	private static int getDaysInMonth(int month, int year) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month - 1, 1);
        return cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
    }

	/**
	 * Returns the name of the month as a string
	 * 
	 * @param month
	 */
	private static String getMonthName(int month) {
        String[] monthNames = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
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
		boolean found = false; 
		for (int i = 0; i < events.size(); i++) {
			String eventAt = events.get(i);
		    int monthAtI = (Character.getNumericValue(eventAt.charAt(0)) * 10 + Character.getNumericValue(eventAt.charAt(1)));
		    int dayAtI = (Character.getNumericValue(eventAt.charAt(3)) * 10 + Character.getNumericValue(eventAt.charAt(4)));
		    int yearAtI = (Character.getNumericValue(eventAt.charAt(6)) * 1000 + (int) Character.getNumericValue(eventAt.charAt(7)) * 100 + Character.getNumericValue(eventAt.charAt(8)) * 10 + Character.getNumericValue(eventAt.charAt(9)));
		    if ((monthAtI == month) && (yearAtI == year) && (dayAtI == day)) {
		    	System.out.println(eventAt);
		    	found = true;
		    }
		 }
		if (found == false) {
			System.out.println(ERR_EVENT_NOT_FOUND);
		}
	}

	/**
	 * Displays the list of all events stored.
	 * 
	 * @param events
	 */
	public static void displayEvents(ArrayList<String> events) {
		if (events.isEmpty()) {
            System.out.println(ERR_EVENT_NOT_FOUND);
        } else {
            for (int i = 0; i < events.size(); i++) {
                System.out.println(i + ") " + events.get(i));
            }
        }
	}

	/**
	 * Receives input from console. Continuously waits for valid command. Outputs
	 * error when input != a valid command. Executes commands when input = command.
	 * Terminates after use of the "done" command.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// A string is needed for the input so that the scanner only checks for input
		// once.
		String lastInput = "";
		// Boolean used so that the program doesn't stop until the user is done.
		boolean done = false;

		System.out.println("Welcome to your Planner.");
		System.out.println(HELP);

		ArrayList<String> events = storeEvents.readFile();

		while (done == false) {

			System.out.println(ENTER);
			lastInput = input.next();

			switch (lastInput) {

				// Displays all valid commands.
				case "help":
					System.out.println(HELP);
					break;
					
				// Asks for the month and year and passes these parameters to displayMonth
				// method.
				case "displayMonth":
					System.out.println("Enter month (1-12): ");
				    int displayMonth = input.nextInt();
				    if (displayMonth < 1 || displayMonth > 12) {
				        System.out.println(ERR_MONTH);
				        break;
				    }
				    System.out.println("Enter year: ");
				    int displayYear = input.nextInt();
				    displayMonth(displayMonth, displayYear);
				    // Displays events for that month
				    System.out.println();
				    System.out.println("   Events");
				    for (int i = 0; i < events.size(); i++) {
				    	String eventAt = events.get(i);
				    	int monthAtI = (Character.getNumericValue(eventAt.charAt(0)) * 10 + Character.getNumericValue(eventAt.charAt(1)));
				    	int yearAtI = (Character.getNumericValue(eventAt.charAt(6)) * 1000 + (int) Character.getNumericValue(eventAt.charAt(7)) * 100 + Character.getNumericValue(eventAt.charAt(8)) * 10 + Character.getNumericValue(eventAt.charAt(9)));
				    	if ((monthAtI == displayMonth) && (yearAtI == displayYear)) {
				    		System.out.println(eventAt);
				    	}
				    }
				    System.out.println();
					break;
					
				// Asks for day, month, and year and passes these parameters to displayDay
				// method.
				case "displayDay":
					System.out.println("Enter month (mm): ");
				    int displayMonth2 = input.nextInt();
				    System.out.println("Enter day (dd): ");
				    int displayDay = input.nextInt();
				    System.out.println("Enter year (yyyy): ");
				    int displayYear2 = input.nextInt();
				    displayDay(displayDay, displayMonth2, displayYear2, events);
					break;
					
				// Calls createEvent method in the createEvents class.
				case "createEvent":
					String newEvent = createEvents.createEvent(input);
					if (!newEvent.equals("ERROR")) {
						events.add(newEvent);
						System.out.println("Event created successfully.");
					} else {
						System.out.println(ERR_CREATE);
					}
					break;
					
				// Calls deleteEvent method in the createEvents class.
				case "deleteEvent":
					if (events.isEmpty()) {
			            System.out.println(ERR_EVENT_NOT_FOUND);
			        }
					else {
						displayEvents(events);
						createEvents.deleteEvent(input, events);
					}
					break;
					
				// Calls editEvent method in the createEvent class.
				case "editEvent":
					displayEvents(events);
					System.out.println("Enter event index to edit: ");
					int editIndex = input.nextInt();
					String newEvent1 = createEvents.editEvent(events.get(editIndex), input);
					if (newEvent1.equals("ERROR")) {
						System.out.println(ERR_CREATE);
					}
					else {
						events.set(editIndex, newEvent1);
					}
					break;
					
				// Calls displayEvents method.
				case "displayEvents":
					displayEvents(events);
					break;
					
				// Asks for verification, then saves events ArrayList to File with updateFile
				// method in storeEvents, then terminates program.
				case "done":
					System.out.println("Are you sure you want to exit? (Y/N)");
					if (input.next().toUpperCase().equals("Y")) {
						storeEvents.updateFile(events);
						done = true;
					}
					break;
					
			}
		}
		System.out.println("Done!");
		input.close();

	}
}
