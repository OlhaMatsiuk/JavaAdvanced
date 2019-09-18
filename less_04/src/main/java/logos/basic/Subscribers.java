package logos.basic;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Subscribers {
	
	private int id; 
    private int user_id;
    private int magazine_id;
    private boolean status;
    private LocalDate start;
    private int duration;
    
	public Subscribers(int id, int user_id, int magazine_id, boolean status, LocalDate start, int duration) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.magazine_id = magazine_id;
		this.status = status;
		this.start = start;
		this.duration = duration;
	}

	public Subscribers(int user_id, int magazine_id, boolean status, LocalDate start, int duration) {
		super();
		this.user_id = user_id;
		this.magazine_id = magazine_id;
		this.status = status;
		this.start = start;
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getMagazine_id() {
		return magazine_id;
	}

	public void setMagazine_id(int magazine_id) {
		this.magazine_id = magazine_id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Subscribers [id=" + id + ", user_id=" + user_id + ", magazine_id=" + magazine_id + ", status=" + status
				+ ", start=" + start + ", duration=" + duration + "]\n";
	}
    
	public static Subscribers map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		int user_id = result.getInt("user_id");
		int magazine_id = result.getInt("magazine_id");
		boolean status = result.getBoolean("status");
		LocalDate start = result.getDate("start").toLocalDate();
		int duration = result.getInt("duration");
		
		return new Subscribers(id,user_id,magazine_id,status,start,duration);
	}

}
