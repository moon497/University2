package kh.com.util;
public class ArrayTest {
	private int[] arr = new int[5];
	
	public void init() {
		for (int i = 0; i < arr.length; i++)
			arr[i] = (int)(Math.random()*101);
	}
	public int sum() {
		int sum=0;
		for (int i = 0; i < arr.length; i++)
			sum+=arr[i];
		return sum;
	}
	public double avg() {
		int sum=0;
		for (int i = 0; i < arr.length; i++)
			sum+=arr[i];
		return sum*1.0/arr.length;
	}
	
	public void display() {
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}
	
	public static void main(String[] args) {
		ArrayTest at = new ArrayTest();
		at.init();
		System.out.println(at.avg());
		at.display();
	}
}
