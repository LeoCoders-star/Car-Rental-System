package Project10;

public class Car {
    String carID;
    String carName;
    String carType;
    double pricePerDay;
    boolean isAvailable;

    Car(String i, String n, String t, double p, boolean a) {
        carID = i;
        carName = n;
        carType = t;
        pricePerDay = p;
        isAvailable = a;
    }
}
