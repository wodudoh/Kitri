
public class WatchTV {

	public static void main(String[] args) {
		TV tv = new TV();
		tv.powerOn();
		if(tv.isPower()){
			System.out.println("전원이 켜졌습니다.");
		}
		
		tv.setChannel(11);// 채널을 11번으로 설정
		tv.getChannel();
		tv.channelUp();
		tv.getChannel();
		
		tv.volumeUp();
		tv.volumeUp();
		tv.volumeUp();
		tv.volumeDowne();
		tv.volumeDowne();
		tv.volumeDowne();
		tv.volumeDowne();
		tv.volumeDowne();
		System.out.println("현재 볼륨은 "+tv.getVolume());
		
		
		tv.powerOff();
		if(!tv.isPower()){
			System.out.println("전원이 꺼졌습니다.");
		}
	}

}
