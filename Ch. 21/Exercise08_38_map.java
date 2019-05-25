import java.util.*;

public class Exercise08_38_map {
	public static void main(String[] args) {
		String[][] stateCapital = {
				{"Alabama", "Montgomery"},
				{"Alaska", "Juneau"},
				{"Arizona", "Phoenix"},
				{"Arkansas", "Little Rock"},
				{"California", "Sacramento"},
				{"Colorado", "Denver"},
				{"Connecticut", "Hartford"},
				{"Delaware", "Dover"},
				{"Florida", "Tallahassee"},
				{"Georgia", "Atlanta"},
				{"Hawaii", "Honolulu"},
				{"Idaho", "Boise"},
				{"Illinois", "Springfield"},
				{"Indiana", "Indianapolis"},
				{"Iowa", "Des Moines"},
				{"Kansas", "Topeka"},
				{"Kentucky", "Frankfort"},
				{"Louisiana", "Baton Rouge"},
				{"Maine", "Augusta"},
				{"Maryland", "Annapolis"},
				{"Massachusettes", "Boston"},
				{"Michigan", "Lansing"},
				{"Minnesota", "Saint Paul"},
				{"Mississippi", "Jackson"},
				{"Missouri", "Jefferson City"},
				{"Montana", "Helena"},
				{"Nebraska", "Lincoln"},
				{"Nevada", "Carson City"},
				{"New Hampshire", "Concord"},
				{"New Jersey", "Trenton"},
				{"New York", "Albany"},
				{"New Mexico", "Santa Fe"},
				{"North Carolina", "Raleigh"},
				{"North Dakota", "Bismarck"},
				{"Ohio", "Columbus"},
				{"Oklahoma", "Oklahoma City"},
				{"Oregon", "Salem"},
				{"Pennsylvania", "Harrisburg"},
				{"Rhode Island", "Providence"},
				{"South Carolina", "Columbia"},
				{"South Dakota", "Pierre"},
				{"Tennessee", "Nashville"},
				{"Texas", "Austin"},
				{"Utah", "Salt Lake City"},
				{"Vermont", "Montpelier"},
				{"Virginia", "Richmond"},
				{"Washington", "Olympia"},
				{"West Virginia", "Charleston"},
				{"Wisconsin", "Madison"},
				{"Wyoming", "Cheyenne"}
		};

		//map
		Map<String, String> capitalsMap = new HashMap<>();

		//adding the existing array into new map
		for (String[] mapping:stateCapital) {
			capitalsMap.put(mapping[0], mapping[1]);
		}

		Scanner input = new Scanner(System.in);
		String userIn = null;

		//continue asking for States, until user types in end
		while(true) {
			System.out.print("(type \"end\" to quit)\nEnter a State to get its Capital: ");
			userIn = input.nextLine();
			if(userIn != "end" && capitalsMap.get(userIn) != null) {
				System.out.println("The capital of " + userIn + " is " + capitalsMap.get(userIn));
				System.out.println();
			}
			else if(userIn.equals("end")) {
				break;
			}
			else {
				System.out.println("Please check your spelling. It is case sensitive\n");
			}
		}
		input.close();
	}
}
