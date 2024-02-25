import java.util.Scanner;
//import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class storeEvents{
	
	// Filename for the file that events are stored to.
	public static final String FILENAME = "events.txt";
	
	/**
	 * Checks if the file that the events are stored in exists yet.
	 * 
	 * @param path
	 * @return true if the file already exists/false if it does not
	 */
	public static boolean fileExists(String path) {
		return false;
	}
	
	/**
	 * Updates the event save file by overwriting the file with the contents of the ArrayList
	 * 
	 * @param out
	 * @param events
	 */
	public static void updateFile(PrintWriter out, ArrayList<String> events) {
		
	}
	
	/**
	 * Reads from the saves file and inputs events from the file into the ArrayList.
	 * 
	 * @param input
	 * @return ArrayList to be used by the createEvents class.
	 */
	public static ArrayList<String> readFile(Scanner input){
		return null;
	}
	
}