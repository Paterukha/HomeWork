package com.example.HW51.task2;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Warning {
    private Label warningLabel;
    private Pane root;

    public Warning(Pane root){
        this.root = root;

    }


    public Label generateWarning(){
        Label warningLabel = new Label("Звезда не помещается!");
        warningLabel.setLayoutX(Main.WIDTH/6);
        warningLabel.setLayoutY(Main.HEIGHT/3);
        warningLabel.setFont(new Font("Arial", 30));
        return warningLabel;
    }


    public void clearWarnings(){
        if (warningLabel != null){
            root.getChildren().removeAll(warningLabel);
        }
    }
}
