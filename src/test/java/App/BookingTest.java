package App;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
class BookingTest {

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
}