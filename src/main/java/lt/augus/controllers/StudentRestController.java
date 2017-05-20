package lt.augus.controllers;

import lt.augus.cdi.dao.StudentDAO;
import lt.augus.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
public class StudentRestController {

    @Inject
    private EntityManager em;
    @Inject
    private StudentDAO studentDAO;

    @GET
    @Path("/find/{studentId}")
    public Student find(@PathParam("studentId") Integer studentId) {
        return studentDAO.findById(studentId);
    }

    @POST
    @Path("/create")
    @Transactional
    public Student create(Student student){
        studentDAO.create(student);
        return student;
    }

    @PUT
    @Path("/update")
    @Transactional
    public Student update(Student student){
        studentDAO.update(student);
        return student;
    }
}
