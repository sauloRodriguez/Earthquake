package saulo.com.earthquake;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

import java.text.DateFormat;

import saulo.com.earthquake.utils.Constants;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private long millisec;
    private double [] coordinates;
    private double magnitude;
    private String place;
    private String date;
    private int cardColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            coordinates = bundle.getDoubleArray(Constants.GEOMETRY_EXTRA);
            millisec = bundle.getLong(Constants.DATE_EXTRA);
            date = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(millisec);
            Log.d("DATE", date);
            place = bundle.getString(Constants.PLACE_EXTRA);
            magnitude = bundle.getDouble(Constants.MAGNITUDE_EXTRA);
            cardColor = bundle.getInt(Constants.COLOR_EXTRA);
        }


        fillTextViews();
        CardView details = (CardView) findViewById(R.id.detail_cardView);
        details.setBackgroundColor(cardColor);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void fillTextViews() {
        TextView magTV = (TextView) findViewById(R.id.detail_magnitudeTextView);
        TextView dateTV = (TextView) findViewById(R.id.detail_dateTextView);
        TextView placeTV = (TextView) findViewById(R.id.detail_locationTextView);
        TextView depthTV = (TextView) findViewById(R.id.detail_depthTextView);

        placeTV.setText("Location:\n" + place);
        magTV.setText("Magnitude:\n" + magnitude);
        dateTV.setText("Date:\n" + date);
        depthTV.setText("Depth:\n" + coordinates[Constants.GEOMETRY_DEPTH]);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        float zoomLevel = 10.0f;

        LatLng epicenter= new LatLng(coordinates[Constants.GEOMETRY_LATITUDE],coordinates[Constants.GEOMETRY_LONGITUDE]);
        mMap.addMarker(new MarkerOptions().position(epicenter).title("Epicenter"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(epicenter, zoomLevel));
    }
}
