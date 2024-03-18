import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
public class storeEvents{
	
	// Filename for the file that events are stored to.
	public static final String FILENAME = "events.txt";
	public static final String FILE_NOT_FOUND = "Event file could not be found.";
	/**
	 * Checks if the file that the events are stored in exists yet.
	 * 
	 * @param path
	 * @return true if the file already exists/false if it does not
	 */
	public static boolean fileExists(String path) {
	    File file = new File(path);
	    return file.exists();
	}
	
	/**
	 * Updates the event save file by overwriting the file with the contents of the ArrayList
	 * 
	 * 
	 * @param events
	 */
	public static void updateFile(ArrayList<String> events) {
	    try {
	        PrintWriter edit = new PrintWriter(new File(FILENAME));
	        for (String event : events) {
	            edit.println(event);
	        }
	        edit.close(); 
	    } catch (FileNotFoundException e) {
	        System.out.println(FILE_NOT_FOUND);
	    }
	}
	
	/**
	 * Reads from the saves file and inputs events from the file into the ArrayList.
	 * 
	 * @param input
	 * @return ArrayList to be used by the createEvents class.
	 */
	public static ArrayList<String> readFile(){
	    ArrayList<String> events = new ArrayList<>();
	    try {
	        File file = new File(FILENAME);
	        Scanner scanner = new Scanner(file);
	        while (scanner.hasNextLine()) {
	            String event = scanner.nextLine();
	            events.add(event);
	        }
	        scanner.close();
	    } catch (FileNotFoundException e) {
	    }
	    return events;
	}
}
