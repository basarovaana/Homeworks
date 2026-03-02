package PayMethod.controller;

import PayMethod.model.*;
import PayMethod.observer.TransactionNotifier;
import PayMethod.view.PaymentView;

public class PaymentController {

    private PaymentView view;

    public PaymentController(PaymentView view) {
        this.view = view;
    }

    public void startPayment() {

        while (true) {

            String type = view.askPaymentType();

            PaymentMethod payment =
                    PaymentFactory.create(type);

            if (payment == null) {
                System.out.println("Неверный способ оплаты!");
                continue;
            }

            double amount;

            while (true) {
                amount = view.askAmount();

                if (amount >= 0)
                    break;

                System.out.println("Сумма не может быть отрицательной!");
            }

            payment.setObserver(new TransactionNotifier());
            payment.processPayment(amount);

            break;
        }
    }
}