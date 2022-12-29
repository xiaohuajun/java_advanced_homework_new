package com.example.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/22 下午8:53
 * @description IoServer
 */
public class IoServer {


    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(3333);

            new Thread(() -> {
                while (true) {
                    try {

                        //阻塞获取连接
                        Socket accept = serverSocket.accept();

                        new Thread(() -> {

                            try {
                                int len;
                                byte[] bytes = new byte[1024];
                                //字节流
                                InputStream inputStream = accept.getInputStream();

                                inputStream.read();
                                while ((len = inputStream.read(bytes)) != 1) {
                                    System.out.println(new String(bytes, 0, len));
                                }

                            } catch (IOException e) {
                                e.printStackTrace();
                            }


                        }).start();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
