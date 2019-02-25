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
	
	private String title;
	private double duration;
	private String description;
	
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;
	
	
	// Konstruktorit
	
	public Training() {
		super();
		this.title = null;
		this.category = null;
		this.duration = 0;
		this.description = null;
		
	}
	
	public Training(String title, Category category, double duration, String description) {
		super();
		this.title = title;
		this.category = category;
		this.duration = duration;
		this.description = description;
		
		
	}

	
	//Getterit ja Setterit
	
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Training [trainingId=" + trainingId + ", title=" + title + ", duration=" + duration + ", description="
				+ description + ", category=" + category + "]";
	}
	

	
	
	
	
	
	
	
}
