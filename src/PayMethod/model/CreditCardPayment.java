package PayMethod.model;

import java.util.Scanner;

public class CreditCardPayment extends PaymentMethod {

    private String cardNumber;

    public CreditCardPayment() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите номер карты:");
            cardNumber = scanner.nextLine();

            if (cardNumber.length() >= 8) break;

            System.out.println("Неверный номер карты!");
        }
    }

    @Override
    public void processPayment(double amount) {

        if (observer != null)
            observer.notifyUser("Оплата картой выполнена");
    }
}