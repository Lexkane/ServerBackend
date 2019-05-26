package com.company.client;

import com.company.phone.Phone;

import java.io.*;

public class Client {

    public static void main(String[] args) throws IOException {
        try (Phone phone = new Phone("127.0.0.1", 8000)) {
            System.out.println("Connected to server");
            String request = "Random Requst";
            System.out.println("Request" + request);

            phone.writeLine(request);
            String response = phone.readLine();
            System.out.println("Response:" + response);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
