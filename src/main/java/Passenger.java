public class Passenger {
    private String name;
    private int NumberOfBags;
    private Flight flight;
    private int seatNumber;

    public Passenger(String name, int numberOfBags) {
        this.name = name;
        this.NumberOfBags = numberOfBags;
        this.seatNumber = seatNumber;
        this.flight = flight;

    }


    public void addFlightDetailToPassenger(Flight flight) {
        this.flight = flight;

    }

    public void addSeatNumberToPassenger(int seatNumber){
        this.seatNumber = seatNumber;
    }

    public Object getFlightDetail() {
        return this.flight;
    }

    public Object getSeatNumber() {
        return this.seatNumber;
    }
}
