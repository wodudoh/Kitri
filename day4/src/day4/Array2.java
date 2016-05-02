package day4;

public class Array2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]arr2 = {{90,100,35}, //한학생의 DB, JAVA WEB 성적
						{88,93,22}, 
						{77,91,45},
						{66,83,93},
						{55,72,92}
						};
		//각 학생별 총점과 평균을 계산하시오.
		
		//math.avg 이용안하고
		
		/*
		 * 1번 학생 : 총점=255, 평균= 75.0
		 * 2번 학생 : 총점=203, 평균67.xx
		 * 3번 학생 : 총점=.....
		 * ...........
		 */
		
		int sal=0;
		int dbScore=0;
		int javaScore=0;
		int webScore=0;
		
		for(int i=0,j=0;i<arr2.length&&j<arr2[0].length;j++){
			
			sal+=arr2[i][j];
			
			//j가 방 끝에 들어갔을때 
			if(j==(arr2[0].length-1)){
				
				//각 변수에 대입
				dbScore+=arr2[i][0];
				javaScore+=arr2[i][1];
				webScore+=arr2[i][2];
				
				// 1행의 1번 학생 총점 및 평균
				System.out.println((i+1)+"번 학생 : 총점="+sal+", 평균="+(sal/3.0));
				i++;
				sal=0;
				
				if(i<(arr2.length))
				j=-1;
			}
				
		}
		
		System.out.println("DB과목 평균 ="+dbScore/5.0);
		System.out.println("JAVA과목 평균="+javaScore/5.0);
		System.out.println("WEB과목평균"+webScore/5.0);
		
		
		int[][] arr3;
		arr3 = new int[3][3];
		int cnt=1;
		int row=0;
		int col=0;
		while(cnt<=(arr3.length*arr3[0].length)){
			System.out.print((arr3[row][col] = cnt));
			
			if(col==2){
				System.out.println();
				row++;
				col=-1; //초기화 
			}
			cnt++;
			col++; //row를 하나 올리고
		}
		
		//arr3 시계 90도 각도로 회전
		
		System.out.println("==========90도 회전===========");
		int swap=0;
		int lastIndex=arr3[0].length-1;
		
		for(int i=0,j=0,cnt2=0;cnt2<(arr3.length*arr3[0].length);j++){
			
			swap=arr3[i][j];
			arr3[i][j]=arr3[lastIndex][j];
			arr3[lastIndex][j]=swap;
			
			System.out.print(arr3[i][j]);
			if(j==2){
				//출력
				System.out.println();
				lastIndex--;
				j=0;
				i++;
			}
		
			cnt2++;
		}
				
	
	}

}
