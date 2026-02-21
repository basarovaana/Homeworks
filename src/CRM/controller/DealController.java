package CRM.controller;

import CRM.model.*;
import CRM.view.DealView;

public class DealController {

    private DealService service;
    private DealView view;

    public DealController(DealService service, DealView view) {
        this.service = service;
        this.view = view;
    }

    public void createDeal(Client client, Employee employee, double amount) {
        Deal deal = new Deal(client, employee, amount);
        service.addDeal(deal);
    }

    public void showDeals() {
        view.printDeals(service.getDeals());
    }

    public void changeDealStatus(int index, DealStatus status) {
        service.changeStatus(index, status);
    }

    public void sortDeals() {

        service.sortByStatus();
    }

    public void sortAndShowDeals() {
        service.sortByStatus();
        view.printDeals(service.getDeals());
    }
}