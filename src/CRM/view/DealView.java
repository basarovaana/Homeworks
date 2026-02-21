package CRM.view;

import CRM.model.Deal;
import java.util.List;

public class DealView {

    public void printDeals(List<Deal> deals) {

        if (deals.isEmpty()) {
            System.out.println("Список сделок пуст.");
            return;
        }

        for (int i = 0; i < deals.size(); i++) {
            System.out.println( i+1 + "  " + deals.get(i));
        }
    }
}