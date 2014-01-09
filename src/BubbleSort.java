import org.junit.Test;

//测试数据基本上是从小到大排列的整数，为了体现三种算法的性能差别，将中间段部分数据挪到了相对靠后的位置
public class BubbleSort {

	@Test
	public void testSort() {
		Stopwatch stopwatch = new Stopwatch();
		In in = new In("128Kints.txt");
		System.out.println(stopwatch.elapsedTime());
		int a[] = in.readAllInts();
		in.close();
		sort(a);
	}

	public static void sort(int a[]) {
		int n = a.length;
		System.out.println("The sorted integers are:");
		for (int i = 0; i < n - 1; i++) {
			for (int j = 1; j < n - i; j++) {
				if (a[j - 1] > a[j]) {
					a[j - 1] ^= a[j];
					a[j] ^= a[j - 1];
					a[j - 1] ^= a[j];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(a[i]);
		}

	}

	@Test
	public void testSort1() {
		Stopwatch stopwatch = new Stopwatch();
		In in = new In("128Kints.txt");
		System.out.println(stopwatch.elapsedTime());
		int a[] = in.readAllInts();
		in.close();
		sort1(a);
	}

	// optimize1: add flag
	public static void sort1(int a[]) {
		int n = a.length;
		System.out.println("The sorted integers are:");
		boolean flag = false;// flag
		for (int i = 0; i < n - 1; i++) {
			flag = false;
			for (int j = 1; j < n - i; j++) {
				if (a[j - 1] > a[j]) {
					a[j - 1] ^= a[j];
					a[j] ^= a[j - 1];
					a[j - 1] ^= a[j];
					flag = true;// mark it as true if sorting happens
				}
			}
			if (flag == false)
				break;
		}
		for (int i = 0; i < n; i++) {
			System.out.println(a[i]);
		}

	}

	@Test
	public void testSort2() {
		Stopwatch stopwatch = new Stopwatch();
		In in = new In("128Kints.txt");
		System.out.println(stopwatch.elapsedTime());
		int a[] = in.readAllInts();
		in.close();
		sort2(a);
	}

	// optimize2: record position
	public static void sort2(int a[]) {
		int n = a.length;
		System.out.println("The sorted integers are:");
		boolean flag = false;
		int pos = n;// pos
		for (int i = 0; i < n - 1; i++) {
			flag = false;
			for (int j = 1; j < pos; j++) {
				if (a[j - 1] > a[j]) {
					a[j - 1] ^= a[j];
					a[j] ^= a[j - 1];
					a[j - 1] ^= a[j];
					flag = true;
					pos = j;// update pos if sorting happens
				}
			}
			if (flag == false)
				break;
		}
		for (int i = 0; i < n; i++) {
			System.out.println(a[i]);
		}

	}

}
