package com.vaibhav25_mnnit.jpa_hibernate.dao;

import com.vaibhav25_mnnit.jpa_hibernate.entity.Course;
import com.vaibhav25_mnnit.jpa_hibernate.entity.Instructor;
import com.vaibhav25_mnnit.jpa_hibernate.entity.InstructorDetails;
import com.vaibhav25_mnnit.jpa_hibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDaoImpl  implements AppDao{

    private EntityManager entityManager;

    @Autowired
    public  AppDaoImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {

        Instructor theInstructor = findInstructorById(id);

        //remove the association of instructor to be deleted from all of it's courses
        List<Course> courses =  theInstructor.getCourses();
        for(Course theCourse:courses)
        {
            theCourse.setInstructor(null);
        }
        entityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetails findInstructorDetailsById(int id)
    {
        return entityManager.find(InstructorDetails.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailsById(int id) {
        InstructorDetails instructorDetails = findInstructorDetailsById(id);
         instructorDetails.getInstructor().setInstructorDetails(null);
        entityManager.remove(instructorDetails);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {

        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data",Course.class
        );
        query.setParameter("data",id);
        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        //create query
        TypedQuery<Instructor> query = entityManager.createQuery(
          "select i from Instructor i "
                  + "JOIN FETCH i.courses "
                  + "JOIN FETCH i.instructorDetails "
                + "where i.id = :data",Instructor.class
        );
        query.setParameter("data",id);


        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class,id);

        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsById(int id)
    {
        TypedQuery<Course> query = entityManager.createQuery(
          "select c from Course c "
          + "join fetch c.reviews "
                +"where c.id = :data",Course.class
        );

        query.setParameter("data",id);

        return query.getSingleResult();
    }

    @Override
    public Course findCourseAndStudentsById(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                        + "join fetch c.students "
                        +"where c.id = :data",Course.class
        );

        query.setParameter("data",id);
        return query.getSingleResult();
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int id) {
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s "
                        + "join fetch s.courses "
                        +"where s.id = :data",Student.class
        );

        query.setParameter("data",id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {

        Student tempStudent = entityManager.find(Student.class, id);

        if (tempStudent != null) {

            // get the courses
            List<Course> courses = tempStudent.getCourses();

            // break association of all courses for the student
            for (Course tempCourse : courses) {
                tempCourse.getStudents().remove(tempStudent);
            }

            // Now delete the student
            entityManager.remove(tempStudent);
        }


    }
}
