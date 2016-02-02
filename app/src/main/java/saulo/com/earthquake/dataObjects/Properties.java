package saulo.com.earthquake.dataObjects;

/**
 * Created by saulo on 30/01/16.
 */
public class Properties {
    private double mag;
    private String place;
    private long time;
    private long updated;
    private int tz;
    private String url;
    private String detail;
    private int felt;
    private double cdi;
    private double mmi;
    private String alert;
    private String status;
    private int tsunami;
    private int sig;
    private String net;
    private String code;
    private String ids;
    private String sources;
    private String types;
    private int nst;
    private double dmin;
    private double rms;
    private double gap;
    private String magType;
    private String type;

    public Properties(double mag, String place, long time, long updated, int tz, String url, String detail, int felt, double cdi, double mmi, String alert, String status, int tsunami, int sig, String net, String code, String ids, String sources, String types, int nst, double dmin, double rms, double gap, String magType, String type) {
        this.mag = mag;
        this.place = place;
        this.time = time;
        this.updated = updated;
        this.tz = tz;
        this.url = url;
        this.detail = detail;
        this.felt = felt;
        this.cdi = cdi;
        this.mmi = mmi;
        this.alert = alert;
        this.status = status;
        this.tsunami = tsunami;
        this.sig = sig;
        this.net = net;
        this.code = code;
        this.ids = ids;
        this.sources = sources;
        this.types = types;
        this.nst = nst;
        this.dmin = dmin;
        this.rms = rms;
        this.gap = gap;
        this.magType = magType;
        this.type = type;
    }

    public double getMag() {
        return mag;
    }

    public void setMag(double mag) {
        this.mag = mag;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public int getTz() {
        return tz;
    }

    public void setTz(int tz) {
        this.tz = tz;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getFelt() {
        return felt;
    }

    public void setFelt(int felt) {
        this.felt = felt;
    }

    public double getCdi() {
        return cdi;
    }

    public void setCdi(double cdi) {
        this.cdi = cdi;
    }

    public double getMmi() {
        return mmi;
    }

    public void setMmi(double mmi) {
        this.mmi = mmi;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTsunami() {
        return tsunami;
    }

    public void setTsunami(int tsunami) {
        this.tsunami = tsunami;
    }

    public int getSig() {
        return sig;
    }

    public void setSig(int sig) {
        this.sig = sig;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public int getNst() {
        return nst;
    }

    public void setNst(int nst) {
        this.nst = nst;
    }

    public double getDmin() {
        return dmin;
    }

    public void setDmin(double dmin) {
        this.dmin = dmin;
    }

    public double getRms() {
        return rms;
    }

    public void setRms(double rms) {
        this.rms = rms;
    }

    public double getGap() {
        return gap;
    }

    public void setGap(double gap) {
        this.gap = gap;
    }

    public String getMagType() {
        return magType;
    }

    public void setMagType(String magType) {
        this.magType = magType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
