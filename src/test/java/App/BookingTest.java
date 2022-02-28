package App;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import testhelper.RandomStub;

import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
public  class BookingTest {

    //Act
    Booking booking =new Booking();
    @BeforeEach
    public void setUp()
    {
        booking.reset();
    }
    //Test case 1
    @Test
    public void checkAvailableSeatsBeforeAnyBooking(){
        //Assert
        assertEquals(15,booking.getAvailableSeats().size());
    }
    //Test case2
    @Test
    public void checkIfOneSeatRequested(){
        //Assert
        assertEquals(Set.of("A1"),booking.getBooked_Seats().keySet());
    }
    //Test case3
    @Test
    public void checkIfTwoSeatRequested(){
        //Assert
        assertEquals(Set.of("A1","A2"),booking.getBooked_Seats().keySet());
    }

  //Test case 4 GIVEN an empty theatre, WHEN the customer requests 3 seats, THEN they will be allocated seat A1, A2, A3
    @Test
    public void checkIfThreeSeatsRequested() {
        // RandomStub will always return 3 in this case
        RandomStub randomNumberOfSeats = new RandomStub(3);
        booking.allocateSeats("SelvaKannan", randomNumberOfSeats.nextInt(3));
        assertEquals(Set.of("A1", "A2", "A3"), booking.getBooked_Seats().keySet());
    }

    //Test case 5 GIVEN a theatre with seats A1, A2 already filled,
    // WHEN the customer requests 2 seats, THEN they will be allocated A3, A4

    @Test
    public void checkIffourSeatsRequested() {
        RandomStub randomNumberOfSeats = new RandomStub(4);
        booking.allocateSeats("SelvaKannan", randomNumberOfSeats.nextInt(4));
        assertEquals(Set.of("A1", "A2", "A3","A4"), booking.getBooked_Seats().keySet());
    }

    // Test case 6 GIVEN a theatre with rows A and B already filled along with seats C1, C2, C3 and C4,
    // WHEN the customer requests 2 seats, THEN the program will halt and the user will see a message for not enough seats

    @Test
    public void checkIfRowsABSeatsRequested() {
        RandomStub randomNumberOfSeats = new RandomStub(4);
        booking.allocateSeats("SelvaKannan", randomNumberOfSeats.nextInt(4));
        assertEquals(Set.of("C1", "C2", "C3","C4"), booking.getBooked_Seats().keySet());
    }
}