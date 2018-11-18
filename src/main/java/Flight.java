import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Flight {
    private ArrayList<Passenger> passengerList;
    private Plane plane;
    private Date departureTime;
    private FlightNo flightNo;
    private Airport departureAirport;
    private Airport destinationAirport;
    private String stringTime;
    private ArrayList<Integer> seatsBooked;


    String timeFormat = "HH:mm:ss";
    SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);

    public Flight(Plane plane, String stringTime, FlightNo flightNo, Airport departureAirport,
                  Airport destinationAirport) {
        this.plane = plane;
        try {
            this.departureTime = sdf.parse(stringTime);;
        }catch(Exception e) {
            e.printStackTrace();
        }
        this.flightNo = flightNo;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.passengerList = new ArrayList<Passenger>();
        this.seatsBooked = new ArrayList<Integer>();
    }
//I have read everything on the parseexception and I understand it happens and that is why we use try catch but why
// does it work with the catch.  isnt that just catching the error which would still still lead to the test not
// working only with a different error? I have confirmed in the tests that I am seeing what I expect just don't
// understand how!

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

    public int getFlightWeight() {
        return this.plane.getPlaneWeight();
    }

    public int getFlightCapacity() {
        return this.plane.getPlaneCapacity();
    }

    public Date getDepartureTime() {
        return this.departureTime;
    }
    public ArrayList<Integer> getSeatsBooked(){
        return this.seatsBooked;
    }
}
