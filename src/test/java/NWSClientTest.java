import nws.NWSClient;
import nws.models.gridpoint.Gridpoint;
import nws.models.point.Point;
import nws.models.point.PointProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NWSClientTest {
    private NWSClient nwsClient;

    @BeforeEach
    void setUp() {
        nwsClient = new NWSClient();
    }

    @Test
    void testGetPoint() {
        try
        {
            Point point = nwsClient.getPoint(38.8894, -77.0352);

            Assertions.assertNotNull(point);
            Assertions.assertNotNull(point.id);
            Assertions.assertNotNull(point.geometry);
            Assertions.assertNotNull(point.properties);
        }
        catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void testGetInvalidPoint() {
        try {
            Point point = nwsClient.getPoint(-999.0, -999.0);

            Assertions.assertNotNull(point);
            Assertions.assertNull(point.id);
            Assertions.assertNull(point.geometry);
            Assertions.assertNull(point.properties);
        }
        catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void testGetGridpoint() {
        try {
            Point point = nwsClient.getPoint(38.8894, -77.0352);

            Assertions.assertNotNull(point);
            Assertions.assertNotNull(point.properties);

            PointProperties pointProperties = point.properties;
            Gridpoint gridpoint = nwsClient.getGridpoint(pointProperties.gridId, pointProperties.gridX, pointProperties.gridY);

            Assertions.assertNotNull(gridpoint);
            Assertions.assertNotNull(gridpoint.geometry);
            Assertions.assertNotNull(gridpoint.properties);
        }
        catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void testGetInvalidGridpoint() {
        try {
            Gridpoint gridpoint = nwsClient.getGridpoint("", "-999.0", "999.0");

            Assertions.assertNotNull(gridpoint);
            Assertions.assertNull(gridpoint.geometry);
            Assertions.assertNull(gridpoint.properties);
        }
        catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}
