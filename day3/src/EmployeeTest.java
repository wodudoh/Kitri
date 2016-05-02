
public class EmployeeTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		Employee emp2 = new Employee();
		Employee emp3 = emp;
		
//		emp.empNo = "1000";
//		emp.name = "첫번째";
//		emp.phone = "01012345678";
//		emp.salary = 12000;
//		emp.meeting();
//
//		emp2.empNo = "1200";
//		emp2.name = "두번째";
//		emp2.phone = "01012345678";
//		emp2.salary = 10000;
//		
//		emp3.name = "세번째";
//		System.out.println(emp.name);
//		System.out.println(emp3.name);
		
		emp2.work();
		emp3.work();
		
		if(emp==emp3)System.out.println("emp1과 emp3은 동일한 객체입니다.");
		else System.out.println("emp1과 emp3는 서로 다른 객체입니다.");
			
		if(emp!=emp2)System.out.println("emp1와 emp2는 서로다른 객체입니다.");
		else System.out.println("emp1와 emp2는 서로 같은 객체입니다.");
		
		Employee emp4;
		emp4 = new Employee("1004", "네번째", "01012345678", 2500);
		
		
	}

}
