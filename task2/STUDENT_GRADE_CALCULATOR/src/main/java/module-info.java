module org.task2.student_grade_calculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens org.task2.student_grade_calculator to javafx.fxml;
    exports org.task2.student_grade_calculator;
}