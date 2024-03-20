package org.myprojectofnotes2022.moviemax12.moviesisland20012;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import Adapter.ViewPagerAdapterForAboutMovie;

public class AboutTheMovie extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView backgroundPicture, offPictureOfMovie;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapterForAboutMovie adapter;

    private String uri ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_the_movie);

        theFragmentAndTheViewPagerAndTabLayout();
        collapsingFunc();

    }

    private void theFragmentAndTheViewPagerAndTabLayout() {
        tabLayout = findViewById(R.id.tablayoutId);
        viewPager = findViewById(R.id.viewPagerId);

        adapter = new ViewPagerAdapterForAboutMovie(getSupportFragmentManager());

        adapter.AddFragment(new AboutTheMovieFragmentAboutMovie(), "About The Movie");
        adapter.AddFragment(new StoryFragmentForAboutMovie(), "Story");
        adapter.AddFragment(new WatchOrDownloadFragmentForAboutMovie(), "Watch Or Download");
        adapter.AddFragment(new CastFragmentForAboutMovie(), "Cast");

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(adapter);
    }

    private void collapsingFunc() {
        collapsingToolbarLayout = findViewById(R.id.collapsingtoolbarId);
        backgroundPicture = findViewById(R.id.aboutMoviebackgroundPicture);
        offPictureOfMovie = findViewById(R.id.aboutMoviePictureOfMovie);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String moviePicture = bundle.getString("pictureOfMovie");
            String nameOfMovie = bundle.getString("nameOfMovie");
            String backgroundOfMovie = bundle.getString("backgroundOfmovie");
            collapsingToolbarLayout.setTitle(nameOfMovie);
            Picasso.get().load(moviePicture).into(offPictureOfMovie);
            Picasso.get().load(backgroundOfMovie).into(backgroundPicture);
        }

        Intent intent = getIntent();
        uri = intent.getExtras().getString("uriOfTheMovie");
    }

    public Bundle getMyData() {
        Bundle bundle = new Bundle();
        bundle.putString("uri",uri);
        return bundle;
    }
}