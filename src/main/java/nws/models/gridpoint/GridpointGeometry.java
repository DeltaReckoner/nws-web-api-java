package nws.models.gridpoint;

import java.util.List;

/**
 * The geometry data for a {@link Gridpoint}
 */
public class GridpointGeometry {
    /**
     * The coordinates for a {@link Gridpoint} in the form of List[List[X,Y]]
     */
    public List<List<Double[]>> coordinates;
}