import java.util.Scanner;

public class Traiangle {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double a=sc.nextDouble();
		double b=sc.nextDouble();
		
		System.out.println(String.format("%.2f", (a*b)/2));
	}

}
