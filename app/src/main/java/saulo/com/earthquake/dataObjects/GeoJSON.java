package saulo.com.earthquake.dataObjects;

/**
 * Created by saulo on 30/01/16.
 */
public class GeoJSON {
    private String type;
    private Metadata metadata;
    private Features[] features;
    private double[] bbox;

    public GeoJSON(String type, Metadata metadata, Features[] features, double[] bbox) {
        this.type = type;
        this.metadata = metadata;
        this.features = features;
        this.bbox = bbox;
    }

    public double[] getBbox() {
        return bbox;
    }

    public void setBbox(double[] bbox) {
        this.bbox = bbox;
    }

    public Features[] getFeatures() {
        return features;
    }

    public void setFeatures(Features[] features) {
        this.features = features;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
