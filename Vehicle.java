public class Vehicle {
    String brand;
    int year;

    public Vehicle() {
    }

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public void honk() {
        System.out.println("Beep beep!");
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Tata", 1996);
        System.out.println(v1);
        TwoWheeler v2 = new TwoWheeler();
        v2.honk();
        ThreeWheeler v3 = new ThreeWheeler();
        v3.honk();
        Aeroplane a = new Aeroplane();
        a.honk();
        a.horn();
    }

    public String toString() {
        return "Brand: " + brand + " Year: " + year;
    }
}