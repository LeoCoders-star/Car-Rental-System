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
            System.out.print("\n2. Display All Cars");
            System.out.print("\n3. Update Car");
            System.out.print("\n4. Delete Car");
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

                case 2:
                    displayAllCars();
                    break;

                case 3:
                    updateCar();
                    break;

                case 4:
                    deleteCar();
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
        String TcarID, carID, carName, TcarType, carType;
        double carPrice;
        boolean isDuplicate = false;

        System.out.print("\n=================================================");
        System.out.print("\n                   ADD NEW CAR");
        System.out.print("\n=================================================");

        while (true) {
            System.out.print("\nEnter Car ID                  : ");
            TcarID = input.nextLine();

            for (int i = 0; i < carCount; i++) {
                if (cars[i].carID.equals(TcarID)) {
                    isDuplicate = true;
                    System.out.print("Error! Car ID already exists!\n\n");
                    break;
                } 
            }

            if (!isDuplicate) {
                carID = TcarID;
                break;
            }
        }

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

        cars[carCount] = new Car(carID, carName, carType, carPrice, true);

        carCount++;
    }

    void displayAllCars() {
        String status;
        int totalCar = 0;

        System.out.print("\n========================================================================================");
        System.out.printf("\n%-4s %-10s %-18s %-12s %-15s %-10s", "No", "Car ID", "Car Name", "Type", "Price/Day", "Status");
        System.out.print("\n========================================================================================");

        for (int i = 0; i < carCount; i++) {
            if (cars[i].isAvailable) {
                status = "Available";
            } else {
                status = "Rented";
            }
            
            System.out.printf("\n%-4s %-10s %-18s %-12s RM%-15.2f %-10s", (i + 1), cars[i].carID, cars[i].carName, cars[i].carType, cars[i].pricePerDay, status);

            totalCar++;
        }

        System.out.print("\n========================================================================================");
        System.out.print("\nTotal Cars : " + totalCar + "\n\n");
    }

    void updateCar() {
        Scanner input = new Scanner(System.in);
        String carID, newCarName, TnewCarType, newCarType = "0";
        double newCarPrice = 0;
        int index = -1;

        System.out.print("\n=================================================");
        System.out.print("\n                   UPDATE CAR");
        System.out.print("\n=================================================");

        System.out.print("\nEnter Car ID to Update : ");
        carID = input.nextLine();

        for (int i = 0; i < carCount; i++) {
            if (cars[i].carID.equals(carID)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.print("\nCar Found");
            System.out.print("\n-------------------------------------------------");

            System.out.print("\nCar ID             : " + cars[index].carID);
            System.out.print("\nCar Name           : " + cars[index].carName);
            System.out.print("\nCar Type           : " + cars[index].carType);
            System.out.printf("\nPrice/Day          : RM%.2f", cars[index].pricePerDay);
            System.out.print("\n-------------------------------------------------");

            System.out.print("\nEnter ' 0 ' if don't want to change the data.\n");

            System.out.print("\nEnter new Car Name : ");
            newCarName = input.nextLine();

            while (true) {
                System.out.print("Enter new Car Type");
                System.out.print("\n( Economy / Sedan / Luxury )  : ");
                TnewCarType = input.nextLine();

                if (TnewCarType.equals("0")) {
                    newCarType = "0";
                    break;
                }

                if (TnewCarType.equalsIgnoreCase("economy")) {
                    newCarType = "Economy";
                    break;
                } else if (TnewCarType.equalsIgnoreCase("sedan")) {
                    newCarType = "Sedan";
                    break;
                } else if (TnewCarType.equalsIgnoreCase("luxury")) {
                    newCarType = "Luxury";
                    break;
                } else {
                    System.out.print("Error! Car type don't have...\n");
                }
            }

            while (true) {
                System.out.print("Enter new Price : ");


                if (input.hasNextDouble()) {
                    newCarPrice = input.nextDouble();
                    input.nextLine();

                    if (newCarPrice < 0) {
                        System.out.print("Error! Price can't be negative...\n");
                    } else {
                        break;
                    }

                } else {
                    System.out.print("Invalid! Only number...\n");
                    input.next();
                }
            }

            if (!newCarName.equals("0")) {
                cars[index].carName = newCarName;
            }

            if (!newCarType.equals("0")) {
                cars[index].carType = newCarType;
            }

            if (newCarPrice != 0) {
                cars[index].pricePerDay = newCarPrice;
            }

            System.out.print("\nCar updated successfully!\n");
        } else {
            System.out.print("\nInvalid! Car Not Found...\n");
        }

    }

    void deleteCar() {
        Scanner input = new Scanner(System.in);
        String carID, carDelete;
        int index = -1;
        boolean isDelete = false;

        System.out.print("\n=================================================");
        System.out.print("\n                   DELETE CAR");
        System.out.print("\n=================================================");

        System.out.print("\nEnter Car ID to delete : ");
        carID = input.nextLine();

        for (int i = 0; i < carCount; i++) {
            if (cars[i].carID.equals(carID)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.print("\nCar Found");
            System.out.print("\nCar ID        : " + cars[index].carID);
            System.out.print("\nCar Name      : " + cars[index].carName);
            System.out.print("\nCar type      : " + cars[index].carType);
            System.out.printf("\nPrice/Day     : RM%.2f", cars[index].pricePerDay);

            System.out.print("\n\nAre you sure to delete this car? (Y/N) : ");
            carDelete = input.nextLine();

            if (carDelete.equalsIgnoreCase("y")) {
                isDelete = true;
            } else {
                isDelete = false;
            }

        } else {
            System.out.print("\nInvalid! Car not found...\n");
        }

        if (isDelete) {
            for (int i = index; i < (carCount - 1); i++) {
                cars[i] = cars[i + 1];
            }

            System.out.print("\nCar deleted successfully!\n");

            carCount--;
        } else {
            System.out.print("\nCar ID [ " + cars[index].carID + "] not delete by ADMIN\n");
        }
    }
}
