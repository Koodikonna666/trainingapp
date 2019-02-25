package hh.palvelinohjelmointi.trainingapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.palvelinohjelmointi.trainingapp.domain.Category;
import hh.palvelinohjelmointi.trainingapp.domain.CategoryRepository;
import hh.palvelinohjelmointi.trainingapp.domain.TrainingRepository;

@SpringBootApplication
public class TrainingappApplication {
	
	private static final Logger log = LoggerFactory.getLogger(TrainingappApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(TrainingappApplication.class, args);
	}

	@Bean
	public CommandLineRunner trainingDemo(TrainingRepository trainingRepository, CategoryRepository categoryRepository) {
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
			
			
		};
		
	}
	
	

}
