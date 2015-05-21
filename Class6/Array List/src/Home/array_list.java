package Home;

import java.util.*;

public class array_list {
	public void create() {
		ArrayList<String> newList = new ArrayList<String>();

		newList.add("Leon");
		newList.add("dfg");
		newList.add("Ledfgon");
		newList.add("tttt");
		newList.add("Leon");
		newList.add("Leodsfgdn");
		newList.add("Ledfgon");

		/*System.out.println("List size is : " + newList.size());
		System.out.println(newList);

		newList.remove("Leon");
		System.out.println("List size is : " + newList.size());
		System.out.println(newList);

		newList.add("Tonmoy");

		System.out.println("Index of Tommoy is : " + newList + " "
				+ newList.indexOf("Tonmoy"));

		newList.add("Tonmoy");
		System.out.println("Index of Tommoy is : " + newList + " "
				+ newList.lastIndexOf("Tonmoy"));*/

		System.out.println(newList);
		newList.set(2, "NEW NAME");
		System.out.println(newList);

//		for (String s : newList) {
//			System.out.println(s);
//		}
		
	}
}
