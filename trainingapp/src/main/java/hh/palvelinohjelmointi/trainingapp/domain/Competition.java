package hh.palvelinohjelmointi.trainingapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Competition {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long competitionId;
	
	
	private String name;
	private String place;
	private String date;
	private String event;
	
	
	public Competition() {
		
	}
	
	public Competition(String name, String place, String date, String event) {
		this.name = name;
		this.place = place;
		this.date = date;
		this.event = event;
		
	}
	

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Long getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(Long competitionId) {
		this.competitionId = competitionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Competition [competitionId=" + competitionId + ", name=" + name + ", place=" + place + ", date=" + date
				+ ", event=" + event + "]";
	}
	
	
	
	
	
	
}
