package PayMethod;

import PayMethod.view.PaymentView;
import PayMethod.controller.PaymentController;

public class Main {

    public static void main(String[] args) {

        PaymentView view = new PaymentView();
        PaymentController controller =
                new PaymentController(view);

        controller.startPayment();
    }
}