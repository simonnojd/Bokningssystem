public class Booking {
    private boolean isBooked;
    private Person personBookedIt;
    private final String date;
    private final int ID;

    public Booking(boolean isBooked, Person personBookedIt, String date, int ID) {
        this.isBooked = isBooked;
        this.personBookedIt = personBookedIt;
        this.date = date;
        this.ID = ID;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public Person getPersonBookedIt() {
        return personBookedIt;
    }

    public void setPersonBookedIt(Person personBookedIt) {
        this.personBookedIt = personBookedIt;
    }

    public String getDate() {
        return date;
    }

    public int getID() {
        return ID;
    }

}