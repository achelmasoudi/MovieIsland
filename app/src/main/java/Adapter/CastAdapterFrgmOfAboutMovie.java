package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.myprojectofnotes2022.moviemax12.moviesisland20012.R;

import java.util.List;

import Model.ModelOfCastFrgmForAboutMovie;
import de.hdodenhof.circleimageview.CircleImageView;

public class CastAdapterFrgmOfAboutMovie extends RecyclerView.Adapter<CastAdapterFrgmOfAboutMovie.MyViewHolder> {

    private Context context;
    private List<ModelOfCastFrgmForAboutMovie> castList;

    public CastAdapterFrgmOfAboutMovie(Context context, List<ModelOfCastFrgmForAboutMovie> castList) {
        this.context = context;
        this.castList = castList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cast_fragment_rowlist_custom_of_aboutmovie , parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelOfCastFrgmForAboutMovie cast = castList.get(position);
        holder.name.setText(cast.getName());
        Picasso.get().load(cast.getPicture()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return castList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView image;
        private TextView name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.castimageviewId);
            name = itemView.findViewById(R.id.castnameOfactorId);
        }
    }
}
