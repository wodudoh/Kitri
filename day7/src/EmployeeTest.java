import com.my.dao.EmployeeDAO;
import com.my.dto.Employee;
import com.my.dto.Manager;

public class EmployeeTest {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO(10);
		Employee[] arr = dao.selectAll();
		if(arr == null){
			System.out.println("검색 결과가 없습니다.");//출력됨
		}
		
		dao.add(new Employee("no1","첫번째", null, 100));
		dao.add(new Employee("no2","두번째", null, 200));
		dao.add(new Manager("no3","세번째관리자", null, 300, 10));
		dao.add(new Manager("no4","네번째관리자", null, 400, 10));
		dao.add(new Employee("no5","다섯번째", null, 500));
		
		arr = dao.selectAll();
		/*
		 * 아래결과가 
		 * no1:첫번째:월급100을 받는다
		 * no2:두번째:월급200을 받는다
		 * no3:세번째관리자:관리자월급 310을 받는다
		 * no4:네번째관리자:관리자월급 410을 받는다
		 * no5:다섯번째:월급500을 받는다
		 * 가 되도록 한다. 절대 NullPointerException발생되면 안됨
		 */
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i].getNo()+":" + arr[i].getName());
			arr[i].pay();
		} 
		String no = "no3";
		Employee e= dao.selectByNo(no);
		System.out.print(no + ":" + e.getName());//"no3:세번째"출력됨
		e.pay(); //"관리자월급 310을 받는다"출력됨
		
		no="사번없음";
		e= dao.selectByNo(no);
		System.out.print(e);//null이 출력됨
	}

}
