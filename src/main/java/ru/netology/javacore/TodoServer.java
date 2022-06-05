package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {

    private final int port;
    private final Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");

        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            try (
                    Socket socket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
            ) {
                String incomingTask = in.readLine();
                Gson gson = new GsonBuilder().create();
                gson.toJson(incomingTask);
                Todos task = gson.fromJson(incomingTask, Todos.class);

                if (task.getType().equals("ADD")) {
                    todos.addTask(task.getTask());
                } else if (task.getType().equals("REMOVE")) {
                    todos.removeTask(task.getTask());
                }
                out.println(todos.getAllTasks());
            } catch (IOException e) {
                System.out.println("I can't start the server");
                e.printStackTrace();
            }
        }
    }
}
