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

import Model.DramaMovie;

public class AdapterOfDramaMovies extends RecyclerView.Adapter<AdapterOfDramaMovies.MyViewHolder> {

    private Context context;
    private List<DramaMovie> dramaMovieList;

    public AdapterOfDramaMovies(Context pContext , List<DramaMovie> pDramaMovieList) {
        this.context = pContext;
        this.dramaMovieList = pDramaMovieList;
    }

    //setFilteredList
    public void setFilteredList(List<DramaMovie> filteredList) {
        this.dramaMovieList = filteredList;
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
        DramaMovie dramaMovie = dramaMovieList.get(position);
        holder.dramaMovieName.setText(dramaMovie.getNameOfDramaMovie());
        String urlImage = dramaMovie.getImageURL_drama();
        Picasso.get().load(urlImage).into(holder.dramaMovieImage);
    }

    @Override
    public int getItemCount() {
        return dramaMovieList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView dramaMovieName;
        private ImageView dramaMovieImage;
        private CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
                super(itemView);
            dramaMovieName = itemView.findViewById(R.id.nameOfMovie);
            dramaMovieImage = itemView.findViewById(R.id.imageOfMovie);
            cardView = itemView.findViewById(R.id.cardViewId);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context , WatchMovie.class);
            int position = getLayoutPosition();
            DramaMovie dramaMovie = dramaMovieList.get(position);
            intent.putExtra("videoURL" , dramaMovie.getVideoURL_drama());
            context.startActivity(intent);
        }

    }

}
