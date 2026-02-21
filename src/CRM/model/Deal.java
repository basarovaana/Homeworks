package CRM.model;

public class Deal {

    private Client client;
    private Employee employee;
    private double amount;
    private DealStatus status;

    public Deal(Client client, Employee employee, double amount) {
        this.client = client;
        this.employee = employee;
        this.amount = amount;
        this.status = DealStatus.NEW;
    }

    public Client getClient() {
        return client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public double getAmount() {
        return amount;
    }

    public DealStatus getStatus() {
        return status;
    }

    public void setStatus(DealStatus status) {
        this.status = status;
    }

    public double calculateCommission() {
        return amount * employee.getCommissionPercent() / 100.0;
    }

    @Override
    public String toString() {
        return "Клиент: " + client.getName() +
                ", Сотрудник: " + employee.getName() +
                ", Сумма: " + amount +
                ", Статус: " + status +
                ", Комиссия: " + calculateCommission();
    }
}