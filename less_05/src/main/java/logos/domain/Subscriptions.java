package logos.domain;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Subscriptions {
	
	private int id; 
    private int user_id;
    private int magazine_id;
    private boolean status;
    private Date start;
    private int duration;
    
	public Subscriptions(int id, int user_id, int magazine_id, boolean status, Date start, int duration) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.magazine_id = magazine_id;
		this.status = status;
		this.start = start;
		this.duration = duration;
	}

	public Subscriptions(int user_id, int magazine_id, boolean status, Date start, int duration) {
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

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duration;
		result = prime * result + id;
		result = prime * result + magazine_id;
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + user_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscriptions other = (Subscriptions) obj;
		if (duration != other.duration)
			return false;
		if (id != other.id)
			return false;
		if (magazine_id != other.magazine_id)
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (status != other.status)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subscribers [id=" + id + ", user_id=" + user_id + ", magazine_id=" + magazine_id + ", status=" + status
				+ ", start=" + start + ", duration=" + duration + "]\n";
	}
    
	public static Subscriptions map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		int user_id = result.getInt("user_id");
		int magazine_id = result.getInt("magazine_id");
		boolean status = result.getBoolean("status");
		Date start = new Date(result.getDate("start").getTime());
		int duration = result.getInt("duration");
		
		return new Subscriptions(id,user_id,magazine_id,status,start,duration);
	}

}
