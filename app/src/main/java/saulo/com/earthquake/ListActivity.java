package saulo.com.earthquake;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

import saulo.com.earthquake.dataObjects.Features;
import saulo.com.earthquake.dataObjects.GeoJSON;
import saulo.com.earthquake.utils.Constants;
import saulo.com.earthquake.utils.DownloadJSONTask;
import saulo.com.earthquake.utils.RVAdapter;
import saulo.com.earthquake.utils.ResponseListener;

public class ListActivity extends AppCompatActivity implements ResponseListener, SwipeRefreshLayout.OnRefreshListener{

    private RecyclerView earthquakeList;
    private LinearLayoutManager layoutManager;
    private RecyclerView.Adapter dataAdapter;
    private SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //initialize components
        earthquakeList = (RecyclerView)findViewById(R.id.my_recycler_view);
        earthquakeList.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        earthquakeList.setLayoutManager(layoutManager);

        //set up pull to refresh
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(this);

        //start Async task
        swipeContainer.setRefreshing(true);
        fetchData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //refresh button clicked
        if (id == R.id.refresh) {
            swipeContainer.setRefreshing(true);
            //start Async task
            fetchData();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResponse(String receivedJson) {
        //if swipe container is refreshing, set it to unrefreshing
        if(swipeContainer.isRefreshing())
        {
            swipeContainer.setRefreshing(false);
        }
        //handle response
        //parse received json into object
        Gson gson = new Gson();
        Type dataType = new TypeToken<GeoJSON>() {
        }.getType();
        GeoJSON geoObj = gson.fromJson(receivedJson, dataType);

        //add all the features to our dataAdapter
        ArrayList<Features> data = new ArrayList();
        if (geoObj != null) {
            //set title from json
            getSupportActionBar().setTitle(geoObj.getType());

            data.addAll(Arrays.asList(geoObj.getFeatures()));
            dataAdapter = new RVAdapter(data, this);
            earthquakeList.setAdapter(dataAdapter);
        }
    }

    @Override
    public void onRefresh() {
        swipeContainer.setRefreshing(true);
        fetchData();
    }

    public void fetchData(){
        DownloadJSONTask dlt = new DownloadJSONTask(this);
        dlt.execute(Constants.FEED_URL);
    }
}
