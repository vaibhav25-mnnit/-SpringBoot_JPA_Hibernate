package com.vaibhav25_mnnit.jpa_hibernate.dao;


import com.vaibhav25_mnnit.jpa_hibernate.entity.Course;
import com.vaibhav25_mnnit.jpa_hibernate.entity.Instructor;
import com.vaibhav25_mnnit.jpa_hibernate.entity.InstructorDetails;
import com.vaibhav25_mnnit.jpa_hibernate.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AppDao {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetails findInstructorDetailsById(int id);

    void deleteInstructorDetailsById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void updateInstructor(Instructor instructor);

    Course findCourseById(int id);

    void  updateCourse(Course course);

    void  deleteCourseById(int id);


    void saveCourse(Course course);

    Course findCourseAndReviewsById(int id);

    Course findCourseAndStudentsById(int id);

    Student findStudentAndCoursesByStudentId(int id);

    void updateStudent(Student student);

    void deleteStudent(int id);
}
