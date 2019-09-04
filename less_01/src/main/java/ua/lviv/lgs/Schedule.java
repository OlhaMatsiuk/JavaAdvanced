package ua.lviv.lgs;

import java.util.Set;
import java.util.TreeSet;

public class Schedule  implements Comparable<Schedule>{
	
	private Set<Seance> schedule;
	private Integer id;
	public static int f = 0;

	public Schedule() {
		super();
		this.schedule = new TreeSet<>();
		this.id = f++;
	}
	
	

	public Set<Seance> getSchedule() {
		return schedule;
	}

	
	public void setSchedule(Set<Seance> schedule) {
		this.schedule = schedule;
	}
	
	public Integer getSchID() {
		return id;
	}

	@Override
	public String toString() {
		return schedule + " ";
	}
	
	public Seance getSeanceId(int id) {
		
		for (Seance s : schedule) {
			if (s.getID() == id)
				return s;
		}
		
		return null;
	}
	
	public Seance getSeanceMovie(String str) {
		for (Seance s : schedule) {
		if (s.getMovie().getTitle().equalsIgnoreCase(str));
		return s;
		}
		return null;
		}
	
	
	public void printSchedule() {
		
		for (Seance seance : schedule) {
			System.out.println();
			seance.toString();	
		}
	}
	
	public void addSeance (Seance seance) {
		
		schedule.add(seance);
		
	}
	
	
	public void removeSeanceS (String title) {
		
		for(Seance s : schedule) {
			
			if(s.getMovie().getTitle().equalsIgnoreCase(title)) 
				schedule.remove(s);
			
		}
		
	}



	@Override
	public int compareTo(Schedule o) {
		 return id.compareTo(o.getSchID());
	} 
	
	
	
	
	

}
