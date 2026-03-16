package Project10;

import java.util.Scanner;

public class CustomerSystem {

    void customerRegister() {

        Scanner input = new Scanner(System.in);
        String customerID, customerName, TcustomerName, userName;
        int customerPassword;

        System.out.print("\n=================================================");
        System.out.print("\n               CUSTOMER REGISTER");
        System.out.print("\n=================================================");

        while (true) {
            System.out.print("\nEnter Customer Name : ");
            TcustomerName = input.nextLine();

            if (TcustomerName.matches("[a-zA-Z ]+")) {
                customerName = TcustomerName;
                break;
            } else {
                System.out.print("\nInvalid! Only word...\n");
            }
        }

        System.out.print("Enter Username : ");
        userName = input.nextLine();

        while (true) {
            System.out.print("Enter Password : ");
            if (input.hasNextInt()) {
                customerPassword = input.nextInt();
                break;
            } else {
                System.out.print("\nInvalid! Only numbers...");
            }
        }

        customerID = Utility.generateCarID();

        System.out.print("\nAccount Created Successfully!");
        System.out.print("\nCustomer ID : " + customerID + "\n");

        CarRentalSystem.customers[CarRentalSystem.customerCount] = new Customer(customerID, customerName, userName, customerPassword, false);

        CarRentalSystem.customerCount++;
    }

    void customerLogin() {
        System.out.print("\n=================================================");
        System.out.print("\n                CUSTOMER LOGIN");
        System.out.print("\n=================================================");
        System.out.print("\nEnter Username : ");
        System.out.print("Enter Password : ");
    }
}
