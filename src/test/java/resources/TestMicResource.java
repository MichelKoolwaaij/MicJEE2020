package resources;

import dto.MicStudent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.StudentServiceWithoutPersistence;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by Michel Koolwaaij on 21-09-20.
 */
public class TestMicResource {

    private MicResource sut;
    private StudentServiceWithoutPersistence service;

    @BeforeEach
    public void init(){
        sut = new MicResource();
        service = mock(StudentServiceWithoutPersistence.class);

    }

    @Test
    public void testGetJSONStudent(){
        // arrange
        var student = new MicStudent("Linda",10,"Linda@student.han.nl","555-1113");
        sut.setService(service);
        when(service.getStudent(10)).thenReturn(student);


        // act
        var returnStudent = sut.getJSONStudent(10);

        // assert
        Assertions.assertEquals(student, returnStudent);
    }
}
