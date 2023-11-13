package org.task5.student_management_system;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
        stage.setResizable(false);
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/main_window.fxml"));
        Scene scene = new Scene(loader.load());

        stage.setScene(scene);
        stage.show();

    }
}
