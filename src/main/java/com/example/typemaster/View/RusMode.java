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

public class RusMode {
    public static Pane paneRus_Board;
    public static Text RusText;
    public static Pane getStartFront() throws FileNotFoundException {
        Pane pane = new Pane();
        paneRus_Board = new Pane();
        Pane timePane = TimeCounter.getPane();
        Pane scorePane = Score.getPane();
        pane.setLayoutX(0);
        pane.setLayoutY(0);
        FileInputStream Url;
        if(Front.theme==1)
            Url = new FileInputStream("png/rusMode_day.png");
        else
            Url = new FileInputStream("png/rusMode_night.png");
        Image url = new Image(Url);
        ImageView front = new ImageView(url);
        front.setX(0);
        front.setY(0);
        paneRus_Board.setLayoutX(136);
        paneRus_Board.setLayoutY(400);
        paneRus_Board.setMaxSize(928,328);
        paneRus_Board.setMinSize(928,328);
        RusText = new Text();
        RusText.setLayoutY(280);
        RusText.setLayoutX(500);
        RusText.setFont(Font.font("Bookman", 28));

        pane.getChildren().add(front);
        pane.getChildren().addAll(paneRus_Board, RusText,timePane, scorePane);
        return pane;
    }
}
