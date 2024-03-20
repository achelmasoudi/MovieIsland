package org.myprojectofnotes2022.moviemax12.moviesisland20012;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Adapter.AdapterOfDramaMovies;
import Adapter.AdapterOfMobstersMovies;
import Adapter.AdapterOfRomanticMovies;
import Adapter.AdapterOfWarMovies;
import Model.DramaMovie;
import Model.MobstersMovie;
import Model.RomanticMovie;
import Model.WarMovie;

public class HomeFragment extends Fragment {

    private AdapterOfDramaMovies adapterOfDramaMovies;
    private AdapterOfWarMovies adapterOfWarMovies;
    private AdapterOfMobstersMovies adapterOfMobstersMovies;
    private AdapterOfRomanticMovies adapterOfRomanticMovies;
    private RecyclerView recyclerViewDrama , recyclerViewWar , recyclerViewMobster , recyclerViewRomantic;
    private List<DramaMovie> dramaMovieList;
    private List<WarMovie> warMovieList;
    private List<MobstersMovie> mobstersMovieList;
    private List<RomanticMovie> romanticMovieList;

    //Firebase
    private DatabaseReference myReference;

    @Nullable
    @androidx.annotation.Nullable
    @Override
    public View onCreateView(@NonNull @androidx.annotation.NonNull LayoutInflater inflater, @Nullable @androidx.annotation.Nullable ViewGroup container, @Nullable @androidx.annotation.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home , container , false);

        recyclerViewDrama = view.findViewById(R.id.DramarecyclerViewId);
        recyclerViewWar = view.findViewById(R.id.WarrecyclerViewId);
        recyclerViewMobster = view.findViewById(R.id.MobstersrecyclerViewId);
        recyclerViewRomantic = view.findViewById(R.id.RomanticrecyclerViewId);

        myReference = FirebaseDatabase.getInstance().getReference();

        dramaMovieFunction();
        warMovieFunction();
        mobstersMovieFunction();
        romanticMovieFunction();

        return view;
    }



    //Drama Movies
    private void dramaMovieFunction() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity() ,
                LinearLayoutManager.HORIZONTAL , false );
        recyclerViewDrama.setLayoutManager(linearLayoutManager);
        recyclerViewDrama.setHasFixedSize(true);
        recyclerViewDrama.setItemAnimator(new DefaultItemAnimator());

        //Functions Calling
        dramaMovieList = new ArrayList<>();
        getDataFromFBForDrama();

    }
    private void getDataFromFBForDrama() {
        Query query = myReference.child("DramaMovie");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@androidx.annotation.NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    DramaMovie dramaMovie = new DramaMovie();
                    dramaMovie.setNameOfDramaMovie(snapshot.child("nameOfDramaMovie").getValue().toString());
                    dramaMovie.setImageURL_drama(snapshot.child("ImageUrlDramaMovie").getValue().toString());
                    dramaMovie.setVideoURL_drama(snapshot.child("videoUrlDramaMovie").getValue().toString());
                    dramaMovieList.add(dramaMovie);
                }
                adapterOfDramaMovies = new AdapterOfDramaMovies(getContext() , dramaMovieList);
                recyclerViewDrama.setAdapter(adapterOfDramaMovies);
                adapterOfDramaMovies.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@androidx.annotation.NonNull DatabaseError error) {
            }
        });
    }

    //War Movies
    private void warMovieFunction() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity() ,
                LinearLayoutManager.HORIZONTAL , false );
        recyclerViewWar.setLayoutManager(linearLayoutManager);
        recyclerViewWar.setHasFixedSize(true);
        recyclerViewWar.setItemAnimator(new DefaultItemAnimator());

        //Functions Calling
        warMovieList = new ArrayList<>();
        getDataFromFBForWar();

    }
    private void getDataFromFBForWar() {
        Query query = myReference.child("WarMovie");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@androidx.annotation.NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    WarMovie warMovie = new WarMovie();
                    warMovie.setNameOfWarMovie(snapshot.child("nameOfWarMovie").getValue().toString());
                    warMovie.setImageURL_war(snapshot.child("ImageUrlWarMovie").getValue().toString());
                    warMovie.setVideoURL_war(snapshot.child("videoUrlWarMovie").getValue().toString());
                    warMovieList.add(warMovie);
                }
                adapterOfWarMovies = new AdapterOfWarMovies(getContext() , warMovieList);
                recyclerViewWar.setAdapter(adapterOfWarMovies);
                adapterOfWarMovies.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@androidx.annotation.NonNull DatabaseError error) {
            }
        });
    }

    //Mobsters Movies
    private void mobstersMovieFunction() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity() ,
                LinearLayoutManager.HORIZONTAL , false );
        recyclerViewMobster.setLayoutManager(linearLayoutManager);
        recyclerViewMobster.setHasFixedSize(true);
        recyclerViewMobster.setItemAnimator(new DefaultItemAnimator());

        //Functions Calling
        mobstersMovieList = new ArrayList<>();
        getDataFromFBForMobsters();

    }
    private void getDataFromFBForMobsters() {
        Query query = myReference.child("MobstersMovie");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@androidx.annotation.NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    MobstersMovie mobstersMovie = new MobstersMovie();
                    mobstersMovie.setNameOfMobstersMovie(snapshot.child("nameOfMobstersMovie").getValue().toString());
                    mobstersMovie.setImageURL_mobsters(snapshot.child("ImageUrlMobstersMovie").getValue().toString());
                    mobstersMovie.setVideoURL_mobsters(snapshot.child("videoUrlMobstersMovie").getValue().toString());
                    mobstersMovieList.add(mobstersMovie);
                }
                adapterOfMobstersMovies = new AdapterOfMobstersMovies(getContext() , mobstersMovieList);
                recyclerViewMobster.setAdapter(adapterOfMobstersMovies);
                adapterOfMobstersMovies.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@androidx.annotation.NonNull DatabaseError error) {
            }
        });
    }

    //Romantic Movies
    private void romanticMovieFunction() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity() ,
                LinearLayoutManager.HORIZONTAL , false );
        recyclerViewRomantic.setLayoutManager(linearLayoutManager);
        recyclerViewRomantic.setHasFixedSize(true);
        recyclerViewRomantic.setItemAnimator(new DefaultItemAnimator());

        //Functions Calling
        romanticMovieList = new ArrayList<>();
        getDataFromFBForRomantic();
    }

    private void getDataFromFBForRomantic() {
        Query query = myReference.child("RomanticMovie");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@androidx.annotation.NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    RomanticMovie romanticMovie = new RomanticMovie();
                    romanticMovie.setNameOfRomanticMovie(snapshot.child("nameOfRomanticMovie").getValue().toString());
                    romanticMovie.setImageURL_romantic(snapshot.child("ImageUrlRomanticMovie").getValue().toString());
                    romanticMovie.setVideoURL_romantic(snapshot.child("videoUrlRomanticMovie").getValue().toString());
                    romanticMovieList.add(romanticMovie);
                }
                adapterOfRomanticMovies = new AdapterOfRomanticMovies(getContext() , romanticMovieList);
                recyclerViewRomantic.setAdapter(adapterOfRomanticMovies);
                adapterOfRomanticMovies.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@androidx.annotation.NonNull DatabaseError error) {
            }
        });
    }

    @Override
    public void onCreate(@androidx.annotation.Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@androidx.annotation.NonNull Menu menu, @androidx.annotation.NonNull MenuInflater inflater) {
        MenuInflater menuInflater = inflater;
        menuInflater.inflate(R.menu.my_menu , menu);
        MenuItem menuItem = menu.findItem(R.id.SearchViewId);

        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setIconified(true);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void filterList(String text) {
        //For Drama Movies
        List<DramaMovie> filteredListDrama = new ArrayList<>();
        for(DramaMovie dramaMovie : dramaMovieList) {
            if(dramaMovie.getNameOfDramaMovie().toLowerCase().contains(text.toLowerCase())) {
                filteredListDrama.add(dramaMovie);
            }
        }

        //For War Movies
        List<WarMovie> filteredListWar = new ArrayList<>();
        for(WarMovie warMovie : warMovieList) {
            if(warMovie.getNameOfWarMovie().toLowerCase().contains(text.toLowerCase())) {
                filteredListWar.add(warMovie);
            }
        }

        //For Mobsters Movies
        List<MobstersMovie> filteredListMobsters = new ArrayList<>();
        for( MobstersMovie mobstersMovie : mobstersMovieList ) {
            if(mobstersMovie.getNameOfMobstersMovie().toLowerCase().contains(text.toLowerCase())) {
                filteredListMobsters.add(mobstersMovie);
            }
        }

        //For Romantic Movies
        List<RomanticMovie> filteredListRomantic = new ArrayList<>();
        for( RomanticMovie romanticMovie : romanticMovieList ) {
            if(romanticMovie.getNameOfRomanticMovie().toLowerCase().contains(text.toLowerCase())) {
                filteredListRomantic.add(romanticMovie);
            }
        }



        if(filteredListDrama.isEmpty() && filteredListWar.isEmpty() && filteredListMobsters.isEmpty()
            && filteredListRomantic.isEmpty() ) {

        }

        else {
            adapterOfDramaMovies.setFilteredList(filteredListDrama);
            adapterOfWarMovies.setFilteredList(filteredListWar);
            adapterOfMobstersMovies.setFilteredList(filteredListMobsters);
            adapterOfRomanticMovies.setFilteredList(filteredListRomantic);
        }
    }

}
