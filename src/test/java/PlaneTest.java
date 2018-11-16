import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {
        private Plane plane;
    @Before
    public void setUp() throws Exception {
        plane = new Plane(PlaneType.BOEING747);

    }

    @Test
    public void canGetCapacity() {
        int result = plane.getPlaneCapacity();
        assertEquals(5, result);
    }

    @Test
    public void canGetWeight() {
        int result = plane.getPlaneWeight();
        assertEquals(50, result);
    }
}
