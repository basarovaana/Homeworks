package CRM.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DealService {

    private List<Deal> deals = new ArrayList<>();
    private Notifiable observer;

    public DealService(Notifiable observer) {
        this.observer = observer;
    }

    public void addDeal(Deal deal) {
        deals.add(deal);
        observer.notify("Добавлена новая сделка");
    }

    public List<Deal> getDeals() {
        return deals;
    }

    public void changeStatus(int index, DealStatus status) {
        if (index >= 0 && index < deals.size()) {
            deals.get(index).setStatus(status);
            observer.notify("Статус сделки изменён");
        } else {
            System.out.println("Неверный номер сделки");
        }
    }

    public void sortByStatus() {
        deals.sort(Comparator.comparing(Deal::getStatus));
    }
}