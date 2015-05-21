package Home;

public class Sort_int {

	public void Sort_Int() {
		int[] a = new int[100];

		for (int i = 0; i < 100; i++) {
			a[i] = i + 1;
		}

		for (int i = 100, j = 0; i > 0; i--, j++) {
			a[j] = i;
		}

		for (int i = 0; i < 100 - 1; i++) {
			for (int j = 0; j < (100 - i) - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}

			}
		}

		for (int i : a) {
			System.out.println(i);
		}

	}

}
