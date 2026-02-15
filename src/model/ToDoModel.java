package model;

import java.util.ArrayList;

public class ToDoModel {

    ArrayList<Task> list = new ArrayList<>();

    public void addTask(String text, String deadline) {
        Task t = new Task(text, deadline);
        list.add(t);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
        }
    }

    public ArrayList<Task> getAll() {
        return list;
    }
}