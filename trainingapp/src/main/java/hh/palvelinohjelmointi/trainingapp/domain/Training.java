package hh.palvelinohjelmointi.trainingapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Training {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long trainingId;
	
	private int duration;
	protected int durationHour;
	protected int durationMin;
	private String description;
	private String date;
	private String comment;
	protected int reps;
	protected int kg;
	protected double km;
	
	
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;
	
	
	// Konstruktorit
	
	public Training() {
		super();
		this.category = null;
		this.duration = 0;
		this.durationHour = 0;
		this.durationMin = 0;
		this.description = null;
		this.comment = null;
		this.date = null;
		this.reps = 0;
		this.kg = 0;
		this.km = 0;
		
	}
	
	public Training(Category category, int duration, String description, String date) {
		super();
		this.category = category;
		this.duration = duration;
		this.description = description;
		this.date = date;
		
	}
	
	
	 
	
	
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getDurationHour() {
		return durationHour;
	}

	public void setDurationHour(int durationHour) {
		this.durationHour = durationHour;
	}

	public int getDurationMin() {
		return durationMin;
	}

	public void setDurationMin(int durationMin) {
		this.durationMin = durationMin;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public int getKg() {
		return kg;
	}

	public void setKg(int kg) {
		this.kg = kg;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	
	//Getterit ja Setterit
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(Long trainingId) {
		this.trainingId = trainingId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Training [trainingId=" + trainingId + ", durationHour=" + durationHour + ", durationMin=" + durationMin
				+ ", description=" + description + ", date=" + date + ", reps=" + reps + ", kg=" + kg + ", km=" + km
				+ ", category=" + category + "]";
	}

	
	


	
	
	
	
	
	
}
