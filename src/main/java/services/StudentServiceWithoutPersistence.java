package services;

import dto.MicStudent;
import exceptions.StudentNotFoundException;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michel Koolwaaij on 18-09-20.
 */
@Default
public class StudentServiceWithoutPersistence implements StudentService {
    private List<MicStudent> students = new ArrayList<>();

    public StudentServiceWithoutPersistence(){
   }

    public MicStudent getStudent(int nummer){
        for (MicStudent student : students){
            if (student.getNummer() == nummer){
                return student;
            }
        }
        throw new StudentNotFoundException();
    }

    public void addStudent(MicStudent student) {
        students.add(student);
    }

    public List<MicStudent> getStudents() {
        return students;
    }
}
