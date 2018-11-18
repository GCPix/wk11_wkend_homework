import java.util.Random;

public class FlightManager {
    //    calculate how much weight in baggage is booked by passengers for a flight
//    calculate how much overall weight reserved for baggage remains for a flight
//    calculate how much baggage weight should be reserved for each passenger for a flight

    private Flight flight;
    private int seatNumber;

    public FlightManager(Flight flight) {
      this.flight = flight;
    }
    public double getMaxBaggageWeight(){
        return this.flight.getFlightWeight()*0.5;
    }

    public double getPassengerPersonalBaggageWeight(){
        return this.getMaxBaggageWeight()/flight.getFlightCapacity();
    }

    public double getTotalBaggageSpaceUsed(){
        return this.flight.getpassengerArrayLength()*this.getPassengerPersonalBaggageWeight();
    }

    public double getRemainingBaggageSpace(){
        return this.getMaxBaggageWeight()-this.getTotalBaggageSpaceUsed();
    }

    public void updateFlightAndPassengerOnBooking(Passenger passenger, Flight flight){
        flight.addPassenger(passenger);
        passenger.addFlightDetailToPassenger(flight);
        int max = flight.getFlightCapacity();

        while (flight.getSeatsBooked().contains(seatNumber))
        {
            seatNumber = getRandomSeat(1, max);
        }
        passenger.addSeatNumberToPassenger(seatNumber);
        passenger.addFlightDetailToPassenger(flight);
    }

    private static int getRandomSeat(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;//still need to understand how this works
    }


}
