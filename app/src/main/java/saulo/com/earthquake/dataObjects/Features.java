package saulo.com.earthquake.dataObjects;

/**
 * Created by saulo on 30/01/16.
 */
public class Features {
    private String type;
    private Properties properties;
    private Geometry geometry;
    private String id;

    public Features(String type, Properties properties, Geometry geometry, String id) {
        this.type = type;
        this.properties = properties;
        this.geometry = geometry;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
