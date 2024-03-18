import java.util.ArrayList;
import java.util.Scanner;

public class createEvents{
	
	// ArrayList where the events will be stored. Before program terminates, this will be saved to a file.
	public ArrayList<String> events = new ArrayList<>();
	
	/**
	 * Asks user for input and turns info into a String to be stored in the ArrayList.
	 * 
	 * @param input
	 * @return String to be stored in the ArrayList
	 */
	public static String createEvent(Scanner input){
		System.out.println("Enter event date (format: DD/MM/YYYY): ");
        String date = input.next();
        if (date.length() != 10 || !date.matches("[/0-9]+")) {
        	return "ERROR";
        }
        System.out.println("Enter event title: ");
        String title = input.next();
        System.out.println("Enter event description: ");
        String description = input.next();
        return date + " | " + title + " | " + description;
	}
	
	/**
	 * Takes user input and turns info into a String to be overwritten in the ArrayList.
	 * 
	 * @return String to use to overwrite in the ArrayList
	 */
	public static String editEvent(String event, Scanner input) {
		String oldDate = event.substring(0, 10);
		String oldTitleAndDescription = event.substring(13);
		String newDate, newTitle, newDescription, newTitleAndDescription;
		System.out.println("Would you like to change the date? (Y/N)");
		if (input.next().toUpperCase().equals("Y")) {
			System.out.println("Enter new date");
			String newInput = input.next();
			if (newInput.length() != 10 || !newInput.matches("[/0-9]+")) {
				return "ERROR";
		    }
			newDate = newInput;
		}
		else {
			newDate = oldDate;
		}
		System.out.println("Would you like to change the title or description? (Y/N)");
		if (input.next().toUpperCase().equals("Y")) {
			System.out.println("Enter new title:");
			newTitle = input.next();
			System.out.println("Enter new description:");
			newDescription = input.next();
			newTitleAndDescription = newTitle + " | " + newDescription;
		}
		else {
			newTitleAndDescription = oldTitleAndDescription;
		}
		return (newDate + " | " + newTitleAndDescription);
	}
	
	/**
	 * Takes user input and deletes the specified event from the ArrrayList.
	 * 
	 * @param input
	 * @param events
	 */
	public static void deleteEvent(Scanner input, ArrayList<String> events) {
		System.out.println("Enter event index to delete: ");
        int index = input.nextInt();
        if (index >= 0 && index < events.size()) {
            events.remove(index);
            System.out.println("Event deleted successfully.");
        } else {
            System.out.println("Invalid event index.");
        }
	}
	
	 /**
     * Method that retrieves the list of events.
     *
     * @return ArrayList containing events
     */
    public ArrayList<String> getEvents() {
        return events;
    }
}
