package com.example.typemaster.GameLogic;

import com.example.typemaster.Front;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class TimeCounter {
    public static int[] time = {60};
    static Pane time_pane = new Pane();
    static Text text_time = new Text();
    static Timeline timeline;

    public static Pane getPane(){
        Pane pane = time_pane;
        pane.setMaxSize(100,50);
        pane.setMinSize(100,50);
        pane.setLayoutX(1100);
        pane.setLayoutY(43);

        text_time.setText(String.valueOf(time[0]));
        text_time.setLayoutY(0);
        text_time.setLayoutX(0);
        text_time.setFont(Font.font("Bookman", 28));
        if(Front.theme == 2){
            text_time.setFill(Color.WHITE);
        }
        pane.getChildren().remove(text_time);
        pane.getChildren().add(text_time);
        return pane;
    }
    public static void startTimer() throws InterruptedException {
        if(Front.theme == 2)
            text_time.setStyle("-fx-text-fill: white;");
        timeline = new Timeline(new KeyFrame(
                Duration.seconds(1), actionEvent -> {
            if(time[0]<1) {
                text_time.setText("0");
                stopTimer();
            }
            else{
                time[0]--;
                text_time.setText(" " + time[0]);
            }
        }
        ));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    public static void addTime(){
        time[0]+=5;
    }
    public static void stopTimer(){
        timeline.stop();
    }
    public static void subTime(){
        time[0]-=10;
    }
}

