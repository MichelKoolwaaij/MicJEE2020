package services;

import dto.MicStudent;

import java.util.List;

/**
 * Created by Michel Koolwaaij on 24-09-20.
 */
public interface StudentService {
    public abstract MicStudent getStudent(int nummer);
    public abstract void addStudent(MicStudent student);
    public abstract List<MicStudent> getStudents();
}
