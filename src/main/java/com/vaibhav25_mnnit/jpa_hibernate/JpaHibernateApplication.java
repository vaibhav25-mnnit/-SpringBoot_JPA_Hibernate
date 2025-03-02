package com.vaibhav25_mnnit.jpa_hibernate;

import com.vaibhav25_mnnit.jpa_hibernate.dao.AppDao;
import com.vaibhav25_mnnit.jpa_hibernate.entity.*;
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
//			findInstructorWithCourses(appDao);
//			findInstructorWithCoursesByJoinFetch(appDao);

//			updateInstructor(appDao);
//			updateCourse(appDao);

//			deleteCourse(appDao);

//			createCourseAndReviews(appDao);

//			retriveCourseAndReviews(appDao);

//			deleteCourseAndReviews(appDao);

//			createCourseAndStudents(appDao);
			retriveCourseAndStudents(appDao);

		};

		
		


	}

	private void retriveCourseAndStudents( AppDao appDao) {
		int id = 10;
		System.out.println("Finding course and students with id:- "+id);

		Course foundCourse = appDao.findCourseAndStudentsById(id);

		System.out.println("Course "+foundCourse);
		System.out.println("Students "+foundCourse.getStudents());

		System.out.println("Done");

	}

	private void createCourseAndStudents(AppDao appDao) {
		System.out.println("Creating course with students");
		// create
		Course newCourse = new Course("learning to many to many relationship");

		Student newStudent = new Student("vaibhav","bagate","vb@mail.com");
		Student newStudent2 = new Student("sumit","bagate","sb@mail.com");

		newCourse.addStudent(newStudent);
		newCourse.addStudent(newStudent2);


		appDao.saveCourse(newCourse);

		System.out.println("Done");
	}

	private void deleteCourseAndReviews(AppDao appDao) {
	}

	private void retriveCourseAndReviews(AppDao appDao) {
		int id = 10;
		System.out.println("Getting Course and Reviews for id "+id);
		Course course = appDao.findCourseAndReviewsById(id);

		System.out.println(course);
		System.out.println(course.getReviews());

		System.out.println("Done");
	}

	private void createCourseAndReviews(AppDao appDao) {
		System.out.println("adding course with reviews");
		Course course = new Course("How to play perfect any game.");

		course.addReview(new Review("good course"));
		course.addReview(new Review("excellent course"));
		course.addReview(new Review("learnt very much from this"));

		appDao.saveCourse(course);

		System.out.println("Done");
	}

	private void deleteCourse(AppDao appDao) {
		int id = 10;
		System.out.println("Deleting course with id "+id);
		appDao.deleteCourseById(id);
		System.out.println("Done");
	}


	private void updateCourse(AppDao appDao) {
		System.out.println("Updating Course");
		int id = 10;
		Course course = appDao.findCourseById(id);

		course.setTitle("Learning Advanced hibernate mappings in spring boot");

		appDao.updateCourse(course);

		System.out.println("Done");
	}

	private void updateInstructor(AppDao appDao) {
		System.out.println("Updating Instructor");
		int id = 1;
		Instructor instructor = appDao.findInstructorById(id);

		instructor.setFirstName("Ganu");
		instructor.setLastName("Sumit");
		instructor.setEmail("ganusumit@mail.com");
		appDao.updateInstructor(instructor);

		System.out.println("Done");
	}

	private void findInstructorWithCoursesByJoinFetch(AppDao appDao) {
		System.out.println("Finding instructor with join query");
		int id = 1;
		Instructor instructor = appDao.findInstructorByIdJoinFetch(id);

		System.out.println("Found Instructor :- "+instructor);
		System.out.println("Courses :- "+instructor.getCourses());
		System.out.println("Done");
	}

	private void findInstructorWithCourses(AppDao appDao) {
		System.out.println("Finding instructor using 2 queries");
		int id = 1;
		Instructor instructor = appDao.findInstructorById(id);

		System.out.println("FoundInstructor:- "+instructor);

		List<Course> courses = appDao.findCoursesByInstructorId(instructor.getId());

		instructor.setCourses(courses);

		System.out.println("Courses:- "+instructor.getCourses());

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
