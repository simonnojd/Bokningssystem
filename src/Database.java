import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {

    // Creating all the objects and important variables

    private final List<Person> personList = new ArrayList<>();
    private final List<Booking> bookings = new ArrayList<>();

    Person person1 = new Person("Simon", "123", "0760659495");
    Person person2 = new Person("Elias", "123", "0760659495");
    Person person3 = new Person("Amir", "123", "0760659495");
    Person person4 = new Person("Sofia", "123", "0760659495");

    Booking booking1 = new Booking(true, person1, "03/05", 1);
    Booking booking2 = new Booking(true, person1, "03/07", 2);
    Booking booking3 = new Booking(true, person3, "03/09", 3);
    Booking booking4 = new Booking(false, null, "03/10", 4);
    Booking booking5 = new Booking(false, null, "03/12", 5);
    Booking booking6 = new Booking(false, null, "03/14", 6);

    Scanner scanner = new Scanner(System.in);
    String username;
    String password;


    public Database() {
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        bookings.add(booking1);
        bookings.add(booking2);
        bookings.add(booking3);
        bookings.add(booking4);
        bookings.add(booking5);
        bookings.add(booking6);

        person1.addBooking(booking1);
        person1.addBooking(booking2);

        boolean loop = true;
        System.out.println("Username: ");
        username = scanner.next();
        System.out.println("Password: ");
        password = scanner.next();

        Boolean loggedIn = checkLogin();

        while (loop) {

            if (loggedIn) {
                Person user = getPersonThatIsLoggedIn();
                System.out.println("\n\n\n\n\nWelcome, " + user.getName());
                System.out.println("\n\n1. See all bookings\n2. See your active bookings\n3. Quit");
                switch (scanner.nextInt()) {
                    case 1 -> {
                        printAllBookings();
                        System.out.println("\nDo you want to book a date? Yes or No");
                        String desicion = scanner.next();
                        if ("Yes".equalsIgnoreCase(desicion)) {
                            System.out.println("Type the ID that you want to book");
                            int choice = scanner.nextInt();
                            bookDate(user, bookings.get(choice - 1));
                            scanner.nextLine();
                        } else if ("No".equalsIgnoreCase(desicion)) {
                            System.out.println("Type the ID that you want to unbook");
                            int choice = scanner.nextInt();
                            unBookDate(user, bookings.get(choice - 1), choice);
                        }
                    }
                    case 2 -> {
                        printUserBookings(user);
                        try {
                            Thread.sleep(3000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                    case 3 -> {
                        System.out.println("Shutting down...");
                        System.exit(0);
                    }
                }
            } else {
                System.out.println("That is wrong data");
                loop = false;
            }
        }
    }

    public Boolean checkLogin() {
        for (Person p : personList) {
            if (p.getName().equalsIgnoreCase(username) && p.getPassword().equalsIgnoreCase(password)) {
                return true;
            }
        }
        return false;
    }

    public Person getPersonThatIsLoggedIn() {
        for (Person p : personList) {
            if (p.getName().equalsIgnoreCase(username) && p.getPassword().equalsIgnoreCase(password)) {
                return p;
            }
        }
        return null;
    }

    public void printAllBookings() {
        for (Booking b : bookings) {
            System.out.println("ID: " + b.getID() + " Date: " + b.getDate() + " is booked: " + b.isBooked());
        }
    }

    public void printUserBookings(Person person) {
        System.out.println("Your bookings");
        List<Booking> testList = person.getBookings();

        for (Booking booking : testList) {
            System.out.println("Date: " + booking.getDate());
        }
    }

    public void bookDate(Person person, Booking booking) {
        if (!booking.isBooked()) {
            person.addBooking(booking);
            booking.setBooked(true);
            booking.setPersonBookedIt(person);
            System.out.println("The booking was added.\n\n");
            try {
                Thread.sleep(2500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("That date is already booked.");
            try {
                Thread.sleep(2500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void unBookDate(Person person, Booking booking, int index) {
        if (booking.isBooked() && booking.getPersonBookedIt().equals(person)) {
            person.removeBooking(index - 1);
            booking.setBooked(false);
            booking.setPersonBookedIt(null);
            System.out.println("The unbooking succeded");
            try {
                Thread.sleep(2500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("That date isn't booked or it belongs to another person.");
        }
    }

}