package PayMethod.observer;

public class TransactionNotifier implements Notifiable {

    @Override
    public void notifyUser(String message) {
        System.out.println("уведомление: " + message);
    }
}