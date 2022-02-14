package App;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Booking {
    private List<String> seats;
    private final Map<String, String> Booked_Seats = new HashMap<>();


    public Booking() {
        reset();
    }

    public void reset() {

        List<String> seatRows = Stream.of("A", "B", "C")
                .collect(Collectors.toList());
        List<String> seatColumns = Stream.of("1", "2", "3", "4", "5")
                .collect(Collectors.toList());

        seats = seatRows.stream()
                .flatMap(seatRow -> seatColumns.stream()
                        .map(seatColumn -> seatRow + seatColumn))
                .collect(Collectors.toList());
    }


    public void allocateSeats(String bookingName, int numberOfSeats) {
        if (numberOfSeats <=0 || numberOfSeats >3 )
            throw new IllegalArgumentException("Number of Tickets cannot be zero or more than 3 Tickets");

        var seatsAvailable = getAvailableSeats();

        if (numberOfSeats > seatsAvailable.size())
            throw new IllegalArgumentException(numberOfSeats + " Tickets requested. Only " +
                    seatsAvailable.size() + " Tickets are available");

        for (int i = 0; i < numberOfSeats; i++) {
            var seatIndex = seats.indexOf(seatsAvailable.get(i));
            Booked_Seats.put(seatsAvailable.get(i), bookingName);
            seats.set(seatIndex, "");
        }
    }

    public List<String> getAvailableSeats() {
        return seats.stream().filter(seat -> !seat.equals(""))
                .collect(Collectors.toList());
    }

    public Map<String, String> getBooked_Seats() {
        return new TreeMap<>(Booked_Seats);
    }

}
