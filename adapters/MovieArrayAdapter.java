package edu.sdu.rnyati.flicksandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.sdu.rnyati.flicksandroid.R;
import edu.sdu.rnyati.flicksandroid.models.Movie;

/**
 * Created by raghavnyati on 12/11/17.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //get the data item for position
        Movie movie = getItem(position);

        //check the existing view is being used
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            inflater.inflate(R.layout.item_movie, parent, false);
        }

        //find the image view
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.imageView);
        //clear out image from convertview
        ivImage.setImageResource(0);

        TextView tvTitle = (TextView)  convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        //populate ata
        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());

        //return the view
        return convertView;
    }
}
