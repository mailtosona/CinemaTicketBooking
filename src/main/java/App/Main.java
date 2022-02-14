package App;
import java.util.List;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Booking booking = new Booking();
        var bookingNameList = List.of("Kanna", "Iniya", "Dhanya", "Sona", "Elsa", "Candy");
        int numberOfSeats;
        int bookingNameIndex;
        while (booking.getAvailableSeats().size() > 0) {
            bookingNameIndex = new Random().nextInt(bookingNameList.size());
            numberOfSeats = new Random().nextInt(3) + 1;
            try {
                booking.allocateSeats(bookingNameList.get(bookingNameIndex), numberOfSeats);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        System.out.println("Tickets Booked: " + booking.getBooked_Seats());
    }
}
