package fr.isen.teamnougat.sweetquizz.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.model.theme.Theme;
import fr.isen.teamnougat.sweetquizz.model.theme.Themes;


public class ThemesListAdapter extends RecyclerView.Adapter<ThemesListAdapter.ViewHolder> {

    private Context mContext;
    private OnItemClickListener mItemClickListener;
    private Themes themes;

    public ThemesListAdapter(Context context) {
        this.mContext = context;
    }


    public ThemesListAdapter(Context context, Themes themes) {
        this.mContext = context;
        this.themes = themes;
    }

    public Theme getThemeAtPosition(int position){
        return themes.getThemesList().get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_themes_quizz, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Theme theme = themes.getThemesList().get(position);
        holder.placeName.setText(theme.name);
        Picasso.with(mContext).load(theme.getImageResourceId(mContext)).into(holder.placeImage);
    }

    @Override
    public int getItemCount() {
        return themes.getThemesList().size();
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    // 3
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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
            placeHolder.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(itemView, getAdapterPosition());
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }


    public Themes getThemes() {
        return themes;
    }

    public void setThemes(Themes themes) {
        this.themes = themes;
    }
}