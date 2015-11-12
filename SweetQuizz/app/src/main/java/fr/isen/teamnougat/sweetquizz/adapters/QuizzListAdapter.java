package fr.isen.teamnougat.sweetquizz.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.SweetQuizz;
import fr.isen.teamnougat.sweetquizz.model.quizz.ServerQuizz;
import fr.isen.teamnougat.sweetquizz.model.quizz.ServerQuizzes;


public class QuizzListAdapter extends RecyclerView.Adapter<QuizzListAdapter.ViewHolder> {

    private Context mContext;
    private OnItemClickListener mItemClickListener;
    private ServerQuizzes quizzes;
    public String[] allColors = SweetQuizz.getAppContext().getResources().getStringArray(R.array.colors_palettes);

    public QuizzListAdapter(Context context) {
        this.mContext = context;
    }

    public ServerQuizzes getQuizzes() {
        return quizzes;
    }


    public QuizzListAdapter(Context mContext, ServerQuizzes quizzes) {
        this.mContext = mContext;
        this.quizzes = quizzes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_list_quizz, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ServerQuizz quizz = quizzes.getQuizzesList().get(position);
        holder.placeNameQuizz.setText(quizz.getScreenName());
        int randomColor = Color.parseColor(allColors[new Random().nextInt(allColors.length)]);
        holder.placeCardQuizz.setCardBackgroundColor(randomColor);
    }

    @Override
    public int getItemCount() {
        return quizzes.getQuizzesList().size();
    }

    public ServerQuizz getQuizzAtPosition(int position){
        return quizzes.getQuizzesList().get(position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public LinearLayout placeHolderQuizz;
        public LinearLayout placeNameHolderQuizz;
        public TextView placeNameQuizz;
        public CardView placeCardQuizz;

        public ViewHolder(View itemView) {
            super(itemView);
            placeHolderQuizz = (LinearLayout) itemView.findViewById(R.id.mainHolderQuizz);
            placeNameQuizz = (TextView) itemView.findViewById(R.id.placeNameQuizz);
            placeCardQuizz = (CardView) itemView.findViewById(R.id.placeCardQuizz);
            placeHolderQuizz.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(itemView, getPosition());
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}