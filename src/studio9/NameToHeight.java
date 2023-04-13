package studio9;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	private String FirstName;
	private String LastName;
	private int StudentIDNumber;
	
	
	
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String,Double> temp = new HashMap<>();
		String name = "";
		double height = 0;
		for (int i = 0; i<3; i++) {
			System.out.println("What is your name?");
			name = in.next();
			System.out.println("What is your height in inches?");
			height = in.nextInt();
			temp.put(name, height);
		}
		
System.out.print(temp);
		

	}
}
