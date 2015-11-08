package fr.isen.teamnougat.sweetquizz.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.model.quizz.ServerQuizz;
import fr.isen.teamnougat.sweetquizz.model.quizz.ServerQuizzes;


public class QuizzListAdapter extends RecyclerView.Adapter<QuizzListAdapter.ViewHolder> {

    private Context mContext;
    private OnItemClickListener mItemClickListener;
    private ServerQuizzes quizzes;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_themes_quizz, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ServerQuizz quizz = quizzes.getQuizzesList().get(position);
        holder.placeName.setText(quizz.getName());
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
        public LinearLayout placeHolder;
        public LinearLayout placeNameHolder;
        public TextView placeName;

        public ViewHolder(View itemView) {
            super(itemView);
            placeHolder = (LinearLayout) itemView.findViewById(R.id.mainHolder);
            placeName = (TextView) itemView.findViewById(R.id.placeName);
            placeNameHolder = (LinearLayout) itemView.findViewById(R.id.placeNameHolder);
            placeHolder.setOnClickListener(this);
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