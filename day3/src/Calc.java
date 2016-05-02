


/**
 * 실제 계산기 클래스
 * @author Administrator
 *
 */
public class Calc {
	
	public int plus(int a, int b){
		return a+b;
	}
	public double plus(double a, double b){
		return a+b;
	} //오버로딩

	public int plus(int a, int b, int c){
		return a+b+c;
	}//오버로딩
	
	public int minus(int a, int b){
		return a-b;
	}
	public double minus(double a, double b){
		return a-b;
	}//오버로딩

	
	public int multiplex(int a, int b){
		 return a*b;
	}
	public double multiplex(double a, double b){
		return a*b;
	}
	
	public double division(double a, double b){
		
		if(a!=0 && b!=0)return a/b;
		else return 0;
	}
	
	

}
