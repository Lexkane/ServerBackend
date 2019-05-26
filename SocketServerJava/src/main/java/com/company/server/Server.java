package com.company.server;

import com.company.phone.Phone;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.stream.IntStream;

public class Server {

    public static String reverse(String test) {

        return IntStream.range(0, test.length())
                .map(i -> test.charAt(test.length() - i - 1))
                .collect(StringBuilder::new, (sb, c) -> sb.append((char) c), StringBuilder::append)
                .toString();
    }


    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8000)) {

            System.out.println("Server started!");
            while (true) {
                Phone phone = new Phone(server);

                new Thread(() -> {
                    String request = phone.readLine();
                    System.out.printf("Response: %s \n", request);
                    String response = Server.reverse(request);

                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    phone.writeLine(response);
                    System.out.printf("Response: %s \n", response);
                    try {
                        phone.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();

            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
