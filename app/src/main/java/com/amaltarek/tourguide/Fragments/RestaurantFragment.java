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
public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_restaurant, container, false);

        // Create ArrayList of Restaurants
        final ArrayList<Place> restaurants = new ArrayList<>();
        restaurants.add(new Place(R.drawable.restaurant_1, R.string.restaurant_1, R.string.restaurant_1_location));
        restaurants.add(new Place(R.drawable.restaurant_2, R.string.restaurant_2, R.string.restaurant_2_location));
        restaurants.add(new Place(R.drawable.restaurant_3, R.string.restaurant_3, R.string.restaurant_3_location));
        restaurants.add(new Place(R.drawable.restaurant_4, R.string.restaurant_4, R.string.restaurant_4_location));
        restaurants.add(new Place(R.drawable.restaurant_5, R.string.restaurant_5, R.string.restaurant_5_location));
        restaurants.add(new Place(R.drawable.restaurant_6, R.string.restaurant_6, R.string.restaurant_6_location));
        restaurants.add(new Place(R.drawable.restaurant_7, R.string.restaurant_7, R.string.restaurant_7_location));
        restaurants.add(new Place(R.drawable.restaurant_8, R.string.restaurant_8, R.string.restaurant_8_location));

        // to Shuffle ArrayList of Restaurants every time open the App
        Collections.shuffle(restaurants);

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Song}s.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), restaurants);

        // Find the {@link GridView} object in the view hierarchy of the {@link Activity}.
        GridView restaurantsList =  rootView.findViewById(R.id.restaurant_grid);

        // Make the {@link GridView} use the {@link PlaceAdapter} we created above.
        restaurantsList.setAdapter(adapter);

        // Set a click listener of Restaurant list if user click on item in it
        restaurantsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Place : "+ getContext().getString(restaurants.get(position).getPlaceName()), Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }

}
