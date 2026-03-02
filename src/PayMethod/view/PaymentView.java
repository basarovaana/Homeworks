package PayMethod.view;

import java.util.Scanner;

public class PaymentView {

    private Scanner scanner = new Scanner(System.in);

    public String askPaymentType() {
        System.out.println("выберите способ оплаты:");
        System.out.println("карта / paypal / крипто-кошелек");
        return scanner.nextLine();
    }

    public double askAmount() {
        System.out.println("Введите сумму:");
        return scanner.nextDouble();
    }
}