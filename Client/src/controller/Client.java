package controller;

import model.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.net.InetAddress;
import java.net.Socket;

/**
 * Client
 * @author vasileioskilis
 * @version 04/03/2020
 */

public class Client {
    static User user;
    String host = "localhost";
    int port = 50001;
    private static Client connection;
    private Socket clientSocket;
    private ObjectOutputStream outStream;
    private ObjectInputStream inStream;
    private String message;

    public Client() {

        try {
            clientSocket =new Socket(host,port);
            //clientSocket = new Socket(InetAddress.getLocalHost(), 50000);
            outStream = new ObjectOutputStream(clientSocket.getOutputStream());
            inStream = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Client getInstance() {
        if (connection == null) {
            connection = new Client();
        }
        return connection;
    }

    public void sendObject(Object object){
        try {
            outStream.flush();
            outStream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object readObject(){
        Object object = new Object();
        try {
            object = inStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public void sendMessage(String message){
        try {
            outStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readMessage(){
        try {
            message = (String) inStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

}


