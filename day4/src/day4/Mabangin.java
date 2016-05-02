package day4;

import java.util.Scanner;

public class Mabangin {

	/**
	 * N 홀수 마방진 프로그램을 짜보자
	 * 홀수 정사각형의 크기를 입력 받은 후, 가로 세로 대각선의 합이 일정한 마방진을 출력하는 프로그램을 작성하시오.

	마방진이란 1부터 N*N까지의 숫자를 한 번씩만 써서 정사각형에 배치하여 가로와 세로, 그리고 대각선의 합이 같도록 하는 것이다.

	다음의 순서에 따라 각 위치에 차례대로 값을 넣는다.
	1. 첫 번째 숫자인 1을 넣는 위치는 첫 번째 행 가운데이다.
	2. 숫자가 N의 배수이면 바로 아래의 행으로 이동하여 다음의 수를 넣고
	3. 그렇지 않으면 왼쪽 위로 이동하여 다음의 숫자를 넣는다. 만약 행이 첫 번째를 벗어나면 마지막 행으로 이동하고, 열이 첫 번째를 벗어나면 마지막 열로 이동한다.
	
	
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		
//		int num = 0; // 증감 숫자
//		Scanner sc = new Scanner(System.in);
//		int size = sc.nextInt();  // 사이즈
//		int row=0, col=size/2; //배열 의 방번호
//		
//		System.out.println("마방진의 크기를 입력하세요:");
//		
//		num=1;
//		int[][] arr6 = new int[size][size]; // 배열 선언
//		arr6[0][size/2] = num;
//		
//		
//		do{
//			arr6[row][col] = num;
//			if(num % size == 0){
//				row++;
//			} else{
//				
//				row++;
//				col--;
//				
//				if(row < 0){
//					row = size-1;
//				}
//				if(col <0){
//					col = size=-1;
//				}
//			
//			}
//			num++;
//		}while(num <= size*size);
//		
		
//		row=0;col=0;
//		for(int i=1;i<arr6.length*arr6[0].length;i++){
//			
//			if((i%size)==0){
//				System.out.println(); // 열의 제일 마지막에서 문단 나눔.
//				row++;
//				col=-1;
//			}
//			System.out.println(arr6[row][col]);
//			col++;
//		}
		int num=1; 
		int row=0; 
		int col=0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("마방진크기를 입력하세요:");
		int size = sc.nextInt();
		int[][] arr6 = new int[size][size];
		
		num=1;
		row=0; col = size/2;//1은 [첫행][가운데열]
		do{
			arr6[row][ col ] = num;
			if(num % size == 0){
				row++; 
			}else{
				row--;
				col--;
				if(row == -1){
					row = size-1;
				}
				if(col == -1){
					col = size-1;
				}
			}
			num++;
		}while(num <= size*size);
		
		for(row=0; row<arr6.length; row++){
			for(col=0; col<arr6[row].length; col++){
				System.out.print(arr6[row][col]+"\t");
			}
			System.out.println();
		}
		
		
		
		
	}

}
