import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class InsertSort {

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

	@Ignore
	@Test
	public void testSort() {
		sort(a);
	}

	public static void sort(int a[]) {
		int n = a.length;
		System.out.println("The sorted integers are:");
		int i, j, k;
		for (i = 1; i < n; i++) {
			for (j = i - 1; j >= 0; j--)
				if (a[j] < a[i])
					break;

			if (j != i - 1) {
				int temp = a[i];
				for (k = i - 1; k > j; k--)
					a[k + 1] = a[k];
				a[k + 1] = temp;
			}
		}
		for (i = 0; i < n; i++) {
			System.out.println(a[i]);
		}
	}

	@Test
	public void testSort2() {
		sort2(a);
	}

	public static void sort2(int a[]) {
		int n = a.length;
		System.out.println("The sorted integers are:");
		int i, j;
		for (i = 1; i < n; i++) {
			// if (a[i] < a[i - 1]) {
			int temp = a[i];
			for (j = i - 1; j >= 0 && a[j] > temp; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = temp;
			// }
		}
		for (i = 0; i < n; i++) {
			System.out.println(a[i]);
		}

	}

	@Ignore
	@Test
	public void testSort3() {
		sort3(a);
	}

	public static void sort3(int a[]) {
		int n = a.length;
		System.out.println("The sorted integers are:");
		int i, j;
		for (i = 1; i < n; i++) {
			if (a[i] < a[i - 1]) {
				for (j = i - 1; j >= 0 && a[j] > a[j + 1]; j--) {
					a[j + 1] ^= a[j];
					a[j] ^= a[j + 1];
					a[j + 1] ^= a[j];
				}
			}
		}
		for (i = 0; i < n; i++) {
			System.out.println(a[i]);
		}
	}
}
