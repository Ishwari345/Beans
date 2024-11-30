import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Customer implements Serializable {
    private int id;
    private double balance;
    private String firstName;
    private String lastName;

    // No-argument constructor
    public Customer() {}

    // Parameterized constructor
    public Customer(int id, double balance, String firstName, String lastName) {
        this.id = id;
        this.balance = balance;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{ID=" + id +
                ", Balance=" + balance +
                ", FirstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                '}';
    }
}

public class Assignment {
    public static void main(String[] args) {
        // Create a list of customers
        List<Customer> customers = new ArrayList<>();

        // Add customers to the list
        customers.add(new Customer(3, 500.0, "Hitha", "Virat"));
        customers.add(new Customer(1, 1500.0, "Sinchana", "KLR"));
        customers.add(new Customer(2, 1000.0, "Inchara", "Appu"));
        customers.add(new Customer(4, 200.0, "Piddu", "Prabhas"));

        System.out.println("Before Sorting:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        // Sort customers using a custom comparator
        Collections.sort(customers, new Comparator<Customer>() {
            @Override
            public int compare(Customer c1, Customer c2) {
                // Compare by First Name
                int firstNameComparison = c1.getFirstName().compareTo(c2.getFirstName());
                if (firstNameComparison != 0) return firstNameComparison;

                // Compare by Last Name
                int lastNameComparison = c1.getLastName().compareTo(c2.getLastName());
                if (lastNameComparison != 0) return lastNameComparison;

                // Compare by ID
                int idComparison = Integer.compare(c1.getId(), c2.getId());
                if (idComparison != 0) return idComparison;

                // Compare by Balance
                return Double.compare(c1.getBalance(), c2.getBalance());
            }
        });

        System.out.println("\nAfter Sorting:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}