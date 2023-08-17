package com.example.typemaster.GameLogic;

import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Score{
    public static Text text_score = new Text();
    static Pane pane_score = new Pane();
    public static int score = 0;

    public static Pane getPane(){
        Pane pane = pane_score;
        pane.setMaxSize(100,50);
        pane.setMinSize(100,50);
        pane.setLayoutX(100);
        pane.setLayoutY(43);

        text_score.setText(String.valueOf(score));
        text_score.setLayoutY(0);
        text_score.setLayoutX(0);
        text_score.setFont(Font.font("Bookman", 28));
        pane.getChildren().remove(text_score);
        pane.getChildren().add(text_score);
        return pane;
    }
    public static void StartScore(){
        score = 0;
    }
    public static void addScore(int t){
        score+=t;
        text_score.setText(String.valueOf(score));
    }
}
