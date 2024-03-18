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
	public static String editEvent() {
		
		return null;
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
