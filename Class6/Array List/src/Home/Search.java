package Home;

import java.util.*;

public class Search {

	public void Search_String() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		String[] names = { "hello", "this", "is", "sut", "string", "leon" };

		// for (int i = 0; i < names.length - 1; i++) {
		// for (int j = 0; j < (names.length - i) - 1; j++) {
		// if (names[j].compareTo(names[j + 1]) > 0) {
		// String temp = names[j];
		// names[j] = names[j + 1];
		// names[j + 1] = temp;
		// }
		// }
		// }

		while (true) {
			String search = input.next();
			// this.find(0, names.length, names, search);
			for (int i = 0; i < names.length; i++) {
				if (names[i].equals(search)) {
					System.out.println("Value found");
					break;
				}
				if (i == names.length - 1) {
					System.out.println("Value not found");
				}
			}
		}

	}

	@SuppressWarnings("unused")
	private void find(int first, int last, String[] names, String searchName) {
		int mid = (first + last) / 2;
		if (first < last) {
			if (names[mid].compareTo(searchName) < 0) {
				first = mid + 1;
				find(first, last, names, searchName);
			} else if (names[mid].equals(searchName)) {
				System.out.println("Value found");
			} else {
				last = mid - 1;
				find(first, last, names, searchName);
			}
		} else {
			System.out.println("Value not found");
		}
	}

}
