package services;

import dto.MicStudent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michel Koolwaaij on 18-09-20.
 */
public class StudentService {
    private List<MicStudent> students = new ArrayList<>();

    public StudentService(){
   }

    public MicStudent getStudent(int nummer){
        for (MicStudent student : students){
            if (student.getNummer() == nummer){
                return student;
            }
        }
        return null;
    }

    public void addStudent(MicStudent student) {
        students.add(student);
    }

    public List<MicStudent> getStudents() {
        return students;
    }
}
