package com.amaltarek.tourguide.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.amaltarek.tourguide.Adapters.PlaceAdapter;
import com.amaltarek.tourguide.Model.Place;
import com.amaltarek.tourguide.R;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelFragment extends Fragment {


    public HotelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_hotel, container, false);

        // Create ArrayList of Hotels
        final ArrayList<Place> hotels = new ArrayList<>();
        hotels.add(new Place(R.drawable.hotel_1, R.string.hotel_1, R.string.hotel_1_location));
        hotels.add(new Place(R.drawable.hotel_2, R.string.hotel_2, R.string.hotel_2_location));
        hotels.add(new Place(R.drawable.hotel_3, R.string.hotel_3, R.string.hotel_3_location));
        hotels.add(new Place(R.drawable.hotel_4, R.string.hotel_4, R.string.hotel_4_location));
        hotels.add(new Place(R.drawable.hotel_5, R.string.hotel_5, R.string.hotel_5_location));
        hotels.add(new Place(R.drawable.hotel_6, R.string.hotel_6, R.string.hotel_6_location));
        hotels.add(new Place(R.drawable.hotel_7, R.string.hotel_7, R.string.hotel_7_location));
        hotels.add(new Place(R.drawable.hotel_8, R.string.hotel_8, R.string.hotel_8_location));

        // to Shuffle ArrayList of Hotels every time open the App
        Collections.shuffle(hotels);

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Song}s.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), hotels);

        // Find the {@link GridView} object in the view hierarchy of the {@link Activity}.
        GridView hotelsList =  rootView.findViewById(R.id.hotel_grid);

        // Make the {@link GridView} use the {@link PlaceAdapter} we created above.
        hotelsList.setAdapter(adapter);

        // Set a click listener of hotels list if user click on item in it
        hotelsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Place : "+ getContext().getString(hotels.get(position).getPlaceName()), Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }

}
