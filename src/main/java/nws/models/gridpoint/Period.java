package nws.models.gridpoint;

/**
 * Individual period data as part of a list of periods for a {@link Gridpoint}
 */
public class Period {
    /**
     * The number for a {@link Period}
     */
    public Integer number;
    /**
     * The name for a {@link Period}
     */
    public String name;
    /**
     * The starting time for a {@link Period}
     */
    public String startTime;
    /**
     * The ending time for a {@link Period}
     */
    public String endTime;
    /**
     * If a {@link Period} is happening during before night
     */
    public Boolean isDaytime;
    /**
     * The temperature for a {@link Period}
     */
    public Integer temperature;
    /**
     * The temperature unit for a {@link Period}
     */
    public String temperatureUnit;
    /**
     * The temperature trend for a {@link Period}
     */
    public String temperatureTrend;
    /**
     * The probability of precipitation data for a {@link Period}
     */
    public ProbabilityOfPrecipitation probabilityOfPrecipitation;
    /**
     * The wind speed for a {@link Period}
     */
    public String windSpeed;
    /**
     * The wind direction for a {@link Period}
     */
    public String windDirection;
    /**
     * The icon for a {@link Period}
     */
    public String icon;
    /**
     * The short forecast summary for a {@link Period}
     */
    public String shortForecast;
    /**
     * The detailed forecast summary for a {@link Period}
     */
    public String detailedForecast;
}
