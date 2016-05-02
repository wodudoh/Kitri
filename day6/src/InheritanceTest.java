import com.my.dto.Employee;
import com.my.dto.Manager;

//import com.my.dto.*; //이 방식은 그다지 권장하지 않음. 가독성에 좋지 않음.


public class InheritanceTest {
	
		public static void main(String[] args) {
			
			Employee e1;
			e1 = new Employee();
			Manager m1;
			m1 = new Manager();
			e1.setEmpNo("E001");
			e1.setSalary(10000);
			e1.work();
			e1.pay();
//			e1.setComm(10); // 자식에서는 접근 불가
			m1.setEmpNo("M001");
			m1.setSalary(100000);
			m1.work();
			m1.pay();
			
			Employee e2 = new Employee("E002", "두번째사원", "011", 1100);
			Manager m2 = new Manager("M002", "두번째관리자", "012", 2100,100);
			m2.work();
			m2.pay();
			e2.pay();
			
			
			
			
		}

}
