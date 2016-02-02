package saulo.com.earthquake.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import saulo.com.earthquake.MapsActivity;
import saulo.com.earthquake.R;
import saulo.com.earthquake.dataObjects.Features;
import saulo.com.earthquake.dataObjects.Geometry;

/**
 * Created by saulo on 30/01/16.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ItemListHolder> implements View.OnClickListener{

    private Context context;
    private ArrayList<Features> data;

    public RVAdapter (ArrayList<Features> data, Context context){
        this.data = data;
        this.context = context;
    }

    @Override
    public ItemListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ItemListHolder itemListHolder = new ItemListHolder(view);
        return itemListHolder;
    }

    @Override
    public void onBindViewHolder(ItemListHolder holder, int position) {
        Features feedItem = data.get(position);
        holder.locationTV.setText("Location: " + feedItem.getProperties().getPlace());
        holder.magnitudeTV.setText("Magnitude: " + feedItem.getProperties().getMag());

        //set card background depending on magnitude
        holder.content.setBackgroundColor(ColorCalculator.getColor(feedItem.getProperties().getMag()));

        //add listeners
        holder.cardView.setOnClickListener(this);
        holder.fab.setOnClickListener(this);

        holder.cardView.setTag(holder);
        holder.fab.setTag(holder);
    }

    @Override
    public int getItemCount() {
        return (null != data ? data.size() : 0);
    }

    @Override
    public void onClick(View v) {
        ItemListHolder holder = (ItemListHolder) v.getTag();
        int pos = holder.getPosition();

        Features selectedItem = data.get(pos);
        Geometry geoLocation = selectedItem.getGeometry();

        //start maps activity
        Intent intent = new Intent(context,MapsActivity.class);
        intent.putExtra(Constants.GEOMETRY_EXTRA, geoLocation.getCoordinates());
        intent.putExtra(Constants.MAGNITUDE_EXTRA, selectedItem.getProperties().getMag());
        intent.putExtra(Constants.DATE_EXTRA, selectedItem.getProperties().getTime());
        intent.putExtra(Constants.PLACE_EXTRA, selectedItem.getProperties().getPlace());
        intent.putExtra(Constants.COLOR_EXTRA, ColorCalculator.getColor(selectedItem.getProperties().getMag()));

        context.startActivity(intent);
    }

    public class ItemListHolder extends RecyclerView.ViewHolder {
        private final LinearLayout content;
        private final TextView locationTV;
        private final TextView magnitudeTV;
        private final FloatingActionButton fab;
        private final CardView cardView;

        public ItemListHolder(View view) {
            super(view);
            content = (LinearLayout) view.findViewById(R.id.contentLayout);
            fab = (FloatingActionButton) view.findViewById(R.id.fab);
            locationTV = (TextView) view.findViewById(R.id.locationTextView);
            magnitudeTV = (TextView) view.findViewById(R.id.magnitudeTextView);
            cardView = (CardView) view.findViewById(R.id.cardView);
        }
    }
}
