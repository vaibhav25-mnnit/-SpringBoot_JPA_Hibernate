package com.vaibhav25_mnnit.jpa_hibernate.dao;

import com.vaibhav25_mnnit.jpa_hibernate.entity.Course;
import com.vaibhav25_mnnit.jpa_hibernate.entity.Instructor;
import com.vaibhav25_mnnit.jpa_hibernate.entity.InstructorDetails;
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

}
