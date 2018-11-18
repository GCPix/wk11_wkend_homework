import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FlightManagerTest {

    Plane plane;
    FlightManager flightManager;
    Flight flight;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;
    Passenger passenger5;
    @Before
    public void setUp(){
        passenger1 = new Passenger("Gillian", 2);
        passenger2 = new Passenger("Dana", 1);
        passenger3 = new Passenger("peter", 5);
        passenger4 = new Passenger("Natalie", 1);
        passenger5 = new Passenger("Evie", 2);
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight(plane, "09:00:00", FlightNo.JA03Y, Airport.SCHIPOL, Airport.ABERDEEN);
        this.flightManager = new FlightManager(flight);
    }

    @Test
    public void canGetMaxBaggageWeight() {
        assertEquals(25, this.flightManager.getMaxBaggageWeight(), 0.01);
    }

    @Test
    public void canGetPassengerBaggageWeight() {
        assertEquals(5, this.flightManager.getPassengerPersonalBaggageWeight(), 0.01);
    }

    @Test
    public void canGetTotalBaggageUsed() {
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        flight.addPassenger(passenger3);
        assertEquals(15, flightManager.getTotalBaggageSpaceUsed(), 0.01);
    }

    @Test
    public void canGetTotalavailableSpace() {
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        flight.addPassenger(passenger3);
        assertEquals(10, flightManager.getRemainingBaggageSpace(), 0.01);
    }

//    @Test
////    public void canGetRandomSeat() {
////        assertEquals(1, flightManager.getRandomSeat(1, flight.getFlightCapacity()));
////    } // used to check the number changed.

    @Test
    public void canUpdateFlightAndPassengerDetails() {
        flightManager.updateFlightAndPassengerOnBooking(passenger1, flight);
        flightManager.updateFlightAndPassengerOnBooking(passenger2, flight);
        flightManager.updateFlightAndPassengerOnBooking(passenger3, flight);
        flightManager.updateFlightAndPassengerOnBooking(passenger4, flight);
        flightManager.updateFlightAndPassengerOnBooking(passenger5, flight);
        assertEquals("Flight", passenger1.getFlightDetail().getClass().getName());
        assertNotNull(passenger1.getSeatNumber());
//        assertEquals(1, flight.getSeatsBooked());//only used to confirm the random seats were working
    }
}
