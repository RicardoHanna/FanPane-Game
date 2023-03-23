package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Chap3Exercice2 extends Application {

	public void start(Stage primaryStage) {
		 FanPane fanPane = new FanPane();

	        KeyFrame keyFrame = new KeyFrame(Duration.millis(10), e-> fanPane.spin());

	        Timeline fanTimeline = new Timeline(keyFrame);
	        fanTimeline.setCycleCount(Timeline.INDEFINITE);
	        fanTimeline.play();

	        Button pause = new Button("Pause");
	        pause.setOnAction(e-> fanTimeline.pause());

	        Button resume = new Button("Resume");
	        resume.setOnAction(e-> fanTimeline.play());

	        Button reverse = new Button("Reverse");
	        reverse.setOnAction(e-> fanPane.increment *= -1);
	        HBox hbox = new HBox(5);
	        hbox.getChildren().add(pause);
	        hbox.getChildren().add(resume);
	        hbox.getChildren().add(reverse);
	        hbox.setSpacing(10);
	        hbox.setAlignment(Pos.CENTER);
	        hbox.setPadding(new Insets(10, 10, 10, 10));
	        BorderPane borderPane = new BorderPane();
	        borderPane.setCenter(fanPane);
	        borderPane.setBottom(hbox);
	        BorderPane.setAlignment(borderPane, Pos.CENTER);
	        Scene scene=new Scene(borderPane,200,200);
	     scene.widthProperty().addListener(e->fanPane.setW());
	       scene.heightProperty().addListener(e->fanPane.setH());
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Chap3Exercice2");
	        primaryStage.show();
	    }
	public static void main(String[] args) {
		launch(args);
		    }

}
