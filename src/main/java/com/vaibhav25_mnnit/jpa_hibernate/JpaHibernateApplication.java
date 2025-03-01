package com.vaibhav25_mnnit.jpa_hibernate;

import com.vaibhav25_mnnit.jpa_hibernate.dao.AppDao;
import com.vaibhav25_mnnit.jpa_hibernate.entity.Course;
import com.vaibhav25_mnnit.jpa_hibernate.entity.Instructor;
import com.vaibhav25_mnnit.jpa_hibernate.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
//			deleteInstructor(appDao);
//			findInstructorDetails(appDao);
//			deleteInstructorDetails(appDao);

//			createInstructorWithCourse(appDao);
			findInstructorWithCourses(appDao);
		};


	}

	private void findInstructorWithCourses(AppDao appDao) {
		int id = 1;
		Instructor instructor = appDao.findInstructorById(id);

		System.out.println("FoundInstructor:- "+instructor);

		List<Course> courses = appDao.findCoursesByInstructorId(instructor.getId());

		System.out.println("Courses:- "+courses);

		System.out.println("Done");
	}

	private void createInstructorWithCourse(AppDao appDao) {
		System.out.println("Creating instructor with courses");
		Instructor temp = new Instructor("sumit","bagate","sumit@gmail.com");

		InstructorDetails inDetail = new InstructorDetails("http://www.youtube.com/sumit","building things");

		Course theCourse1  = new Course("Learning spring boot");
		Course theCourse2  = new Course("Learning node js");
		Course theCourse3  = new Course("Learning React");

		temp.setInstructorDetails(inDetail);

		temp.add(theCourse1);
		temp.add(theCourse2);
		temp.add(theCourse3);


		appDao.save(temp);

		System.out.println("Done");
	}

	private void deleteInstructorDetails(AppDao appDao) {
		int id = 3;
		System.out.println("Deleting instructor details with id:- "+id);
		appDao.deleteInstructorDetailsById(id);
		System.out.println("Done");
	}

	private void findInstructorDetails(AppDao appDao) {
		int id = 2;
		System.out.println("Finding Instructor Details id:- "+id);
		InstructorDetails instructorDetails = appDao.findInstructorDetailsById(id);

		System.out.println(instructorDetails.toString());

		Instructor instructor = instructorDetails.getInstructor();

		System.out.println(instructor.toString());

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
