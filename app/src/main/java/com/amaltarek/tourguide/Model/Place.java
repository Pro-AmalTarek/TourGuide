package com.amaltarek.tourguide.Model;

public class Place {
    /** Art Resource ID for the Place */
    private int mPlaceArtResourceID;

    /** String resource ID for Place Name */
    private int mPlaceName;

    /** String resource ID for Location Name of the Place*/
    private int mLocationName;

    /** String resource ID for Place Description */
    private int mPlaceDesc = NO_DESC_PROVIDED;

    /** Constant value that represents no description was provided for this place */
    private static final int NO_DESC_PROVIDED = -1;

    public Place(int mPlaceArtResourceID, int mPlaceName, int mLocationName, int mPlaceDesc) {
        this.mPlaceArtResourceID = mPlaceArtResourceID;
        this.mPlaceName = mPlaceName;
        this.mLocationName = mLocationName;
        this.mPlaceDesc = mPlaceDesc;
    }

    public Place(int mPlaceArtResourceID, int mPlaceName, int mLocationName) {
        this.mPlaceArtResourceID = mPlaceArtResourceID;
        this.mPlaceName = mPlaceName;
        this.mLocationName = mLocationName;
    }

    public int getPlaceArtResourceID() {
        return mPlaceArtResourceID;
    }

    public int getPlaceName() {
        return mPlaceName;
    }

    public int getLocationName() {
        return mLocationName;
    }

    public int getPlaceDesc() {
        return mPlaceDesc;
    }

    /**
     * Returns whether or not there is an description for this place.
     */
    public boolean hasDesc() {
        return mPlaceDesc != NO_DESC_PROVIDED;
    }
}
