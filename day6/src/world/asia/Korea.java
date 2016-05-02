package world.asia;

public class Korea {
	
	private String language;
	private int population;
	
	public void setPopulation(int population){
		if(population < 1){
			System.out.println("설정가능한 최소 인구는 1이상 입니다.");
			return;
			
		}
		this.population = population;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getPopulation() {
		return population;
	}
}
