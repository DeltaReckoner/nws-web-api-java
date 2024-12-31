package nws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import nws.models.gridpoint.Gridpoint;
import nws.models.point.Point;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * The Java client to make requests to the National Weather Service's web API.
 */
public class NWSClient {
    private HttpClient httpClient;
    private final String BASE_URL = "https://api.weather.gov";
    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Default constructor
     */
    public NWSClient() {
        httpClient = HttpClient.newBuilder().build();
    }

    /**
     * Gets point information for a given latitude and longitude.
     * @param latitude X value
     * @param longitude Y value
     * @return {@link Point}
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws JsonProcessingException
     */
    public Point getPoint(Double latitude, Double longitude) throws ExecutionException, InterruptedException, JsonProcessingException {
        String requestUrl = BASE_URL + "/points/" +  latitude + "," + longitude;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl))
                .header("User-Agent", "NWS-Java")
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        String responseJson = response.thenApply(HttpResponse::body).get();

        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return OBJECT_MAPPER.readValue(responseJson, Point.class);
    }

    /**
     * Gets gridpoint information based on the provided point ID, X and Y coordinates.
     * @param gridId The points grid ID
     * @param gridX The points grid X coordinate
     * @param gridY The points grid Y coordinate
     * @return {@link Gridpoint}
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws JsonProcessingException If there is an error processing the Json data that is retrieved from the API
     */
    public Gridpoint getGridpoint(String gridId, String gridX, String gridY) throws ExecutionException, InterruptedException, JsonProcessingException {
        String requestUrl = BASE_URL + "/gridpoints/" +  gridId + "/" + gridX + "," + gridY + "/forecast";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl))
                .header("User-Agent", "NWS-Java")
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        String responseJson = response.thenApply(HttpResponse::body).get();

        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return OBJECT_MAPPER.readValue(responseJson, Gridpoint.class);
    }
}
