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

import Model.MobstersMovie;

public class AdapterOfMobstersMovies extends RecyclerView.Adapter<AdapterOfMobstersMovies.MyViewHolder> {

    private Context context;
    private List<MobstersMovie> mobstersMovieList;

    public AdapterOfMobstersMovies(Context pContext , List<MobstersMovie> pMobstersMovieList) {
        this.context = pContext;
        this.mobstersMovieList = pMobstersMovieList;
    }

    //setFilteredList
    public void setFilteredList(List<MobstersMovie> filteredList) {
        this.mobstersMovieList = filteredList;
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
        MobstersMovie mobstersMovie = mobstersMovieList.get(position);
        holder.mobstersMovieName.setText(mobstersMovie.getNameOfMobstersMovie());
        String urlImage = mobstersMovie.getImageURL_mobsters();
        Picasso.get().load(urlImage).into(holder.mobstersMovieImage);
    }

    @Override
    public int getItemCount() {
        return mobstersMovieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mobstersMovieName;
        private ImageView mobstersMovieImage;
        private CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mobstersMovieName = itemView.findViewById(R.id.nameOfMovie);
            mobstersMovieImage = itemView.findViewById(R.id.imageOfMovie);
            cardView = itemView.findViewById(R.id.cardViewId);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context , WatchMovie.class);
            int position = getLayoutPosition();
            MobstersMovie mobstersMovie = mobstersMovieList.get(position);
            intent.putExtra("videoURL" , mobstersMovie.getVideoURL_mobsters());
            context.startActivity(intent);
        }

    }

}
