import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Reservation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.print("Enter number of tables: ");
        int numTables = scanner.nextInt();
        BookingTable bookingTable = new BookingTable(numTables);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add booking");
            System.out.println("2. Remove booking");
            System.out.println("3. Display bookings");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter table number: ");
                    int tableNumber = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter date and time (yyyy-MM-dd HH:mm): ");
                    LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine(), formatter);

                    try {
                        bookingTable.addBooking(tableNumber, name, dateTime);
                        System.out.println("Booking added successfully");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter table number: ");
                    int tableNumberToRemove = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        bookingTable.removeBooking(tableNumberToRemove);
                        System.out.println("Booking removed successfully");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    bookingTable.displayBookings();
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
