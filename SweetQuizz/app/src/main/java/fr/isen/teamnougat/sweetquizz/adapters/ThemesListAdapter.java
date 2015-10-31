package fr.isen.teamnougat.sweetquizz.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.model.Place;
import fr.isen.teamnougat.sweetquizz.model.PlaceTheme;

public class ThemesListAdapter extends RecyclerView.Adapter<ThemesListAdapter.ViewHolder> {

    Context mContext;

    // 2
    public ThemesListAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_themes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Place place = new PlaceTheme().placeList().get(position);
        holder.placeName.setText(place.name);
        Picasso.with(mContext).load(place.getImageResourceId(mContext)).into(holder.placeImage);
    }

    @Override
    public int getItemCount() {
        return new PlaceTheme().placeList().size();
    }

    // 3
    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout placeHolder;
        public LinearLayout placeNameHolder;
        public TextView placeName;
        public ImageView placeImage;

        public ViewHolder(View itemView) {
            super(itemView);
            placeHolder = (LinearLayout) itemView.findViewById(R.id.mainHolder);
            placeName = (TextView) itemView.findViewById(R.id.placeName);
            placeNameHolder = (LinearLayout) itemView.findViewById(R.id.placeNameHolder);
            placeImage = (ImageView) itemView.findViewById(R.id.placeImage);
        }
    }
}