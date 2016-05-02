
/**
 * @author Administrator
 *
 *상점에서 물건을 사고 지폐로 돈을 내면 거스름 돈을 줘야 한다. 이 때 동전을 어떻게 해서 줘야 하는지 계산하시오.
 *돈은 반드시 1000 원을 내며 , 거스름 돈은 10 원 , 50 원 , 100 원 동전으로 하고 큰 동전 우선으로 준다.
 */

import java.util.Scanner;

public class Change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		final int money = 1000;
		int pay = sc.nextInt();
		final int change = money - pay;
		int bacWon = change / 100 ;
		int ohShipWon =  (change-bacWon*100)/50 ;
		int ShipWon = (change - bacWon*100 - ohShipWon*50) /10;
		System.out.println(bacWon + " "+ ohShipWon+" "+ ShipWon);
		
	}

}
