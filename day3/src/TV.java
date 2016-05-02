
/**
 * @author Administrator
 *
 */
public class TV {
	
	boolean tvSatate=false;
	private int tvChannel;
	private int tvVolume;
	
	
	boolean isPower(){
		
		return tvSatate; 
		
	}
	void powerOn(){
		
		tvSatate=true;
		
	}
	void powerOff(){
		
		tvSatate=false;
		
		
	}
	public void setChannel(int i) {

		tvChannel = i;
		
	}
	public void getChannel() {
		
		System.out.println("현재 채널은 "+tvChannel+"번 입니다.");
		
	}
	public void channelUp() {
		if(tvChannel < 120)tvChannel ++;
		else tvChannel = 0;
		
	}
	public void channelDown() {
		if(tvChannel > 0) tvChannel --;
		else tvChannel=120;
	}
	public int getVolume(){
		return tvVolume; // 현재 음량 값을 출력 
	}
	
	public void volumeUp(){
		tvVolume++;
		
	}
	public void volumeDowne(){
		if(tvVolume > 0) tvVolume--;
	}

}
