import java.util.ArrayList;
import java.util.Scanner;

class Vehicle {
    private String licensePlate;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String toString() {
        return "Aracın Plakası: " + licensePlate;
    }
}

class ParkingLot {
    private ArrayList<Vehicle> parkedVehicles = new ArrayList<>();

    public void parkVehicle(Vehicle vehicle) {
        parkedVehicles.add(vehicle);
        System.out.println(vehicle.getLicensePlate() + " plakalı araç park edildi.");
    }

    public void removeVehicle(String licensePlate) {
        for (Vehicle vehicle : parkedVehicles) {
            if (vehicle.getLicensePlate().equalsIgnoreCase(licensePlate)) {
                parkedVehicles.remove(vehicle);
                System.out.println(licensePlate + " plakalı araç çıkış yaptı.");
                return;
            }
        }
        System.out.println("Araç bulunamadı.");
    }

    public void displayParkedVehicles() {
        if (parkedVehicles.isEmpty()) {
            System.out.println("Otoparkta araç yok.");
        } else {
            System.out.println("Otoparkta bulunan araçlar:");
            for (Vehicle vehicle : parkedVehicles) {
                System.out.println(vehicle);
            }
        }
    }
}

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot();

        while (true) {
            System.out.println("\n1. Araç Park Et\n2. Araç Çıkar\n3. Parktaki Araçları Listele\n4. Çıkış");
            System.out.print("Seçiminiz: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Araç plakası: ");
                    String licensePlate = scanner.nextLine();
                    parkingLot.parkVehicle(new Vehicle(licensePlate));
                    break;
                case 2:
                    System.out.print("Çıkacak aracın plakası: ");
                    licensePlate = scanner.nextLine();
                    parkingLot.removeVehicle(licensePlate);
                    break;
                case 3:
                    parkingLot.displayParkedVehicles();
                    break;
                case 4:
                    System.out.println("Çıkış yapılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçenek.");
            }
        }
    }
}
