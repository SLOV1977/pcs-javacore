package ru.netology.javacore;

import java.util.*;

public class Todos {
    String type;
    String task;

    private final List<String> todos = new ArrayList<>();

    public void addTask(String task) {
        todos.add(task);
    }

    public void removeTask(String task) {
        todos.remove(task);
    }

    public String getAllTasks() {
        StringBuilder sb = new StringBuilder();
        String[] array = new String[todos.size()];
        todos.toArray(array);
        Arrays.sort(array);
        for (String task : array) {
            sb.append(task + " ");
        }
        return sb.toString();
    }

    public String getType() {
        return type;
    }

    public String getTask() {
        return task;
    }

}
