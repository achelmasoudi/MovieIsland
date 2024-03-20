package org.myprojectofnotes2022.moviemax12.moviesisland20012;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Adapter.AdapterOfFireFragment;
import Model.ModelOfFireFragment;

public class FireFragment extends Fragment {

    private RecyclerView recyclerViewOfFireFragment;
    private AdapterOfFireFragment adapter;
    private List<ModelOfFireFragment> movieList;

    //Firebase
    private DatabaseReference myReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fire , container, false);

        recyclerViewOfFireFragment = view.findViewById(R.id.recyclerviewOfFireFragmentId);

        myReference = FirebaseDatabase.getInstance().getReference();

        movieFunction();

        return view;
    }

    private void movieFunction() {

        GridLayoutManager layoutManager = new GridLayoutManager(getContext() , 2 );
        recyclerViewOfFireFragment.setLayoutManager(layoutManager);
        recyclerViewOfFireFragment.setHasFixedSize(true);

        //Functions
        movieList = new ArrayList<>();
        getDataFromFirebase();
    }

    private void getDataFromFirebase() {
        Query query = myReference.child("FireFragmentMovies");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    ModelOfFireFragment modelOfFireFragment = new ModelOfFireFragment();

                    modelOfFireFragment.setNameOfMovie_FireFragment(snapshot.child("nameOfFireFragmentMovie").getValue().toString());
                    modelOfFireFragment.setImageUri_FireFragment(snapshot.child("imageUrlOfFireFragmentMovie").getValue().toString());
                    modelOfFireFragment.setBackgroundUri_FireFragment(snapshot.child("backgroundUrlOfFireFragmentMovie").getValue().toString());
                    modelOfFireFragment.setVideoUri_FireFragment(snapshot.child("videoUrlOfFireFragmentMovie").getValue().toString());

                    movieList.add(modelOfFireFragment);
                }

                adapter = new AdapterOfFireFragment(getContext() , movieList);
                recyclerViewOfFireFragment.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        inflater.inflate(R.menu.my_menu , menu);
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

    private void filterList(String text) {
        List<ModelOfFireFragment> filteredList = new ArrayList<>();
        for(ModelOfFireFragment movie : movieList) {
            if(movie.getNameOfMovie_FireFragment().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(movie);
            }
        }
        if(filteredList.isEmpty()) {

        }
        else {
            adapter.setFilteredList(filteredList);
        }
    }
}
