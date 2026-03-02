package PayMethod.model;

import PayMethod.observer.Notifiable;

public abstract class PaymentMethod {

    protected Notifiable observer;

    public void setObserver(Notifiable observer) {
        this.observer = observer;
    }

    public abstract void processPayment(double amount);
}