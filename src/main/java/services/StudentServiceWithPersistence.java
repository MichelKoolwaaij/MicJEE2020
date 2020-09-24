package services;

import datasource.StudentDAO;
import dto.MicStudent;
import exceptions.StudentNotFoundException;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Michel Koolwaaij on 24-09-20.
 */
@Alternative
public class StudentServiceWithPersistence implements StudentService{
    StudentDAO dao;

    @Inject
    public void setDao(StudentDAO dao){
        this.dao = dao;
    }

    @Override
    public MicStudent getStudent(int nummer) {
        try {
            return dao.getStudent(nummer);
        } catch (SQLException e) {
            throw new StudentNotFoundException();
        }
    }

    @Override
    public void addStudent(MicStudent student) {

    }

    @Override
    public List<MicStudent> getStudents() {
        return dao.findAll();
    }
}
