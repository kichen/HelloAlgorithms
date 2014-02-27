import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MergeSort {
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
		mergeSort(a, 0, n - 1);
		for (int i = 0; i < n; i++) {
			System.out.println(a[i]);
		}
	}

	/*
	 * merge ordered sub-array in an array
	 */
	public void mergeArray(int[] a, int first, int mid, int last) {
		int i = first;
		int j = mid + 1;
		int k = 0;
		int[] tmp = new int[last - first + 1];
		while (i <= mid && j <= last) {
			if (a[i] < a[j]) {
				tmp[k++] = a[i++];
			} else {
				tmp[k++] = a[j++];
			}
		}
		while (i <= mid) {
			tmp[k++] = a[i++];
		}
		while (j <= last) {
			tmp[k++] = a[j++];
		}
		for (int m = 0; m < tmp.length; m++) {
			a[first + m] = tmp[m];
		}
	}

	public void mergeSort(int[] a, int first, int last) {
		if (first < last) {
			int mid = (first + last) / 2;
			mergeSort(a, first, mid);// merge the left side
			mergeSort(a, mid + 1, last);
			mergeArray(a, first, mid, last);
		}
	}
}
