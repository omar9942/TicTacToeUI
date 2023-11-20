module com.example.tictactoeui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tictactoeui to javafx.fxml;
    exports com.example.tictactoeui;
}