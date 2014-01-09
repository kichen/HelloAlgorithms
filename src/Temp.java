public class Temp {

	public static void main(String[] args) {
		animal a = new cat();
		System.out.println(a.i);
	}
}

class animal {
	int i = 1;

	animal(int x){}
	
	private final void f() {
	}
}

class cat extends animal {
	int i = 2;
	
	cat(){super(5);}

	void f() {
	}
}