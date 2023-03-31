public class Table {
    private int tableNumber;
    private int capacity;
    private boolean available;

    public Table(int tableNumber, int capacity, boolean available) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.available = available;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Object getDate() {
        return null;
    }
}
