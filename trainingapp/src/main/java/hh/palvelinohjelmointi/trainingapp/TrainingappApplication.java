package hh.palvelinohjelmointi.trainingapp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.palvelinohjelmointi.trainingapp.domain.Category;
import hh.palvelinohjelmointi.trainingapp.domain.CategoryRepository;
import hh.palvelinohjelmointi.trainingapp.domain.Competition;
import hh.palvelinohjelmointi.trainingapp.domain.CompetitionRepository;
import hh.palvelinohjelmointi.trainingapp.domain.Goal;
import hh.palvelinohjelmointi.trainingapp.domain.GoalRepository;
import hh.palvelinohjelmointi.trainingapp.domain.Training;
import hh.palvelinohjelmointi.trainingapp.domain.TrainingRepository;
import hh.palvelinohjelmointi.trainingapp.domain.User;
import hh.palvelinohjelmointi.trainingapp.domain.UserRepository;

@SpringBootApplication
public class TrainingappApplication {
	
	private static final Logger log = LoggerFactory.getLogger(TrainingappApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(TrainingappApplication.class, args);
	}

	@Bean
	public CommandLineRunner trainingDemo(TrainingRepository trainingRepository, CategoryRepository categoryRepository, UserRepository userRepository, CompetitionRepository competitionRepository, GoalRepository goalRepository) {
		return(args) ->{
			log.info("Lisätään kategoriat");
			
			Category nopeus = new Category("Nopeus");
			categoryRepository.save(nopeus);
			
			Category voima = new Category("Voima");
			categoryRepository.save(voima);
			
			Category aerobia = new Category("Aerobia");
			categoryRepository.save(aerobia);
			
			Category liikkuvuus = new Category("Liikkuvuus");
			categoryRepository.save(liikkuvuus);
			
			Category nopeuskestavyys = new Category("Nopeuskestävyys");
			categoryRepository.save(nopeuskestavyys);
			
			Category nopeusvoima = new Category("Nopeusvoima");
			categoryRepository.save(nopeusvoima);
			
			Category kilpailu = new Category("Kilpailu");
			categoryRepository.save(kilpailu);
			
			
			User user1 = new User("lehtonen.osku@gmail.com","$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "ATHLETE", "Oskari", "Lehtonen", "Nurmijärven Yleisurheilu");
			User user2 = new User("vebon@gmail.com","$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "COACH", "Vesa", "Sjöstedt", "HIFK" );
			userRepository.save(user1);
			userRepository.save(user2);
			
			
			Competition example = new Competition("Kalevan Kisat", "Lappeenranta", "17-8-2019", "100m, 200m");
			competitionRepository.save(example);
			Competition example2 = new Competition("MM-kisat", "Doha", "10-10-2019", "4x100m");
			competitionRepository.save(example2);
			
			Goal goal1 = new Goal("100m alle 10.50");
			goalRepository.save(goal1);
			Goal goal2 = new Goal("100m alle 10.50");
			goalRepository.save(goal2);
			
			
			Training training1 = new Training(aerobia, 120, "Kävin lenkillä. Tein päkiähyppyjä sekä isovuorohyppyjä", "20-02-2019");
			trainingRepository.save(training1);
			Training training2 = new Training(nopeusvoima, 69, "Kävin puntilla. Tein räjähtäviä kyykkyjä, vatsalihaksia, pohkeita sekä penkkiä.", "20-02-2019");
			trainingRepository.save(training2);
			
			
			
		};
		
	}
	
	

}
