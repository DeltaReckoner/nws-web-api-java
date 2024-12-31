package nws.models.gridpoint;

/**
 * The properties for a {@link Gridpoint}
 */
public class GridpointProperties {
    /**
     * The units used for a {@link Gridpoint}
     */
    public String units;
    /**
     * The forecast generator name for a {@link Gridpoint}
     */
    public String forecastGenerator;
    /**
     * The time data was created for a {@link Gridpoint} in ISO 8601 format
     */
    public String generatedAt;
    /**
     * The time data was updated for a {@link Gridpoint} in ISO 8601 format
     */
    public String updateTime;
    /**
     * The time interval for a {@link Gridpoint} in ISO 8601 format
     */
    public String validTimes;
    /**
     * The elevation data for a {@link Gridpoint}
     */
    public Elevation elevation;
    /**
     * The data for time periods for a {@link Gridpoint}
     */
    public Period[] periods;
}
