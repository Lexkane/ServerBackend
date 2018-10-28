package com.company;
import java.net.DatagramSocket;
import java.net.SocketException;
//Simple server class template
public class Server {
    private int port;
    private DatagramSocket socket;
    private Thread serverRun, manage, receive;
    private boolean running = false;

    public Server(int port) {
        this.port = port;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        serverRun = new Thread(new Runnable() {
            @Override
            public void run() {
                running = true;
                manage();
                receive();
            }

        }, "ServerRun");
    }

    private void manage() {
        manage = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    //TODO MANAGE CLIENTS
                }
            }

        });
        manage.start();
    }

    private void receive() {
        receive = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    //TODO RECIEVE DATA
                }
            }
        });
        receive.start();
    }
}


