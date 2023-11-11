module Number.Game {

    requires javafx.controls;
    requires  javafx.fxml;
    requires javafx.graphics;

    exports org.task1.number_game.gui to javafx.graphics, javafx.fxml;
    opens org.task1.number_game.gui to javafx.fxml;
}