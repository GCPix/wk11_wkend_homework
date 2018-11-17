import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FlightTest {

        private Flight flight;

    @Before
    public void setUp() throws Exception {
        Plane plane = new Plane(PlaneType.AIRBUSA300);
       flight = new Flight(plane,"09:00:00",FlightNo.JA03Y ,Airport.ABERDEEN, Airport.SCHIPOL);
    }

    @Test
    public void canGetDateClass() {
        assertEquals("java.util.Date", flight.getDepartureTime().getClass().getName());
    }

    @Test
    public void canGetTime() {
        //I tried getTime but it gave me it as a literal long. There must be a better way to test this
        int flightHour = flight.getDepartureTime().getHours();
        int flightMinutes = flight.getDepartureTime().getMinutes();
        int flightSeconds = flight.getDepartureTime().getSeconds();
        String flightTime = flightHour + ":" + flightMinutes + ":" + flightSeconds;
        assertEquals("9:0:0", flightTime);
    }

    @Test
    public void flightStartsWithEmptyPassengerArray() {
        assertEquals(0, flight.getpassengerArrayLength());
    }

    @Test
    public void canReturnNoSeatsAvailable() {

        assertEquals(5, flight.getNumberOfSeatsRemaining());
    }

    @Test
    public void canreturnTrueForSeatsRemaining() {
        assertTrue(flight.confirmSeatsRemaining());
    }

    @Test
    public void canAddPassengerToFlight() {
        Passenger passenger = new Passenger("Gillian", 2);
        flight.addPassenger(passenger);
        assertEquals(1, flight.getpassengerArrayLength());
        assertEquals(4, flight.getNumberOfSeatsRemaining());
    }

    @Test
    public void cannotAddPassengerToFlight__Full() {
        Passenger passenger = new Passenger("Gillian", 2);
        for (int i=0; i<=7; i++){ flight.addPassenger(passenger);}
        assertEquals(5, flight.getpassengerArrayLength());
        assertEquals(0, flight.getNumberOfSeatsRemaining());
    }

}
