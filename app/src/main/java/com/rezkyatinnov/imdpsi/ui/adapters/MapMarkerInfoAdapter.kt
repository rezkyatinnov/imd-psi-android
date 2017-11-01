package com.rezkyatinnov.imdpsi.ui.adapters

import android.view.LayoutInflater
import android.view.View
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.rezkyatinnov.imdpsi.R
import kotlinx.android.synthetic.main.layout_marker_info.view.*

/**
 * Created by rezkya on 11/1/17.
 */
class MapMarkerInfoAdapter(var inflater: LayoutInflater): GoogleMap.InfoWindowAdapter {
    var markerInfoView:View? = null
    override fun getInfoContents(marker: Marker?): View {
        if (markerInfoView == null) {
            markerInfoView=inflater.inflate(R.layout.layout_marker_info, null);
        }

        markerInfoView?.title_snippet?.text = marker?.getTitle()
        markerInfoView?.snippet_txt?.text = marker?.getSnippet()

        return markerInfoView!!
    }

    override fun getInfoWindow(p0: Marker?): View? {
        return null
    }
}
