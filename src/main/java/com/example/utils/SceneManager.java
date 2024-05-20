package com.example.utils;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SceneManager {
    private Stage primaryStage;

    private static final int SCENE_WIDTH = 1000;
    private static final int SCENE_HEIGHT = 800;

    public void initStage(Stage stage) {
        if (primaryStage != null) {
            throw new IllegalArgumentException("The Stage has already been initialized");
        }
        primaryStage = stage;
    }

    public Stage getStage() {
        if (primaryStage == null) {
            System.out.println("Exception in SceneManager Stage is null");
        }
        return primaryStage;
    }

    public void loadView(String name) {
        if (primaryStage == null) {
            throw new RuntimeException("Stage Coordinator should be " +
                    "initialized with a Stage before it could be used");
        }
        Platform.runLater(() -> {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                            .getResource(String.format("/com/examples/%s.fxml", name)));
                    Parent root = fxmlLoader.load();
                    Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
                    primaryStage.show();
                    System.out.println("Scene loaded");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        });
    }

    public Parent loadPane(String name) {
        if (primaryStage == null) {
            throw new RuntimeException("Stage Coordinator should be " +
                    "initialized with a Stage before it could be used");
        }
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                        .getResource(String.format("/com/examples/%s.fxml", name)));
                Parent root = fxmlLoader.load();
                return root;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}