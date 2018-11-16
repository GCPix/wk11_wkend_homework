public enum PlaneType {

    BOEING747(5, 50),
    BOEING767(5, 50),
    BOEING777(5, 50),
    BOEING787(5, 50),
    AIRBUSA300(5, 50),
    AIRBUSA330(5, 50),
    AIRBUSA340(5, 50),
    AIRBUSA350(5, 50),
    AIRBUSA380(5, 50),
    LOCKHEEDL1001(5, 50),
    TRISTAR(5, 50);

    private final int capacity;
    private final int weight;

    PlaneType(int capacity, int weight) {
        this.capacity = capacity;
        this.weight = weight;
    }

    public int getCapacity() {
        return capacity;
    }
    public int getWeight() {
        return weight;
    }

}
