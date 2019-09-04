package ua.lviv.lgs;

public class Time {
	
	private int hour;
	private int min;

	
	public Time(int duration) {
		super();
		this.hour = duration/60;
		this.min = duration%60;
	}
	
	public Time(int min, int hour) {
		
		if(min <= 60 && min >= 0 && hour <= 24 && hour >= 0) {
			this.min = min;
			this.hour = hour;
		}
		if(min > 60) {
			this.min = min%60;
			this.hour = hour + min/60;
		}
		if(hour > 24) {
			this.hour = hour%24;
		}
		if(min < 0 || hour < 0)
			System.out.println("Неправильно введений час!!!");
	}
	

	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}


	public int getHour() {
		return hour;
	}


	public void setHour(int hour) {
		this.hour = hour;
	}


	@Override
	public String toString() {
		return  hour + " : " + min;
	}

	

}
