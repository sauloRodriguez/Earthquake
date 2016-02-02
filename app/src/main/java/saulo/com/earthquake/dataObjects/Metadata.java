package saulo.com.earthquake.dataObjects;

/**
 * Created by saulo on 30/01/16.
 */
public class Metadata {
    private long generated;
    private String url;
    private String title;
    private String api;
    private int count;
    private int status;

    public Metadata(long generated, String url, String title, String api, int count, int status) {
        this.generated = generated;
        this.url = url;
        this.title = title;
        this.api = api;
        this.count = count;
        this.status = status;
    }

    public long getGenerated() {
        return generated;
    }

    public void setGenerated(long generated) {
        this.generated = generated;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
