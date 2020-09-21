package services;

import dto.MicStudent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michel Koolwaaij on 18-09-20.
 */
public class StudentService {
    private MicStudent student;
    private List<MicStudent> students = new ArrayList<>();

    public StudentService(){
        student = new MicStudent("Karin",2000,"karin@student.han.nl","555-1212");
        students.add(student);
        students.add(new MicStudent("Peter",2001,"Peter@student.han.nl","555-1241"));
    }

    public MicStudent getStudent() {
        return student;
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
