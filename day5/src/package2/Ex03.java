package package2;

public class Ex03 {

	public static void main(String[] args) {

		// 3의 배수 를 구하시오
		int num=0;
		int hap=0;
		for(num=1; num<=100;num++){
			if(num%3==0)
			{
				hap+=num;
			}
			
		}
		System.out.println(hap);
	}

}
