package day4;

public class Pascal {
	
	/**
	 * 파스칼 삼각형
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][]arr5= new int [5][];
		for(int cnt=0,index=0;cnt<arr5.length;cnt++){
			index++;
			arr5 = new int [5][index]; // 계속 새로 만들어서 배열 안에 값들이 초기화기 되었다.
			
			for(int i=0;i<arr5[0].length;i++){
				
				if(0<i && i<=arr5[0].length-2){
					arr5[cnt][i] = arr5[cnt-1][i] + arr5[cnt-1][i-1];
				}
					
				else arr5[cnt][i]=1;
				
				
				System.out.print(arr5[cnt][i]);
				
				
			}
			System.out.println();
				
				
		}
	}

}
