package org.task5.student_management_system;

import javafx.stage.Stage;
import org.task5.student_management_system.dao.StudentDAO;
import org.task5.student_management_system.model.Student;
import javafx.application.Application;

import java.util.Date;

public class Main extends Application{
    public static void main(String[] args) {
        System.out.println(System.getProperty("CD: " + "user.dir", "."));
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        StudentDAO studentDAO = new StudentDAO();

        Date date = new Date();
        Student student = new Student("Percival",
                "Gebashe",
                "0312345678",
                "p@g",
                new Date(1997, 9, 26),
                "some place in the universe", new Date());

        studentDAO.addStudent(student);

        studentDAO.closeSession();

    }
}
