package PayMethod.model;

public class PayPalPayment extends PaymentMethod {

    @Override
    public void processPayment(double amount) {

        if (observer != null)
            observer.notifyUser("Оплата PayPal выполнена");
    }
}