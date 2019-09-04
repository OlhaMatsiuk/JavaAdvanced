package ua.lviv.lgs;

public class Seance implements Comparable<Seance> {

	private Movie movie;
	private Time sratrtTime;
	private Time endTime;
	private Integer st;
	private Integer id;
	public static int f = 0;

	public Seance(Movie movie, Time sratrtTime) {

		this.movie = movie;
		this.sratrtTime = sratrtTime;
		this.endTime = new Time(sratrtTime.getMin() + movie.getDuration().getMin(),
				sratrtTime.getHour() + movie.getDuration().getHour());
		this.st = this.sratrtTime.getHour();
		this.id = f++;
	}

	public Movie getMovie() {
		return movie;
	}
	
	public Integer getID() {
		return id;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Time getSratrtTime() {
		return sratrtTime;
	}

	public void setSratrtTime(Time sratrtTime) {
		this.sratrtTime = sratrtTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "\n" + movie + ", початок=" + sratrtTime + ", кінець=" + endTime  ;
	}
	
	public Integer getSt() {
		return st;
	}

	@Override
	public int compareTo(Seance o) {
		return st.compareTo(o.getSt());
	}

	

}
