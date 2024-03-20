package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.myprojectofnotes2022.moviemax12.moviesisland20012.R;
import org.myprojectofnotes2022.moviemax12.moviesisland20012.WatchMovie;

import java.util.List;

import Model.WarMovie;

public class AdapterOfWarMovies extends RecyclerView.Adapter<AdapterOfWarMovies.MyViewHolder> {

    private Context context;
    private List<WarMovie> warMovieList;

    public AdapterOfWarMovies(Context pContext , List<WarMovie> pWarMovieList) {
        this.context = pContext;
        this.warMovieList = pWarMovieList;
    }

    //setFilteredList
    public void setFilteredList(List<WarMovie> filteredList) {
        this.warMovieList = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.moviepicture_custom_recyclerview , parent , false);
        MyViewHolder myViewHolder =new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        WarMovie warMovie = warMovieList.get(position);
        holder.warMovieName.setText(warMovie.getNameOfWarMovie());
        String urlImage = warMovie.getImageURL_war();
        Picasso.get().load(urlImage).into(holder.warMovieImage);
    }

    @Override
    public int getItemCount() {
        return warMovieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView warMovieName;
        private ImageView warMovieImage;
        private CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            warMovieName = itemView.findViewById(R.id.nameOfMovie);
            warMovieImage = itemView.findViewById(R.id.imageOfMovie);
            cardView = itemView.findViewById(R.id.cardViewId);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context , WatchMovie.class);
            int position = getLayoutPosition();
            WarMovie warMovie = warMovieList.get(position);
            intent.putExtra("videoURL" , warMovie.getVideoURL_war());
            context.startActivity(intent);
        }

    }

}
