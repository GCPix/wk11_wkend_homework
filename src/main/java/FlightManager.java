public class FlightManager {
    //    calculate how much weight in baggage is booked by passengers for a flight
//    calculate how much overall weight reserved for baggage remains for a flight
//    calculate how much baggage weight should be reserved for each passenger for a flight

    private Flight flight;

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


}
