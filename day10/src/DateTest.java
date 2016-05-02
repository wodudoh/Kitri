import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 날짜 관련 클래스를 연습하기 위한 클래스
 * @author Administrator
 *
 */
public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date dt;
		
		dt = new Date();
		
		System.out.println(dt); //dt.toString() 자동 호출됨
		
		long time = System.currentTimeMillis();
		dt = new Date(time);
//		dt  = new Date()
//		이크립스 자동 완성에서 변수명 앞에 빗금 의미 Deprecated 된 생성자들은 사용을 권장하지 않는다.
		
		Calendar c;
		c = Calendar.getInstance();
		int h = c.get(Calendar.HOUR);
		int m = c.get(Calendar.MINUTE);
		int s = c.get(Calendar.SECOND);
		
		int y = c.get(Calendar.YEAR);
		int mon = c.get(Calendar.MONTH);
		int date = c.get(Calendar.DATE);
		
		System.out.println(y+"년"+mon+"월"+date+"일");
		System.out.println(h + "시" + m + "분" + s+"초");
		c.set(Calendar.YEAR, 2017);
		c.set(2017, 03, 01);	// 03 은 4월을 의미 왜냐하면 Gragorian Calendar와 다르게 january가 0부터 시작기때문.
		
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		switch(c.get(Calendar.DAY_OF_WEEK)){
		
		case Calendar.SUNDAY: System.out.println("일요일"); break;
		case Calendar.MONDAY:System.out.println("월요일"); break;
		case Calendar.TUESDAY:System.out.println("화요일"); break;
		case Calendar.WEDNESDAY:System.out.println("수요일"); break;
		case Calendar.THURSDAY:System.out.println("목요일"); break;
		case Calendar.FRIDAY:System.out.println("금요일"); break;
		case Calendar.SATURDAY:System.out.println("토요일"); break;
		}
	
		int lastDate = c.getActualMaximum(Calendar.DATE); // 스케줄을 만들기 위해서
		System.out.println(lastDate);
		
		//텍스트를 그대로 하는 게아니고 가공을 하는 "포멧팅"을 하는 방법
		String pattern = "yyyy-MM-dd a hh:mm:ss"; //주의 할점은 형식이 대소문자 구분이다.. 대문자 M이 분이고, 소문자 m이 
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String nowStr = sdf.format(new Date());
		System.out.println(nowStr);

		
	}

}
