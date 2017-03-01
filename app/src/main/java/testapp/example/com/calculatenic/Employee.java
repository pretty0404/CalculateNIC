package testapp.example.com.calculatenic;

/**
 * Created by Pretty Rehal on 28/02/2017.
 */

public class Employee {
    private String firstName;
    private String lastName;
    private String NI;


    public Employee(String firstName, String lastName, String NI) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.NI = NI;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNI() {
        return NI;
    }

    @Override
    public String toString(){
        return firstName + lastName + "(" + NI + ")";
    }

}
