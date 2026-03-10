package Project10;

import java.util.Scanner;

public class CarRentalSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        OwnerSystem O = new OwnerSystem();
        int startMenu;

        while (true) {
            System.out.print("\n=================================================");
            System.out.print("\n        CAR RENTAL SYSTEM");
            System.out.print("\n=================================================");
            System.out.print("\n1. Owner Login");
            System.out.print("\n2. Customer Login");
            System.out.print("\n3. Register Customer");
            System.out.print("\n4. Exit");
            System.out.print("\n=================================================");
            System.out.print("\nEnter your choice : ");
            startMenu = input.nextInt();

            switch (startMenu) {
                case 1:
                    O.ownerLogin();
                    break;
            
                default:
                    break;
            }
        }
    }
}
