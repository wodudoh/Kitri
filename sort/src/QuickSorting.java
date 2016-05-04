import java.util.Random;

/** 퀵정렬을 위한 클래스
 *  배열을 선정하고,
 *  임의의 번호를 pivot 선정한다.
 *  첫번째 인덱스가 pivot보다 작으면 left index에 대입
 *   left 하나 증가
 *  마지막 인덱스가 pivot보다 크면 right index에 대입
 *   right 하나 증가
 *   
 *  둘의 인덱스가 만나면 고정
 *  
 *   
 * @author Administrator
 *
 */
public class QuickSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int[] test = {10,20,100,30,23,14,38,98,12,13};
		Random rand = new Random();
		int random = rand.nextInt(test.length);
//		System.out.println(random);
		
		int left = 0;
		int right = 0;
		int pivot = random;
		int swapTmp = 0;
		
		

	}
	
	
	

}
