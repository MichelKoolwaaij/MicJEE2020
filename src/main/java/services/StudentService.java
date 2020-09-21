package services;

import dto.MicStudent;

/**
 * Created by Michel Koolwaaij on 18-09-20.
 */
public class StudentService {
    private MicStudent student;

    public StudentService(){
        student = new MicStudent("Karin",2000,"karin@student.han.nl","555-1212");
    }

    public MicStudent getStudent() {
        return student;
    }
}
