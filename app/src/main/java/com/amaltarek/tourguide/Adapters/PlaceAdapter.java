package com.amaltarek.tourguide.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amaltarek.tourguide.Model.Place;
import com.amaltarek.tourguide.R;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    public PlaceAdapter(Context context, ArrayList<Place> places) {
        super(context,0, places);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Place currentPlace = getItem(position);
        if(convertView == null){
            if (currentPlace.hasDesc())
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.attraction_item, parent, false);
            else
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.restaurant_item, parent, false);
        }

        // Get the UI Place and fill Content
        ImageView placeArt = convertView.findViewById(R.id.place_art);
        placeArt.setImageResource(currentPlace.getPlaceArtResourceID());

        TextView placeName = convertView.findViewById(R.id.place_name);
        placeName.setText(currentPlace.getPlaceName());

        TextView placeLocation = convertView.findViewById(R.id.place_location);
        placeLocation.setText(currentPlace.getLocationName());

        if (currentPlace.hasDesc()){
            TextView placeDesc = convertView.findViewById(R.id.place_desc);
            placeDesc.setText(currentPlace.getPlaceDesc());
        }

        return convertView;
    }
}
