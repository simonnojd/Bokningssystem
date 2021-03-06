import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String password;
    private String phoneNumber;
    private List<Booking> bookings = new ArrayList<>();

    public List<Booking> getBookings() {
        return bookings;
    }

    @Override
    public String toString() {
        return "Person{" +
                "bookings=" + bookings +
                '}';
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void removeBooking(int index) {
        bookings.remove(index);
    }

    public Person(String name, String password, String phoneNumber) {
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}