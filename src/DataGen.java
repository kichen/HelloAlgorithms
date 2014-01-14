import java.util.Random;

public class DataGen {
	public static void main(String[] args) {
		Out out = new Out("128Kints_R.txt");
		Random random = new Random();
		for (int i = 0; i < 128000; i++) {
			out.println(random.nextInt(Integer.MAX_VALUE));
		}
		out.close();
	}

}
