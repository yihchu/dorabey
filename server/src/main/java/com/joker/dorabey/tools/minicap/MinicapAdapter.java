package com.joker.dorabey.tools.minicap;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Objects;

@Slf4j
public class MinicapAdapter extends Thread {

    private final static int THRESHOLD = 1024; // must >= 24

//    private String serial;
    private int port;

    public MinicapAdapter(int port){
//        this.serial = serial;
        this.port = port;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        connectToMinicap();
    }

    private void connectToMinicap(){
        Socket socket = null;
        boolean isFirstFrame = true;
        try {
            socket = new Socket("localhost", this.port);
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[THRESHOLD];
            int hasread = 0, start = 0;
            MinicapFrame frame = null;
            while((hasread = inputStream.read(bytes)) > 0){
                if(isFirstFrame){
                    log.info(new MinicapMeta(bytes).toString());
                    isFirstFrame = false;
                    if (hasread == 24) {
                        continue;
                    }
                    start = 24;
                }
                if (Objects.isNull(frame)) {
                    frame = new MinicapFrame(bytes, start, hasread);
                    continue;
                }
                MinicapFrame nextFrame = frame.append(bytes, hasread);
                frame = frame.isFull() ? nextFrame : frame;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(socket) && !socket.isClosed()) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
