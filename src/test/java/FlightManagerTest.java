import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    Plane plane;
    FlightManager flightManager;
    Flight flight;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    @Before
    public void setUp(){
        passenger1 = new Passenger("Gillian", 2);
        passenger2 = new Passenger("Dana", 1);
        passenger3 = new Passenger("peter", 5);
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight(plane, "9am", FlightNo.JA03Y, Airport.SCHIPOL, Airport.ABERDEEN);
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
}
