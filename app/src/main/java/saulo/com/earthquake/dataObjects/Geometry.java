package saulo.com.earthquake.dataObjects;

/**
 * Created by saulo on 30/01/16.
 */
public class Geometry {
    private String type;
    private double coordinates[];
    private String id;

    public Geometry(String type, double[] coordinates, String id) {
        this.type = type;
        this.coordinates = coordinates;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
