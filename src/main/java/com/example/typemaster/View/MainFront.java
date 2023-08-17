package com.example.typemaster.View;

import com.example.typemaster.Front;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainFront {
    public static Button RusChar = new Button();;
    public static Button EngChar = new Button();;
    public static Button Text = new Button();;
    public static Button Result = new Button();;

    public static Pane getStartFront() throws FileNotFoundException {
        Pane pane = new Pane();
        pane.setLayoutX(0);
        pane.setLayoutY(0);
        FileInputStream Url;
        if(Front.theme ==1)
            Url = new FileInputStream("png/main_day.png");
        else
            Url = new FileInputStream("png/main_night.png");
        Image url = new Image(Url);
        ImageView front = new ImageView(url);
        front.setX(0);
        front.setY(0);
        pane.getChildren().add(front);

        RusChar = new Button();
        RusChar.setBackground(null);
        RusChar.setLayoutX(300);
        RusChar.setLayoutY(162);
        RusChar.setMaxSize(600,100);
        RusChar.setMinSize(600,100);
        RusChar.setOnAction(t->{
            Front.startRus();
        });
        pane.getChildren().add(RusChar);

        EngChar = new Button();
        EngChar.setBackground(null);
        EngChar.setLayoutX(300);
        EngChar.setLayoutY(307);
        EngChar.setMaxSize(600,100);
        EngChar.setMinSize(600,100);
        EngChar.setOnAction(t->{
            Front.startEng();
        });
        pane.getChildren().add(EngChar);

        Result = new Button();
        Result.setBackground(null);
        Result.setLayoutX(300);
        Result.setLayoutY(597);
        Result.setMaxSize(600,100);
        Result.setMinSize(600,100);
        Result.setOnAction(t ->{
            Front.result();
        });
        pane.getChildren().add(Result);

        Text = new Button();
        Text.setBackground(null);
        Text.setLayoutX(300);
        Text.setLayoutY(452);
        Text.setMaxSize(600,100);
        Text.setMinSize(600,100);
        Text.setOnAction(t ->{
            Front.startText();
        });
        pane.getChildren().add(Text);

        Button changeTheme = new Button();
        changeTheme.setBackground(null);
        changeTheme.setLayoutX(1074);
        changeTheme.setLayoutY(666);
        changeTheme.setMaxSize(100,100);
        changeTheme.setMinSize(100,100);
        pane.getChildren().add(changeTheme);

        changeTheme.setOnAction(t1 ->{
            if(Front.theme==1)
                Front.theme++;
            else
                Front.theme = 1;
            Front.root.getChildren().remove(Front.pane);
            try {
                Front.pane = getStartFront();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Front.root.getChildren().add(Front.pane);
        });

        Button exit = new Button();
        exit.setMaxSize(200,75);
        exit.setMinSize(200,75);
        exit.setLayoutY(716);
        exit.setLayoutX(500);
        pane.getChildren().add(exit);
        exit.setOnAction(t1 ->{
            Front.root.getChildren().remove(Front.pane);
            try {
                Front.pane = StartFront.getStartFront();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Front.root.getChildren().add(Front.pane);
        });

        return pane;
    }
}
