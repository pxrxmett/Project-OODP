import java.time.LocalDateTime;

public class Booking {
    private int tableNumber;
    private String name;
    private LocalDateTime dateTime;

    public Booking(int tableNumber, String name, LocalDateTime dateTime) {
        this.tableNumber = tableNumber;
        this.name = name;
        this.dateTime = dateTime;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
