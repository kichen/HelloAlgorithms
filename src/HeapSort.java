import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HeapSort {

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
		heapSort(a, n);
		for (int i = n - 1; i >= 0; i--) {
			System.out.println(a[i]);
		}
	}

	// Move bigger node down
	void minHeapNodeDown(int a[], int i, int n) {
		int temp = a[i];
		int j = 2 * i + 1;// left son

		while (j < n) {
			if ((j + 1) < n && a[j] > a[j + 1]) {
				j++;
			}

			if (temp < a[j]) {
				break;
			} else {
				a[i] = a[j];
				i = j;
				j = 2 * i + 1;
			}
		}

		a[i] = temp;
	}

	// Transfer the array to a min-heap
	void initMinHeap(int a[], int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			minHeapNodeDown(a, i, n);
		}
	}

	void heapSort(int a[], int n) {
		initMinHeap(a, n);
		int tmp;
		for (int i = n - 1; i > 0; i--) {
			tmp = a[0];
			a[0] = a[i];
			a[i] = tmp;
			minHeapNodeDown(a, 0, i);
		}
	}

}
