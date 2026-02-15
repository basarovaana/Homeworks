package control;

import model.Task;
import model.ToDoModel;
import view.ToDoView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.ArrayList;

public class ToDoController {

    ToDoModel model = new ToDoModel();
    ToDoView view = new ToDoView();
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public void start() {

        int choice = -1;

        while (choice != 0) {

            view.showMenu();

            while (true) {
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    sc.nextLine();
                    if (choice >= 0 && choice <= 7) {
                        break;
                    } else {
                        System.out.println("Неверный номер команды");
                        view.showMenu();
                    }
                } else {
                    System.out.println("Введите число");
                    sc.nextLine();
                    view.showMenu();
                }
            }

            if (choice == 1) {
                view.showTasks(model.getAll());
            }

            if (choice == 2) {
                System.out.print("Введите описание задачи: ");
                String text = sc.nextLine();

                String deadline;
                while (true) {
                    System.out.print("Введите дедлайн (dd.MM.yyyy): ");
                    deadline = sc.nextLine();
                    if (isValidDate(deadline)) {
                        break;
                    } else {
                        System.out.println("Неверный формат даты");
                    }
                }

                model.addTask(text, deadline);
                System.out.println("[Уведомление] Добавлена задача: " + text);
            }

            if (choice == 3) {
                int index = getValidTaskIndex();
                if (index != -1) {
                    model.removeTask(index);
                }
            }

            if (choice == 4) {
                int index = getValidTaskIndex();
                if (index != -1) {
                    model.getAll().get(index).setDone(true);
                }
            }

            if (choice == 5) {
                ArrayList<Task> tasks = model.getAll();
                for (int i = 0; i < tasks.size(); i++) {
                    if (!tasks.get(i).isDone()) {
                        System.out.println((i + 1) + ". [ ] "
                                + tasks.get(i).getText()
                                + " (до: " + tasks.get(i).getDeadline() + ")");
                    }
                }
            }

            if (choice == 6) {
                ArrayList<Task> tasks = model.getAll();
                for (int i = 0; i < tasks.size(); i++) {
                    if (tasks.get(i).isDone()) {
                        System.out.println((i + 1) + ". [x] "
                                + tasks.get(i).getText()
                                + " (до: " + tasks.get(i).getDeadline() + ")");
                    }
                }
            }

            if (choice == 7) {
                int index = getValidTaskIndex();
                if (index != -1) {
                    System.out.print("Введите новый текст: ");
                    String newText = sc.nextLine();
                    model.getAll().get(index).setText(newText);
                    System.out.println("Задача изменена");
                }
            }
        }
    }

    private int getValidTaskIndex() {

        ArrayList<Task> tasks = model.getAll();

        if (tasks.size() == 0) {
            System.out.println("Список пуст");
            return -1;
        }

        while (true) {
            System.out.print("Введите номер задачи: ");

            if (sc.hasNextInt()) {
                int index = sc.nextInt();
                sc.nextLine();

                if (index >= 1 && index <= tasks.size()) {
                    return index - 1;
                } else {
                    System.out.println("Такой задачи нет");
                }
            } else {
                System.out.println("Введите число");
                sc.nextLine();
            }
        }
    }

    private boolean isValidDate(String dateStr) {
        try {
            LocalDate.parse(dateStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}