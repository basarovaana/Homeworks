package CRM.model;

public class Employee {

    private String name;
    private double commissionPercent;

    public Employee(String name, double commissionPercent) {
        this.name = name;
        this.commissionPercent = commissionPercent;
    }

    public String getName() {
        return name;
    }

    public double getCommissionPercent() {
        return commissionPercent;
    }
}