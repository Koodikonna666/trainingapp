package hh.palvelinohjelmointi.trainingapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Goal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long goalId;
	
	
	private String name;
	
	
	
	public Goal() {
		
	}
	
	public Goal(String name) {
		this.name = name;
	}


	public Long getGoalId() {
		return goalId;
	}


	public void setGoalId(Long goalId) {
		this.goalId = goalId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Goal [goalId=" + goalId + ", name=" + name + "]";
	}



	
	

}
