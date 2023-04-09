import java.time.LocalDateTime;
import java.util.*;

public class BookingTable {
    private Table[] tables;
    private Map<Integer, Booking> bookings;

    public BookingTable(int numTables) {
        tables = new Table[numTables];
        for (int i = 0; i < numTables; i++) {
            tables[i] = new Table(i + 1);
        }
        bookings = new HashMap<>();
    }

    public void addBooking(int tableNumber, String name, LocalDateTime dateTime) throws IllegalArgumentException {
        if (tableNumber < 1 || tableNumber > tables.length) {
            throw new IllegalArgumentException("Invalid table number");
        }
        if (bookings.containsKey(tableNumber)) {
            throw new IllegalArgumentException("Table is already booked");
        }
        Booking booking = new Booking(tableNumber, name, dateTime);
        bookings.put(tableNumber, booking);
    }

    public void removeBooking(int tableNumber) throws IllegalArgumentException {
        if (!bookings.containsKey(tableNumber)) {
            throw new IllegalArgumentException("Table is not currently booked");
        }
        bookings.remove(tableNumber);
    }

    public void displayBookings() {
        System.out.println("Current Bookings:");
        for (int i = 0; i < tables.length; i++) {
            int tableNumber = tables[i].getTableNumber();
            if (bookings.containsKey(tableNumber)) {
                Booking booking = bookings.get(tableNumber);
                System.out.printf("Table %d is booked by %s for %s%n", tableNumber, booking.getName(), booking.getDateTime());
            } else {
                System.out.printf("Table %d is available%n",
                        tableNumber);
            }
        }
    }
}