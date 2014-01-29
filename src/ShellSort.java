import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShellSort {
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
		int gap = n / 2;
		while (gap >= 1) {
			int i, j;
			for (i = gap; i < n; i++) {
				int temp = a[i];
				for (j = i - gap; j >= 0 && a[j] > temp; j -= gap) {
					a[j + gap] = a[j];
				}
				a[j + gap] = temp;
			}
			gap /= 2;
		}
		for (int i = 0; i < n; i++) {
			System.out.println(a[i]);
		}
	}

}
