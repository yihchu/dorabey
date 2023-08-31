package com.joker.dorabey;

import com.joker.dorabey.util.CommandUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Slf4j
public class FXApplication extends Application {

    @Override
    public void start(Stage stage) {

        int port = -1;
        try {
            port = startFront();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (port < 0) {
            log.error(">>>>> Front Start Failed");
            System.exit(-1);
        }

        System.out.println(">>>>> Start to start FXApplication");

        stage.setTitle("Dorabey");

        WebView webView = new WebView();
        webView.getEngine().load("http://localhost:" + port);
        webView.getEngine().setOnAlert(event -> {
            log.info(">>>>> Alert: {}", event.getData());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(event.getData());
            alert.showAndWait();
        });

        VBox vBox = new VBox(webView);
        Scene scene = new Scene(vBox, 960, 600);
        stage.setScene(scene);
        stage.show();
    }


    private int startFront() throws IOException {
        log.info(">>>>> Ready to start front.");
        InputStream in =  CommandUtil.executeWithOutput("sh ./front/run.sh");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = reader.readLine()) != null) {
            log.info(line);
            if (line.contains("http://localhost:")) {
                return Integer.parseInt(StringUtils.substringAfterLast(line, ":"));
            }
        }
        return -1;
    }
}
