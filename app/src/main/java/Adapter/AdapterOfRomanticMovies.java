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
import Model.RomanticMovie;

public class AdapterOfRomanticMovies extends RecyclerView.Adapter<AdapterOfRomanticMovies.MyViewHolder> {

    private Context context;
    private List<RomanticMovie> romanticMovieList;

    public AdapterOfRomanticMovies(Context pContext , List<RomanticMovie> romanticMovieList) {
        this.context = pContext;
        this.romanticMovieList = romanticMovieList;
    }

    //setFilteredList
    public void setFilteredList(List<RomanticMovie> filteredList) {
        this.romanticMovieList = filteredList;
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
        RomanticMovie romanticMovie = romanticMovieList.get(position);
        holder.romanticMovieName.setText(romanticMovie.getNameOfRomanticMovie());
        String urlImage = romanticMovie.getImageURL_romantic();
        Picasso.get().load(urlImage).into(holder.romanticMovieImage);
    }

    @Override
    public int getItemCount() {
        return romanticMovieList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView romanticMovieName;
        private ImageView romanticMovieImage;
        private CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            romanticMovieName = itemView.findViewById(R.id.nameOfMovie);
            romanticMovieImage = itemView.findViewById(R.id.imageOfMovie);
            cardView = itemView.findViewById(R.id.cardViewId);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context , WatchMovie.class);
            int position = getLayoutPosition();
            RomanticMovie romanticMovie = romanticMovieList.get(position);
            intent.putExtra("videoURL" , romanticMovie.getVideoURL_romantic());
            context.startActivity(intent);
        }

    }

}
