package nws.models.point;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Holds the information related to a latitude and longitude
 */
@JsonIgnoreProperties("@context")
public class Point {
    /**
     * The URL of the request made
     */
    public String id;
    /**
     * Holds geometry information for a {@link Point}
     */
    public PointGeometry geometry;
    /**
     * Holds property information for a {@link Point}
     */
    public PointProperties properties;
}
