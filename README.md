## National Weather Service Java

### A Java API wrapper for the [National Weather Service web API](https://www.weather.gov/documentation/services-web-api).

### Packages Used
- [Jackson](https://github.com/FasterXML/jackson)

### Sample Use
```java
import nws.NWSClient;
import nws.models.gridpoint.Gridpoint;
import nws.models.gridpoint.GridpointProperties;
import nws.models.point.Point;
import nws.models.point.PointProperties;

public class NWSClientTesting {
    public static void main(String[] args) {
        NWSClient nwsClient = new NWSClient();
        try {
            Point point = nwsClient.getPoint(38.8894, -77.0352);
            PointProperties pointProperties = point.properties;

            Gridpoint gridpoint = nwsClient.getGridpoint(pointProperties.gridId, pointProperties.gridX, pointProperties.gridY);
            GridpointProperties gridpointProperties = gridpoint.properties;

            System.out.printf("The wind speed for the first period at %,.4f,%,.4f is %s%n", 38.8894, -77.0352, gridpointProperties.periods[0].windSpeed);
        } catch (Exception e) {
            System.out.printf("Something went wrong: %s%n", e.getMessage());
        }

        // Output: The wind speed for the first period at 38.8894,-77.0352 is 2 mph
        // At the time of running
    }
}
```
