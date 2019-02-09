package com.amaltarek.tourguide.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
public class BeachFragment extends Fragment {


    public BeachFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_beach, container, false);

        // Create ArrayList of Beaches
        final ArrayList<Place> beaches = new ArrayList<>();
        beaches.add(new Place(R.drawable.beach_1, R.string.beach_1, R.string.beach_1_location,  R.string.beach_1_desc));
        beaches.add(new Place(R.drawable.beach_2, R.string.beach_2, R.string.beach_2_location,  R.string.beach_2_desc));
        beaches.add(new Place(R.drawable.beach_3, R.string.beach_3, R.string.beach_3_location,  R.string.beach_3_desc));
        beaches.add(new Place(R.drawable.beach_4, R.string.beach_4, R.string.beach_4_location,  R.string.beach_4_desc));
        beaches.add(new Place(R.drawable.beach_5, R.string.beach_5, R.string.beach_5_location,  R.string.beach_5_desc));
        beaches.add(new Place(R.drawable.beach_6, R.string.beach_6, R.string.beach_6_location,  R.string.beach_6_desc));
        beaches.add(new Place(R.drawable.beach_7, R.string.beach_7, R.string.beach_7_location,  R.string.beach_7_desc));

        // to Shuffle ArrayList of Beaches every time open the App
        Collections.shuffle(beaches);

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Song}s.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), beaches);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        ListView beachesList =  rootView.findViewById(R.id.beach_list);

        // Make the {@link ListView} use the {@link PlaceAdapter} we created above.
        beachesList.setAdapter(adapter);

        // Set a click listener of beach list if user click on item in it
        beachesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Place : "+ getContext().getString(beaches.get(position).getPlaceName()), Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }

}
