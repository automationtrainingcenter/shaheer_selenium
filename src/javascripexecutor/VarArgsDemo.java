package javascripexecutor;

public class VarArgsDemo {

	// varargs : variable length arguments
	public static void add(int... nums) {
		System.out.println("number of arguments = " + nums.length);
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		System.out.println("total = " + sum);
	}

	public static void main(String[] args) {
		add();
		add(10, 20);
		add(10, 20, 30);
		add(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
	}

}
