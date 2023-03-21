package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Calculator extends Application {
    private enum Operation {
        ADD, SUB, MUL, DIV, EQ
    }

    private Double curDig;
    Operation curOper = Operation.EQ;

    private Button shortButton(String nameBtn)
    {
        Button btn = new Button(nameBtn);
        btn.setMinWidth(60);
        btn.setMinHeight(50);
        btn.setFont(new Font(20));
        return btn;
    }

    private Button longButton(String nameBtn)
    {
        Button btn = new Button(nameBtn);
        btn.setMinWidth(135);
        btn.setMinHeight(50);
        btn.setFont(new Font(20));
        return btn;
    }

    private void setDigitAction(Button btn, Label text, String dig)
    {
        btn.setOnAction( event -> {
            text.setText(text.getText() + dig);
        });
    }

    private void equalAction(Label text)
    {
        if (text.getText().isEmpty())
        {
            return;
        }

        Double result = 0.0;
        System.out.print("Equal\n");
        System.out.print(curDig);
        System.out.print("\n");
        System.out.print(text.getText());
        System.out.print("\n");
        System.out.print(curDig + Integer.parseInt(text.getText()));
        System.out.print("\n");

        switch (curOper)
        {
            case SUB:
                result = curDig - Double.parseDouble(text.getText());
                break;
            case DIV:
                result = curDig / Double.parseDouble(text.getText());
                break;
            case MUL:
                result = curDig * Double.parseDouble(text.getText());
                break;
            case ADD:
                result = curDig + Double.parseDouble(text.getText());
                break;
            case EQ:
                return;
        }

        curOper = Operation.EQ;
        curDig = result;

        if (curDig == Math.round(curDig))
        {
            text.setText(Math.round(curDig) + "");
            return;
        }

        text.setText(curDig + "");
    }

    @Override
    public void start(Stage stage) throws IOException
    {
        Integer marg = 12;
        HBox row1 = new HBox(marg);
        row1.setAlignment(Pos.CENTER);
        Button button1 = shortButton("1");
        Button button2 = shortButton("2");
        Button button3 = shortButton("3");
        Button buttonDiv = shortButton("/");
        row1.getChildren().addAll(button1, button2, button3, buttonDiv);

        HBox row2 = new HBox(marg);
        row2.setAlignment(Pos.CENTER);
        Button button4 = shortButton("4");
        Button button5 = shortButton("5");
        Button button6 = shortButton("6");
        Button buttonMul = shortButton("*");
        row2.getChildren().addAll(button4, button5, button6, buttonMul);

        HBox row3 = new HBox(marg);
        row3.setAlignment(Pos.CENTER);
        Button button7 = shortButton("7");
        Button button8 = shortButton("8");
        Button button9 = shortButton("9");
        Button buttonMinus = shortButton("-");
        row3.getChildren().addAll(button7, button8, button9, buttonMinus);

        HBox row4 = new HBox(marg);
        row4.setAlignment(Pos.CENTER);
        Button button0 = longButton("0");
        Button buttonEq = shortButton("=");
        Button buttonPlus = shortButton("+");
        row4.getChildren().addAll(button0, buttonEq, buttonPlus);

        Label text = new Label();
        text.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        text.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        text.setMinWidth(button1.getMinWidth() * 4 + marg * 3);
        text.setMinHeight(65);

        setDigitAction(button0, text, "0");
        setDigitAction(button1, text, "1");
        setDigitAction(button2, text, "2");
        setDigitAction(button3, text, "3");
        setDigitAction(button4, text, "4");
        setDigitAction(button5, text, "5");
        setDigitAction(button6, text, "6");
        setDigitAction(button7, text, "7");
        setDigitAction(button8, text, "8");
        setDigitAction(button9, text, "9");

        buttonPlus.setOnAction( event -> {
            if (curOper != Operation.EQ)
            {
                equalAction(text);
            }

            curDig = Double.parseDouble(text.getText());
            curOper = Operation.ADD;
            text.setText("");
        });

        buttonMinus.setOnAction( event -> {
            if (curOper != Operation.EQ)
            {
                equalAction(text);
            }

            curDig = Double.parseDouble(text.getText());
            curOper = Operation.SUB;
            text.setText("");
        });

        buttonMul.setOnAction( event -> {
            if (curOper != Operation.EQ)
            {
                equalAction(text);
            }

            curDig = Double.parseDouble(text.getText());
            curOper = Operation.MUL;
            text.setText("");
        });

        buttonDiv.setOnAction( event -> {
            if (curOper != Operation.EQ)
            {
                equalAction(text);
            }

            curDig = Double.parseDouble(text.getText());
            curOper = Operation.DIV;
            text.setText("");
        });

        buttonEq.setOnAction(event -> {
            equalAction(text);
        });

        VBox root = new VBox(marg);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(text, row1, row2, row3, row4);

        Scene scene = new Scene(root, 300, 380, Color.KHAKI);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        scene.getWidth();
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
