package hh.palvelinohjelmointi.trainingapp.domain;

import javax.persistence.Entity;

@Entity
public class Event extends Training {

	
	protected String eventName;
	
	public Event(){
	
	}
	
	public Event(String eventName, int reps, int durationHour, int durationMin, int kg, int km) {
		this.eventName = eventName;
		this.reps = getReps();
		this.durationHour = getDurationHour();
		this.durationMin = getDurationMin();
		this.kg = getKg();
		this.km = getKm();
	}

	
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@Override
	public String toString() {
		return "Event [eventName=" + eventName + "]";
	}
	
	
	
}
