package Project10;

import java.util.Scanner;

public class OwnerSystem {
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

        System.out.print("Enter Password : ");
        inputPassword = input.nextInt();

        if (inputUserName == userName) {
            if (inputPassword == password) {
                isSuccessful = true;
            } else {
                isSuccessful = false;
            }
        } else {
            isSuccessful = false;
        }

        System.out.print("Leos2007 = " + inputUserName);
        System.out.print("\n2007 = " + inputPassword);
        System.out.print("\n" + isSuccessful);

        if (!isSuccessful) {
            System.out.print("\nInvalid Username or Password!");
        } else {
            System.out.print("\nLogin Successful!");
        }
    }
}
