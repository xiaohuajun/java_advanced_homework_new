package com.example.io;


import java.net.Socket;
import java.util.Date;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/22 下午8:51
 * @description IOClient
 */
public class IoClient {


    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 3333);
                while(true){

                    socket.getOutputStream().write((new Date() + "hello").getBytes());
                    Thread.sleep(2000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();
    }


}
