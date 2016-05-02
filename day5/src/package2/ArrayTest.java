package package2;
public class ArrayTest {

	public static void main(String[] args) {

		int score1, score2, score3, score4, score5;
		score1=10; score2=90; score3=0 ; score4=1;; score5=35;
		double avg=
				(score1+score2+score3+score4+score5) / 5.0;
		System.out.println(avg);
		
		// 이걸 배열 타입으로 처리해보자
		
		int[] score;
		score = new int[5];
		
		score[0] =10;
		score[1] = 90;
		score[2] = 0;
		score[3] =1;
		score[4] = 35;
		avg=0.0;
		for(int cnt=0;cnt<score.length;cnt++){
			avg+=score[cnt];
		
		}
		avg /=5.0;
		System.out.println(avg);
		
		
//		int []lastDay;
//		lastDay = new int[12];
//		lastDay[0]=31;
//		lastDay[1]=29;
//		lastDay[2]=31;
//		lastDay[3]=30;
//		lastDay[4]=31;
//		lastDay[5]=30;
		
		int []lastDay = {31,29,31,30,31,30,31,31,30,31,30,31};
		System.out.println("4월의 마지막일자: " + lastDay[3]);
		
		/*lastDay= new int[]{31,29,31};
		System.out.println("4월의 마지막일자: " + lastDay[3]);*/
		
		char [][]alpa;
		alpa = new char[3][4];
		alpa[0][0] = 'A'; alpa[0][1]='B'; alpa[0][2]='C';alpa[0][3]='D';
		
		/*for(int cnt=0;cnt<12;cnt++){
						
			alpa[0][cnt]=(char) ('A'+cnt);
			System.out.print(alpa[0][cnt]);
			if((cnt+1) % 4 == 0) System.out.println();
			
		}*/
		char c = 'A';//시작문자
	      int rowLength = alpa.length;//행길이
	      int colLength = alpa[0].length;//열길이      
	      int index = 0;//문자증가치      
	      for(int row=0, col=0; index<rowLength*colLength; index++){
	    	  alpa[row][col] = (char)(c+index);
	    	  System.out.print(alpa[row][col]);
	    	  col++;
	    	  if( col % colLength == 0){ //col==4||col==8
	    		  System.out.println();
	    		  row++;
	    		  col = 0;    		 
	    	  }
	      }
	      System.out.println();
			
		/*
	      A
	      BC
	      DEF
	      GHIJ
	      KLMNO
	      
	      이런 모양을 만들기 위한 작업
	      */
	      
	      
	      c = 'A';
	      char[][]tri;
	      tri = new char[5][c];
	      System.out.println(tri[0].length);
	      
	      for(index=0; index<tri.length; index++){
	    	   tri[index] = new char[index+1];
	       }
	      
	      for(int row =0; row< tri.length; row++){
	    	   for(index=0; index< tri[row].length ;index++){
	    		   System.out.print(tri[row][index] = c++);//(char)(c+index+1 );
	    		   
	    	   }
	    	   System.out.println();
	       }  
	      
	            
	      
	      // Step 1 반복문을 나눠서 생각 해보자.
	     /* 
	      //0행일 때
	      tri[0][0] = c;
	      
	      //1행일 때
	      for(index=0;index<2;index++){
	    	  
	    	  tri[1][index] = c++;
	    	  
	      }
	      
	      //2행일때
	      for(index=0;index<3;index++){
	    	  
	    	  tri[2][index] = c++;
	      }
	      
	      //3행일때
	      
	      for(index=0;index<4;index++){
	    	  
	    	tri[3][index] = c++;
	    	
	      }
	      
	      // 4행일때
	      for(index=0;index<5;index++){
	    	  
	    	  tri[4][index] = c++;
	      }
	      */
	      
	      
		
		
		
		
	}
}
