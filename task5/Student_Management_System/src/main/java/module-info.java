module org.task5.student_management_system {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens org.task5.student_management_system to javafx.fxml;
    exports org.task5.student_management_system;
}