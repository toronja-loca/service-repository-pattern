package DbTest;

import models.Register;
import models.Student;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.RegisterService;
import service.StudentService;

public class BaseTest {
    private static StudentService studentService;
    private static RegisterService registerService;

    @BeforeEach
    public void setUp(){
        studentService = new StudentService();
        registerService = new RegisterService();
    }

    @AfterAll
    static void tearDown(){
        registerService.deleteAll();
        studentService.deleteAll();
    }

    @Test()
    public void allFuncRegister(){
        Register reg = new Register(7,1,"bob");
        registerService.save(reg);
        System.out.println(registerService.getById(7));
        System.out.println("***");
        System.out.println(registerService.findAll());
        System.out.println("***");
    }

    @Test
    public void allFuncsStudent(){
        Student stud = new Student(3,"name","lastname",5);
        studentService.save(stud);
        System.out.println("***");
        System.out.println(studentService.getById(3));
        System.out.println("***");
        System.out.println(studentService.findAll());
    }

}
