package examples;

import io.reactivex.Observable;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import io.reactivex.schedulers.Schedulers;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public final class Ch7_16 extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // build UI
        VBox root = new VBox();
        ListView<String> listView = new ListView<>();
        listView.getItems().setAll("Alpha","Beta","Gamma", "Delta","Epsilon","Zeta","Eta");
        ListView<String> itemsView = new ListView<>();
        root.getChildren().addAll(listView, itemsView);
        stage.setScene(new Scene(root));
        stage.show();

        // create letter break-up operation
        JavaFxObservable.emitOnChanged(listView.getSelectionModel().getSelectedItems())
                .switchMap ( list ->
                        Observable.fromIterable(list)
                            .delay(3, TimeUnit.SECONDS, Schedulers.io())
                            .switchMap(s -> Observable.fromArray(s.split("(?!^)")))
                            .toList().toObservable()
                ).observeOn(JavaFxScheduler.platform())
                .subscribe(l -> itemsView.getItems().setAll(l));
    }
}