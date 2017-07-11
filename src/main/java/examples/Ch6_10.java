// https://api.github.com/users/thomasnield/starred
package examples;

import io.reactivex.rxjavafx.observables.JavaFxObservable;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import io.reactivex.schedulers.Schedulers;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Scanner;

public class Ch6_10 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();
        Label label = new Label("Input URL");
        TextField input = new TextField();
        TextArea outputArea = new TextArea();
        Button button = new Button("Submit");

        outputArea.setWrapText(true);

        vBox.getChildren().setAll(label,input,outputArea,button);
        stage.setScene(new Scene(vBox));
        stage.show();

        //emit button events and concurrently retrieve and display request
        JavaFxObservable.actionEventsOf(button)
                .map(ae -> input.getText())
                .observeOn(Schedulers.io())
                .map(path -> getResponse(path))
                .observeOn(JavaFxScheduler.platform())
                .subscribe(outputArea::setText);

    }
    private static String getResponse(String path) {
        try {
            return new Scanner(new URL(path).openStream(), "UTF-8").useDelimiter("\\A").next();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}