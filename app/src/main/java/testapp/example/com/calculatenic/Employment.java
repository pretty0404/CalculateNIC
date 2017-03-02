package testapp.example.com.calculatenic;

/**
 * Created by Pretty Rehal on 01/03/2017.
 */

public class Employment {
    private String employee;
    private String employer;
    private String nature;
    private Double earnings;

    public Employment(String employee, String employer, String nature, Double earnings) {
        this.employee = employee;
        this.employer = employer;
        this.nature = nature;
        this.earnings = earnings;
    }

    public String getEmployee() {
        return employee;
    }

    public String getEmployer() {
        return employer;
    }

    public String getNature() {
        return nature;
    }

    public Double getEarnings() {
        return earnings;
    }

    @Override
    public String toString(){
        return "EMPLOYEE: " + employee + ": \nEMPLOYER: " + employer + "\nNATURE: " + nature + "\nGROSS WEEKLY EARNINGS: " + earnings;
    }
}
