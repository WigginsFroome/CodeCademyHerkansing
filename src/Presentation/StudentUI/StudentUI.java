package Presentation.StudentUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentUI extends Application{
    
    @Override
    public void start(Stage windows){

        Label label = new Label("Choose one of the options for the student class");
        Button create = new Button("Create");
        Button read = new Button("Read");
        Button update = new Button("Update");
        Button delete = new Button("Delete");
        Button home = new Button("Return home");

        VBox box = new VBox();

        Scene scene = new Scene(box,200,200);
        box.getChildren().addAll(label, create, read, update, delete, home);
        box.setSpacing(5);

        windows.setTitle("Student");

        windows.setScene(scene);
        windows.show();
    }

    
}
