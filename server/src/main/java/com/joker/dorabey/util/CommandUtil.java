package com.joker.dorabey.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Slf4j
public class CommandUtil {

    public static int execute(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            InputStream is = process.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                log.info(line);
            }
            log.info(">>>>> execute command(" + command + ") over");
            return process.waitFor();
        } catch (IOException|InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
    }


    public static InputStream executeWithOutput(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            return process.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
