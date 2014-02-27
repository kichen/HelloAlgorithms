import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuickSort {
	private static In in;
	private static int[] a;

	@Before
	public void init() {
		in = new In("128Kints_R.txt");
		a = in.readAllInts();
	}

	@After
	public void destroy() {
		in.close();
	}

	@Test
	public void sort() {
		int n = a.length;
		quickSort(a, 0, n - 1);
		for (int i = 0; i < n; i++) {
			System.out.println(a[i]);
		}
	}

	public void quickSort(int[] a, int first, int last) {
		if (first < last) {
			int i = first, j = last, x = a[i];
			while (i < j) {
				while (i < j && a[j] >= x)
					j--;
				if (i < j) {
					a[i++] = a[j];
				}

				while (i < j && a[i] < x)
					i++;
				if (i < j) {
					a[j--] = a[i];
				}

			}
			a[i] = x;
			quickSort(a, first, i - 1);
			quickSort(a, i + 1, last);
		}

	}
}
