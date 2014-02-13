import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SelectionSort {
	private static In in;
	private static int[] a;

	@Before
	public void init() {
		in = new In("tmp.txt");
		a = in.readAllInts();
	}

	@After
	public void destroy() {
		in.close();
	}

	@Test
	public void sort() {
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i; j < n; j++) {
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
			}
			if (i != minIndex) {
				a[i] ^= a[minIndex];
				a[minIndex] ^= a[i];
				a[i] ^= a[minIndex];
			}
			for (int i1 = 0; i1 < n; i1++) {
				System.out.print(a[i1] + ",");
			}
			System.out.println("\n");
		}

		for (int i = 0; i < n; i++) {
			System.out.println(a[i]);
		}
	}

}
