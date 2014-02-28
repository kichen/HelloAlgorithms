/**
 * Programming Perls Ex 1.2 位图排序(正整数)
 * 
 * @author kichen
 * 
 */
public class PP_1_2 {

	public static void main(String[] args) {
		
	}

	public static void set(int a[], int i) {
		int off = i % 32;
		int num = 1 << (32 - off);
		int m = (i - 1) / 32;
		a[m] = a[m] | num;
		// System.out.println(a[m] + " " + Integer.toBinaryString(a[m]));
	}

}
