package CRM;

import CRM.controller.DealController;
import CRM.model.*;
import CRM.view.DealView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Notifiable observer = message ->
                System.out.println("Уведомление: " + message);

        DealService service = new DealService(observer);
        DealView view = new DealView();
        DealController controller = new DealController(service, view);

        while (true) {

            System.out.println("\nМЕНЮ:");
            System.out.println("1 - Добавить сделку");
            System.out.println("2 - Показать все сделки");
            System.out.println("3 - Изменить статус сделки");
            System.out.println("4 - Сортировать по статусу");
            System.out.println("0 - Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                break;
            }

            switch (choice) {

                case 1:
                    System.out.print("Имя клиента: ");
                    String clientName = scanner.nextLine();

                    System.out.print("Имя сотрудника: ");
                    String employeeName = scanner.nextLine();

                    System.out.print("Процент комиссии: ");
                    double percent = scanner.nextDouble();

                    System.out.print("Сумма сделки: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    Client client = new Client(clientName);
                    Employee employee = new Employee(employeeName, percent);

                    controller.createDeal(client, employee, amount);
                    break;

                case 2:
                    controller.showDeals();
                    break;

                case 3:
                    controller.showDeals();
                    System.out.print("Введите номер сделки: ");
                    int index = scanner.nextInt();

                    System.out.println("Выберите статус:");
                    System.out.println("1 - NEW");
                    System.out.println("2 - IN_PROGRESS");
                    System.out.println("3 - CLOSED");

                    int statusChoice = scanner.nextInt();
                    scanner.nextLine();

                    DealStatus status = null;

                    if (statusChoice == 1) status = DealStatus.NEW;
                    if (statusChoice == 2) status = DealStatus.IN_PROGRESS;
                    if (statusChoice == 3) status = DealStatus.CLOSED;

                    controller.changeDealStatus(index, status);
                    break;

                case 4:
                    System.out.println("\nСделки после сортировки по статусу:");
                    controller.sortAndShowDeals();
                    break;

                default:
                    System.out.println("Неверный выбор.");
            }
        }

        scanner.close();
    }
}