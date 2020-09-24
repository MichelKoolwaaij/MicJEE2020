package services;

import dto.MicStudent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by Michel Koolwaaij on 21-09-20.
 */
public class TestStudentServiceWithoutPersistence {
    private StudentServiceWithoutPersistence sut;

    @BeforeEach
    public void init(){
        sut = new StudentServiceWithoutPersistence();
    }

    @Test
    public void testAddStudent(){
        // arrange
        var student = new MicStudent("Linda",10,"Linda@student.han.nl","555-1113");

        // act
        sut.addStudent(student);

        // assert
        Assertions.assertEquals(1,sut.getStudents().size());
    }
}
