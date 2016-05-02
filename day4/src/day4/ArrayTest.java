package day4;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//정수 6개가 저장될 배열선언 및 생성.
		// 변수명 : arr
		// TODO
		
		int[] arr= new int[6];
		
		//임의의 숫자를 발생해서 ARR의 각 INDEX에 대입
		//임의의 숫자범위 : 1 <= R <=45
		//TODO
//		Random random = new Random();
//		arr= new int[(random.nextInt(45)+1)];
//		System.out.println("현재 배열의 방 사이즈는?"+arr.length);
//		
		
		
		//math.Random 클래스 이용하는 방법.
		
		//중복 되지 않는 임의의 숫자 발생 시키기 위한 문장
		for(int index=0; index<arr.length; index++){
			
			arr[index] = (int)(Math.random()*45+1);
			
			//이전 숫자와 비교하기 위한 for문
			for(int bIndex=0 ; bIndex<index ; bIndex++ ){
				
				//이전 인덱스 값과 현재 인덱스 값 비교
				if(arr[bIndex] == arr[index]){
					//현재 위치값 다시 난 수 발생시키는 위로 가야함
					--index;
					break;
					
				}
			}
			
		}
		
		System.out.println("--------정렬전");
		//	추출 하기
		for(int index=0; index<arr.length; index++){
			
			System.out.println(arr[index]);
		}
		
		System.out.println("--------정렬후");
		// 정렬 하기 오름 차순으로 바꾸기

		
		for(int bIndex=0;bIndex <arr.length - 1;){
			
			int aIndex=1;
					
			while(aIndex<arr.length){
				
				aIndex++;
			}
		}
		
			
		
		for(int index=0; index<arr.length; index++){
			
			System.out.println(arr[index]);
		}
		
		
		
	}

}
