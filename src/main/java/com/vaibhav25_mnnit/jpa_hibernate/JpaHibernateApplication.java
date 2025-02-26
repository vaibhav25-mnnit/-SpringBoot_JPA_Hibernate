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
//			createInstructor(appDao);

//			findInstructor(appDao);

			deleteInstructor(appDao);
		};
	}

	private void deleteInstructor(AppDao appDao) {
		int id = 1;
		System.out.println("Deleting instructor with id:- "+id);
		appDao.deleteInstructorById(id);
		System.out.println("Done");
	}

	private void findInstructor(AppDao appDao) {
		int id = 2;

		System.out.println("Finding instructor with id:- "+id);
		Instructor found = appDao.findInstructorById(id);

		System.out.println("Instructor:- "+found.toString());
		System.out.println("the instructor details:- "+found.getInstructorDetails());



	}

	private void createInstructor(AppDao appDao) {

		System.out.println("Creating instructor ");
		Instructor temp = new Instructor("sumit","bagate","sumitsu@gmail.com");

		InstructorDetails inDetail = new InstructorDetails("http://www.youtube.com/sumit","building things");

		temp.setInstructorDetails(inDetail);

		appDao.save(temp);
		System.out.println("Done");
	}

}
