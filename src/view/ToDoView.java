package view;

import model.Task;

import java.util.ArrayList;

public class ToDoView {

    public void showMenu() {
        System.out.println("=== TO-DO LIST ===");
        System.out.println("1. Показать все задачи");
        System.out.println("2. Добавить задачу");
        System.out.println("3. Удалить задачу");
        System.out.println("4. Отметить как выполненную");
        System.out.println("5. Показать активные задачи");
        System.out.println("6. Показать выполненные задачи");
        System.out.println("7. Редактировать текст задачи");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
    }

    public void showTasks(ArrayList<Task> tasks) {
        if (tasks.size() == 0) {
            System.out.println("Список пуст");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            String status = String.valueOf(t.isDone());
            System.out.println((i + 1) + ". "
                    + t.getText() + " — " + status
                    + " (до: " + t.getDeadline() + ")");
        }
    }
}