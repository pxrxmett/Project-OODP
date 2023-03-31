

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingTable {
    private List<Table> tables;
    private List<Reservation> reservations;

    public BookingTable() {
        this.tables = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public void addTable(Table table) {
        this.tables.add(table);
    }

    public void removeTable(Table table) {
        this.tables.remove(table);
    }

    public Table getTable(int tableNumber) {
        for (Table table : this.tables) {
            if (table.getTableNumber() == tableNumber) {
                return table;
            }
        }
        return null;
    }

    public void makeReservation(Reservation reservation) {
        this.reservations.add(reservation);
        Table table = findAvailableTable(reservation.getPartySize());
        if (table != null) {
            table.setAvailable(false);
        }
    }

    public void cancelReservation(Reservation reservation) {
        this.reservations.remove(reservation);
        Table table = getTableForReservation(reservation);
        if (table != null) {
            table.setAvailable(true);
        }
    }

    private Table findAvailableTable(int partySize) {
        for (Table table : this.tables) {
            if (table.isAvailable() && table.getCapacity() >= partySize) {
                return table;
            }
        }
        return null;
    }

    private Table getTableForReservation(Reservation reservation) {
        for (Table table : this.tables) {
            if (!table.isAvailable() && reservation.getPartySize() <= table.getCapacity()) {
                Reservation existingReservation = getReservationForTable(table);
                if (existingReservation != null && existingReservation.getName().equals(reservation.getName())) {
                    return table;
                }
            }
        }
        return null;
    }

    private Reservation getReservationForTable(Table table) {
        for (Reservation reservation : this.reservations) {
            if (reservation.getDate().equals(table.getDate())) {
                return reservation;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BookingTable bookingTable = new BookingTable();

        Table table1 = new Table(1, 4, true);
        Table table2 = new Table(2, 4, true);
        Table table3 = new Table(3, 6, true);
        Table table4 = new Table(4, 6, true);

        bookingTable.addTable(table1);
        bookingTable.addTable(table2);
        bookingTable.addTable(table3);
        bookingTable.addTable(table4);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Welcome to BookingTable!");
                System.out.println("1. Make a reservation");
                System.out.println("2. Cancel a reservation");
                System.out.println("3. View available tables");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter name: ");
                        String name = scanner.next();
                        System.out.println("Enter date (yyyy-MM-dd): ");
                        String dateString = scanner.next();
                        Date date = Date.valueOf(dateString);
                        System.out.println("Enter party size: ");
                        int partySize = scanner.nextInt();

                        Reservation reservation = new Reservation(name, date, partySize);
                        bookingTable.makeReservation(reservation);

                        Table table = bookingTable.getTableForReservation(reservation);
                        if (table != null) {
                            System.out.println("Reservation made for table " + table.getTableNumber());
                        } else {
                            System.out.println("Sorry, no tables available for that party size");
                        }
                          
                    break;
                    case 2:
                    System.out.println("Enter name: ");
                    String cancelName = scanner.next();
                    System.out.println("Enter date (yyyy-MM-dd): ");
                    String cancelDateString = scanner.next();
                    Date cancelDate = Date.valueOf(cancelDateString);
                    System.out.println("Enter party size: ");
                    int cancelPartySize = scanner.nextInt();

                    Reservation cancelReservation = new Reservation(cancelName, cancelDate, cancelPartySize);
                    bookingTable.cancelReservation(cancelReservation);

                    System.out.println("Reservation canceled");
                    break;
                case 3:
                    System.out.println("Available tables:");
                    for (Table availableTable : bookingTable.getAvailableTables()) {
                        System.out.println("Table " + availableTable.getTableNumber() + " (capacity " + availableTable.getCapacity() + ")");
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            }
        }
    }

    public List<Table> getAvailableTables() {
        List<Table> availableTables = new ArrayList<>();
        for (Table table : this.tables) {
            if (table.isAvailable()) {
                availableTables.add(table);
            }
        }
        return availableTables;
    }
}
