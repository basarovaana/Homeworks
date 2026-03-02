package PayMethod.model;

import java.util.Scanner;

public class CryptoPayment extends PaymentMethod {

    private String wallet;

    public CryptoPayment() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите номер кошелька:");
            wallet = scanner.nextLine();

            if (wallet.length() >= 10) break;

            System.out.println("Неверный номер кошелька!");
        }
    }

    @Override
    public void processPayment(double amount) {

        if (observer != null)
            observer.notifyUser("Оплата криптой выполнена");
    }
}