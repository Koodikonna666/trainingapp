package hh.palvelinohjelmointi.trainingapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.palvelinohjelmointi.trainingapp.domain.CategoryRepository;
import hh.palvelinohjelmointi.trainingapp.domain.Competition;
import hh.palvelinohjelmointi.trainingapp.domain.CompetitionRepository;
import hh.palvelinohjelmointi.trainingapp.domain.Event;
import hh.palvelinohjelmointi.trainingapp.domain.Goal;
import hh.palvelinohjelmointi.trainingapp.domain.GoalRepository;
import hh.palvelinohjelmointi.trainingapp.domain.Training;
import hh.palvelinohjelmointi.trainingapp.domain.TrainingRepository;

@Controller
public class TrainingController {

	@Autowired
	private TrainingRepository trainingRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private GoalRepository goalRepository;
	
	@Autowired
	private CompetitionRepository competitionRepository;
	
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	
	@RequestMapping(value="/trainings", method=RequestMethod.GET)
	public String getBooks(Model model) {
		List<Training> trainings = (List<Training>) trainingRepository.findAll();
		model.addAttribute("trainings", trainings);
		List<Goal> goals = (List<Goal>) goalRepository.findAll();
		model.addAttribute("goals", goals);
		List<Competition> competitions = (List<Competition>) competitionRepository.findAll();
		model.addAttribute("competitions", competitions);
		return "traininglist";
	}
	
	@PreAuthorize("hasAuthority('ATHLETE')")
	@RequestMapping(value="/addtraining", method=RequestMethod.GET)
	public String getNewTrainingForm(Model model) {
		model.addAttribute("training", new Training());
		model.addAttribute("category", categoryRepository.findAll());
		model.addAttribute("event", new Event());
		List<Training> trainings = (List<Training>) trainingRepository.findAll();
		model.addAttribute("trainings", trainings);
		return "addtraining";
	}
	
	@RequestMapping(value="/addtraining", method=RequestMethod.POST)
	public String saveTraining(@ModelAttribute Training training) {
		trainingRepository.save(training);
		return "redirect:/trainings";
	}
	
	
	
    @RequestMapping(value = "/deletetraining/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long trainingId, Model model) {
    	trainingRepository.deleteById(trainingId);
        return "redirect:../addtraining";
    }     
    
    
    
    
    
	
    
	@PreAuthorize("hasAuthority('ATHLETE')")
	@RequestMapping(value="/goals", method=RequestMethod.GET)
	public String getNewGoalForm(Model model) {
		model.addAttribute("goal", new Goal());
		return "goals";
	}
	
	@RequestMapping(value="/goals", method=RequestMethod.POST)
	public String saveGoal(@ModelAttribute Goal goal) {
		goalRepository.save(goal);
		return "redirect:/trainings";
	}
	
	@PreAuthorize("hasAuthority('ATHLETE')")
    @RequestMapping(value = "/deletegoal/{id}", method = RequestMethod.GET)
    public String deleteGoal(@PathVariable("id") Long goalId, Model model) {
    	goalRepository.deleteById(goalId);
        return "redirect:../trainings";
    }     
    
	
	
	
    
	@PreAuthorize("hasAuthority('COACH')")
	@RequestMapping(value="/competitions", method=RequestMethod.GET)
	public String getNewCompetitionForm(Model model) {
		model.addAttribute("competition", new Competition());
		List<Competition> competitions = (List<Competition>) competitionRepository.findAll();
		model.addAttribute("competitions", competitions);
		return "competitions";
	}
	
	
	@RequestMapping(value="/competitions", method=RequestMethod.POST)
	public String saveCompetition(@ModelAttribute Competition competition) {
		competitionRepository.save(competition);
		return "redirect:/competitions";
	}
	
	@PreAuthorize("hasAuthority('COACH')")
    @RequestMapping(value = "/deletecompetition/{id}", method = RequestMethod.GET)
    public String deleteCompetition(@PathVariable("id") Long competitionId, Model model) {
    	competitionRepository.deleteById(competitionId);
        return "redirect:../competitions";

}
}
