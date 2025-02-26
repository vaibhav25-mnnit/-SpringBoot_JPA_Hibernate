package com.vaibhav25_mnnit.jpa_hibernate;

import com.vaibhav25_mnnit.jpa_hibernate.dao.AppDao;
import com.vaibhav25_mnnit.jpa_hibernate.entity.Instructor;
import com.vaibhav25_mnnit.jpa_hibernate.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){

		return  runner -> {
			creaateInstructor(appDao);
//			System.out.println("Hello world");
		};
	}

	private void creaateInstructor(AppDao appDao) {
		Instructor temp = new Instructor("sumit","bagate","sumitsu@gmail.com");

		InstructorDetails inDetail = new InstructorDetails("http://www.youtube.com/sumit","building things");

		temp.setInstructorDetails(inDetail);

		appDao.save(temp);
	}

}
