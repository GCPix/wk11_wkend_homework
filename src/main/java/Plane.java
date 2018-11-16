public class Plane {
    private PlaneType planeType;

    public Plane(PlaneType planeType) {
        this.planeType = planeType;
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public int getPlaneCapacity(){
        return this.planeType.getCapacity();
    }
    public int getPlaneWeight(){
        return this.planeType.getWeight();
    }
}
