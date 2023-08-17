package com.example.typemaster.KeyBoard;

import javafx.scene.shape.Rectangle;

public class EnBoard {
    public static Rectangle rect1 = new Rectangle(117, 132, 50, 50);//a
    public static Rectangle rect2 = new Rectangle(403, 197, 50, 50);//b
    public static Rectangle rect3 = new Rectangle(276, 197, 50, 50);//c
    public static Rectangle rect4 = new Rectangle(243, 132, 50, 50);//d
    public static Rectangle rect5 = new Rectangle(229, 70, 50, 50);//e
    public static Rectangle rect6 = new Rectangle(306, 132, 50, 50);//f
    public static Rectangle rect7 = new Rectangle(370, 132, 50, 50);//g
    public static Rectangle rect8 = new Rectangle(433, 132, 50, 50);//h
    public static Rectangle rect9 = new Rectangle(544, 70, 50, 50);//i
    public static Rectangle rect10 = new Rectangle(495, 132, 50, 50);//j
    public static Rectangle rect11 = new Rectangle(558, 132, 50, 50);//k
    public static Rectangle rect12 = new Rectangle(623, 132, 50, 50);//l
    public static Rectangle rect13 = new Rectangle(528, 197, 50, 50);//m
    public static Rectangle rect14 = new Rectangle(464, 197, 50, 50);//n
    public static Rectangle rect15 = new Rectangle(608, 70, 50, 50);//o
    public static Rectangle rect16 = new Rectangle(670, 70, 50, 50);//p
    public static Rectangle rect17 = new Rectangle(102, 70, 50, 50);//q
    public static Rectangle rect18 = new Rectangle(292, 70, 50, 50);//r
    public static Rectangle rect19 = new Rectangle(179, 132, 50, 50);//s
    public static Rectangle rect20 = new Rectangle(355, 70, 50, 50);//t
    public static Rectangle rect21 = new Rectangle(481, 70, 50, 50);//u
    public static Rectangle rect22 = new Rectangle(338, 197, 50, 50);//v
    public static Rectangle rect23 = new Rectangle(166, 70, 50, 50);//w
    public static Rectangle rect24 = new Rectangle(214, 197, 50, 50);//x
    public static Rectangle rect25 = new Rectangle(417, 70, 50, 50);//y
    public static Rectangle rect26 = new Rectangle(148, 197, 50, 50);//z

    public static Rectangle getRect(char c) {
        if (c == 'a')
            return rect1;
        else if (c == 'b')
            return rect2;
        else if (c == 'c')
            return rect3;
        else if (c == 'd')
            return rect4;
        else if (c == 'e')
            return rect5;
        else if (c == 'f')
            return rect6;
        else if (c == 'g')
            return rect7;
        else if (c == 'h')
            return rect8;
        else if (c == 'i')
            return rect9;
        else if (c == 'j')
            return rect10;
        else if (c == 'k')
            return rect11;
        else if (c == 'l')
            return rect12;
        else if (c == 'm')
            return rect13;
        else if (c == 'n')
            return rect14;
        else if (c == 'o')
            return rect15;
        else if (c == 'p')
            return rect16;
        else if (c == 'q')
            return rect17;
        else if (c == 'r')
            return rect18;
        else if (c == 's')
            return rect19;
        else if (c == 't')
            return rect20;
        else if (c == 'u')
            return rect21;
        else if (c == 'v')
            return rect22;
        else if (c == 'w')
            return rect23;
        else if (c == 'x')
            return rect24;
        else if (c == 'y')
            return rect25;
        else
            return rect26;
    }
}
