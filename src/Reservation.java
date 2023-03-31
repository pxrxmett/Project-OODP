

import java.util.Date;

public class Reservation {
    private String name;
    private Date date;
    private int partySize;

    public Reservation(String name, Date date, int partySize) {
        this.name = name;
        this.date = date;
        this.partySize = partySize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPartySize() {
        return partySize;
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }
}
