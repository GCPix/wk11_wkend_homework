import java.util.ArrayList;

public class Flight {
    private ArrayList<Passenger> passengerList;
    private Plane plane;
    private String departureTime;
    private FlightNo flightNo;
    private Airport departureAirport;
    private Airport destinationAirport;

    public Flight(Plane plane, String departureTime, FlightNo flightNo, Airport departureAirport, Airport destinationAirport) {
        this.plane = plane;
        this.departureTime = departureTime;
        this.flightNo = flightNo;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.passengerList = new ArrayList<Passenger>();
    }


    public int getpassengerArrayLength() {
        return this.passengerList.size();
    }

    public int getNumberOfSeatsRemaining() {
        return this.plane.getPlaneCapacity()-getpassengerArrayLength();
    }
    public boolean confirmSeatsRemaining(){

       return this.getNumberOfSeatsRemaining()>0;
    }

    public void addPassenger(Passenger passenger) {
        if (confirmSeatsRemaining()) {
            this.passengerList.add(passenger);
        }
    }
}
