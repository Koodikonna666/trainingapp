package hh.palvelinohjelmointi.trainingapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.palvelinohjelmointi.trainingapp.web.TrainingController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainingappApplicationTests {

	
	
	@Autowired
	private TrainingController trainingController;
	
	
	@Test
	public void contextLoads() throws Exception{
		assertThat(trainingController).isNotNull();
	}

}
