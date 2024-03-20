package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.myprojectofnotes2022.moviemax12.moviesisland20012.AboutTheMovie;
import org.myprojectofnotes2022.moviemax12.moviesisland20012.R;

import java.util.List;

import Model.ModelOfFireFragment;

public class AdapterOfFireFragment extends RecyclerView.Adapter<AdapterOfFireFragment.MyViewHolder> {

    private Context context;
    private List<ModelOfFireFragment> modelOfFireFragmentList;

    public AdapterOfFireFragment(Context context , List<ModelOfFireFragment> modelOfFireFragmentList) {
        this.context = context;
        this.modelOfFireFragmentList = modelOfFireFragmentList;
    }

    //About FilteredList
    public void setFilteredList(List<ModelOfFireFragment> filteredList) {
        this.modelOfFireFragmentList = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_fire_row_custom  , parent , false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext() , android.R.anim.slide_in_left);
        ModelOfFireFragment movie = modelOfFireFragmentList.get(position);
        Picasso.get().load(movie.getImageUri_FireFragment()).into(holder.imageView1);
        holder.itemView.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return modelOfFireFragmentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imageView1 ;
        private CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView1 = itemView.findViewById(R.id.firstImageOfFireFragment);
            cardView = itemView.findViewById(R.id.cardView1Id);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context , AboutTheMovie.class);
            int position = getLayoutPosition();
            ModelOfFireFragment movie = modelOfFireFragmentList.get(position);
            intent.putExtra("pictureOfMovie" , movie.getImageUri_FireFragment());
            intent.putExtra("nameOfMovie" , movie.getNameOfMovie_FireFragment());
            intent.putExtra("backgroundOfmovie", movie.getBackgroundUri_FireFragment());
            intent.putExtra("uriOfTheMovie" , movie.getVideoUri_FireFragment());
            context.startActivity(intent);
        }
    }

}
