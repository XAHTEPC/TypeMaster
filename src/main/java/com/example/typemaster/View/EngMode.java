package com.example.typemaster.View;

import com.example.typemaster.Front;
import com.example.typemaster.GameLogic.Score;
import com.example.typemaster.GameLogic.TimeCounter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EngMode {
    public static Pane paneEng_Board;
    public static Text EngText;
    public static Pane getStartFront() throws FileNotFoundException {
        Pane pane = new Pane();
        paneEng_Board = new Pane();
        Pane timePane = TimeCounter.getPane();
        Pane scorePane = Score.getPane();
        pane.setLayoutX(0);
        pane.setLayoutY(0);
        FileInputStream Url;
        if( Front.theme ==1)
            Url = new FileInputStream("png/engMode_day.png");
        else
            Url = new FileInputStream("png/engMode_night.png");
        Image url = new Image(Url);
        ImageView front = new ImageView(url);
        front.setX(0);
        front.setY(0);
        paneEng_Board.setLayoutX(139);
        paneEng_Board.setLayoutY(400);
        paneEng_Board.setMaxSize(922,321);
        paneEng_Board.setMinSize(922,321);
        pane.getChildren().add(front);
        EngText = new Text();
        EngText.setLayoutY(280);
        EngText.setLayoutX(500);
        EngText.setFont(Font.font("Bookman", 28));
        pane.getChildren().addAll(paneEng_Board, EngText,timePane, scorePane);

        return pane;
    }
}
