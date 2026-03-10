package Project10;

import java.util.Scanner;

public class OwnerSystem {  
    Car[] cars = new Car[100];
    int carCount = 0;

    void ownerLogin() {
        Scanner input = new Scanner(System.in);
        String userName = "Leos2007", inputUserName;
        int password = 2007, inputPassword;
        boolean isSuccessful = false;

        System.out.print("\n=================================================");
        System.out.print("\n                  OWNER LOGIN");
        System.out.print("\n=================================================");

        System.out.print("\nEnter Username : ");
        inputUserName = input.nextLine(); 

        while (true) {
            System.out.print("Enter Password : ");
            
            if (input.hasNextInt()) {
                inputPassword = input.nextInt();
                break;
            } else {
                System.out.print("Invalid! Only numbers...\n\n");
                input.next();
            }
        }


        if (inputUserName.equals(userName)) {
            if (inputPassword == password) {
                isSuccessful = true;
            }
        } else {
            isSuccessful = false;
        }

        if (!isSuccessful) {
            System.out.print("\nInvalid Username or Password!\n");
        } else {
            System.out.print("\nLogin Successful!\n");
            menu();
        }
    }

    void menu() {
        Scanner input = new Scanner(System.in);
        int startOwner;
        while (true) {
            System.out.print("\n=================================================");
            System.out.print("\n                  OWNER MENU");
            System.out.print("\n=================================================");
            System.out.print("\n1. Add New Car");
            System.err.print("\n8. Logout");
            System.out.print("\n=================================================");

            while (true) {
                System.out.print("\nEnter your choice : ");
                if (input.hasNextInt()) {
                    startOwner = input.nextInt();
                    break;
                } else {
                    System.out.print("Error! Choice between 1 ~ 8 only...\n");
                    input.next();
                }
            }

            switch (startOwner) {
                case 1:
                    addNewCar();
                    break;
                case 8:
                    System.out.print("\nLogging out...");
                    System.out.print("\nReturning to Main Menu...\n");
                    return;
            
                default:
                    System.out.print("\nInvalid Choice!\n");
                    break;
            }
        }
    }

    void addNewCar() {
        Scanner input = new Scanner(System.in);
        String carID, carName, TcarType, carType;
        double carPrice;

        System.out.print("\n=================================================");
        System.out.print("\n                   ADD NEW CAR");
        System.out.print("\n=================================================");

        System.out.print("\nEnter Car ID                  : ");
        carID = input.nextLine();

        System.out.print("Enter Car Name                : ");
        carName = input.nextLine();

        while (true) {
            System.out.print("Enter Car Type                 ");
            System.out.print("\n( Economy / Sedan / Luxury )  : ");
            TcarType = input.nextLine();

            if (TcarType.matches("[a-zA-Z ]+")) {
                if (TcarType.equalsIgnoreCase("economy")) {
                    carType = "Economy";
                    break;
                } else if (TcarType.equalsIgnoreCase("sedan")) {
                    carType = "Sedan";
                    break;
                } else if (TcarType.equalsIgnoreCase("luxury")) {
                    carType = "Luxury";
                    break;
                } else {
                    System.out.print("Error! Car type don't have...\n\n");
                }
            } else {
                System.out.print("Invalid! Only words...\n\n");
            }
        }

        while (true) {
            System.out.print("Enter Price Per Day           : RM ");
            
            if (input.hasNextDouble()) {
                carPrice = input.nextDouble();

                if (carPrice < 0) {
                    System.out.print("Error! Price can't below Zero\n\n");
                } else {
                    break;
                }
            } else {
                System.out.print("Invalid! Only numbers...\n\n");
                input.next();
            }
        }

        System.out.print("\nCar added successfully!\n");

        cars[carCount] = new Car(carID, carName, carType, carPrice, false);

        carCount++;
    }
}
