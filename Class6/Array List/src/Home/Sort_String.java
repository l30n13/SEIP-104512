package Home;

public class Sort_String {

	public void sort_string() {
		
		String[] names = { "hello", "this", "is", "sut", "string", "leon" };
		for (int i = 0; i < names.length - 1; i++) {
			for (int j = 0; j < (names.length - i) - 1; j++) {
				if (names[j].compareTo(names[j + 1]) > 0) {
					String temp = names[j];
					names[j] = names[j + 1];
					names[j + 1] = temp;
				}
			}
		}

		for (String i : names) {
			System.out.println(i);
		}
	}
}
