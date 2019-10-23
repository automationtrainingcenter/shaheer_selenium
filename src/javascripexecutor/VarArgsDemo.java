package javascripexecutor;

public class VarArgsDemo {

	// varargs : variable length arguments
	public static void add(int... nums) {
		System.out.println("number of arguments = " + nums.length);
		for(int i=0; i<nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

	public static void main(String[] args) {
		add();
		add(20, 10);
		add(10, 20, 30);
		add(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
	}

}
