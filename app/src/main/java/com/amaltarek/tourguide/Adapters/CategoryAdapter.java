package com.amaltarek.tourguide.Adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.amaltarek.tourguide.Fragments.AttractionFragment;
import com.amaltarek.tourguide.Fragments.BeachFragment;
import com.amaltarek.tourguide.Fragments.HotelFragment;
import com.amaltarek.tourguide.Fragments.RestaurantFragment;
import com.amaltarek.tourguide.R;

public class CategoryAdapter extends FragmentPagerAdapter {

    // Context of the app
    private Context mContext;

    public CategoryAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }


    /**
     * Get the Fragment that should be displayed
     * @param position
     * @return the Fragment that should be displayed
     */
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new AttractionFragment();
        }else if(position == 1){
            return new BeachFragment();
        }else if(position == 2){
            return new RestaurantFragment();
        }else{
            return new HotelFragment();
        }
    }

    /**
     * Return Total Number of Pages
     * @return
     */
    @Override
    public int getCount() {
        return 4;
    }

    /**
     * Get Fragment Tab Title to display with Fragment
     * @param position
     * @return
     */
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return mContext.getString(R.string.attractions);
        }else if (position == 1){
            return mContext.getString(R.string.beaches);
        }else if(position == 2){
            return mContext.getString(R.string.restaurants);
        }else{
            return mContext.getString(R.string.hotels);
        }
    }
}
