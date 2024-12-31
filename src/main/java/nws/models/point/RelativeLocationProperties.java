package nws.models.point;

/**
 * The properties for a {@link RelativeLocation}
 */
public class RelativeLocationProperties {
    /**
     * The associated United States city
     */
    public String city;
    /**
     * The associated United States state
     */
    public String state;
    /**
     * The distance of this location
     */
    public Distance distance;
    /**
     *The direction angle of this location
     */
    public Bearing bearing;
}
