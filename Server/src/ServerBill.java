
import model.Product;
import model.User;
import database.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
//import erciyes.objects.RegisterUser;

/**
 * Simple server class.
 *
 * @author Vasileios Kilis
 *
 */
public class ServerBill {

    int port = 50001;

    public ServerBill() {

        ExecutorService tasks = Executors.newFixedThreadPool(100);

        try (ServerSocket serverSocket = new ServerSocket(port);) {
            System.out.println("Server started");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getInetAddress());
                tasks.execute(new ClientThread(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class ClientThread implements Runnable {

        private Socket socket;
        private ObjectInputStream in;
        private ObjectOutputStream out;
        private String currentUser;
        private Database db;

        private String message=null;

        public ClientThread(Socket socket) {
            this.socket = socket;
            db = new Database();

            try{
                in = new ObjectInputStream(socket.getInputStream());
                out = new ObjectOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String readMessage() {
            try {
                message = (String) in.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return message;
        }

        private void sendMessage(String message) {
            try {
                out.flush();
                out.writeObject(message);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private Object readObject() {
            Object object = null;
            try {
                object = in.readObject();
            } catch (Exception e ) {
                e.printStackTrace();
            }

            return object;
        }

        private void sendObject(Object object) {
            try {
                out.flush();
                out.writeObject(object);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {

            message = readMessage();

            switch (message) {

                case "LogIn": {
                    User user = (User) readObject();
                    try {
                        currentUser = user.getUsername();
                    } catch (NullPointerException ex) {
                        System.out.println("User is not found");
                    }
                    System.out.println(currentUser);
                    try {
                        if (db.logIN(user.getUsername(), user.getPassword())) {
                            sendMessage("Good");
                        } else sendMessage("Fail");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
                break;
                case "Register": {
                   User user = (User) readObject();
                    try {
                        if (db.RegisterNewUser(user.getName(), user.getUsername(),user.getEmail() , user.getPassword(), user.getAddress())) {
                            sendMessage("Good");
                        } else sendMessage("Bad");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }


                }


        }

    }
    public static void main(String[] args) {

        new ServerBill();
    }

}