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
import hh.palvelinohjelmointi.trainingapp.domain.Event;
import hh.palvelinohjelmointi.trainingapp.domain.Training;
import hh.palvelinohjelmointi.trainingapp.domain.TrainingRepository;

@Controller
public class TrainingController {

	@Autowired
	private TrainingRepository trainingRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	
	@RequestMapping(value="/trainings", method=RequestMethod.GET)
	public String getBooks(Model model) {
		List<Training> trainings = (List<Training>) trainingRepository.findAll();
		model.addAttribute("trainings", trainings);
		return "traininglist";
	}
	
	@PreAuthorize("hasAuthority('ATHLETE')")
	@RequestMapping(value="/addtraining", method=RequestMethod.GET)
	public String getNewTrainingForm(Model model) {
		model.addAttribute("training", new Training());
		model.addAttribute("category", categoryRepository.findAll());
		model.addAttribute("event", new Event());
		return "addtraining";
	}
	
	@RequestMapping(value="/addtraining", method=RequestMethod.POST)
	public String saveTraining(@ModelAttribute Training training) {
		trainingRepository.save(training);
		return "redirect:/trainings";
	}
	
	
	
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long trainingId, Model model) {
    	trainingRepository.deleteById(trainingId);
        return "redirect:../trainings";
    }     
	
	
	
}
