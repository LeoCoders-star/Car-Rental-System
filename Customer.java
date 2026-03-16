package Project10;

public class Customer {
    String customerID;
    String customerName;
    String customerUserName;
    int customerPassword;
    boolean VIPstatus = false;
    

    Customer(String i, String c, String u, int p, Boolean v) {
        customerID = i;
        customerName = c;
        customerUserName = u;
        customerPassword = p;
        VIPstatus = v;
    }
}
