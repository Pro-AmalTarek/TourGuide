package com.amaltarek.tourguide.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.amaltarek.tourguide.Adapters.PlaceAdapter;
import com.amaltarek.tourguide.Model.Place;
import com.amaltarek.tourguide.R;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttractionFragment extends Fragment {


    public AttractionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_attraction, container, false);

        // Create ArrayList of Attractions
        final ArrayList<Place> attractions = new ArrayList<>();
        attractions.add(new Place(R.drawable.attraction_1, R.string.attraction_1, R.string.attraction_1_location,  R.string.attraction_1_desc));
        attractions.add(new Place(R.drawable.attraction_2, R.string.attraction_2, R.string.attraction_2_location,  R.string.attraction_2_desc));
        attractions.add(new Place(R.drawable.attraction_3, R.string.attraction_3, R.string.attraction_3_location,  R.string.attraction_3_desc));
        attractions.add(new Place(R.drawable.attraction_4, R.string.attraction_4, R.string.attraction_4_location,  R.string.attraction_4_desc));
        attractions.add(new Place(R.drawable.attraction_5, R.string.attraction_5, R.string.attraction_5_location,  R.string.attraction_5_desc));
        attractions.add(new Place(R.drawable.attraction_6, R.string.attraction_6, R.string.attraction_6_location,  R.string.attraction_6_desc));
        attractions.add(new Place(R.drawable.attraction_7, R.string.attraction_7, R.string.attraction_7_location,  R.string.attraction_7_desc));

        // to Shuffle ArrayList of Attractions every time open the App
        Collections.shuffle(attractions);

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Song}s.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), attractions);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        ListView attractionsList =  rootView.findViewById(R.id.attraction_list);

        // Make the {@link ListView} use the {@link PlaceAdapter} we created above.
        attractionsList.setAdapter(adapter);

        // Set a click listener of attraction list if user click on item in it
        attractionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Place : "+ getContext().getString(attractions.get(position).getPlaceName()), Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }

}
