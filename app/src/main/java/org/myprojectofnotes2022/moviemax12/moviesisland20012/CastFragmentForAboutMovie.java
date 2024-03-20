package org.myprojectofnotes2022.moviemax12.moviesisland20012;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import Adapter.CastAdapterFrgmOfAboutMovie;
import Model.ModelOfCastFrgmForAboutMovie;

public class CastFragmentForAboutMovie extends Fragment {

    private RecyclerView recyclerView;
    private List<ModelOfCastFrgmForAboutMovie> castList;
    private CastAdapterFrgmOfAboutMovie adapter;
    private View view;

    //Firebase
//    private DatabaseReference myReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cast_movie_fragment_foraboutmovie , container , false);

//        recyclerView = view.findViewById(R.id.castFragmentrecyclerViewId);

//        myReference = FirebaseDatabase.getInstance().getReference();

        //Function Calling
//        castFunc();
        
        return view;
    }

//    private void castFunc() {
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setHasFixedSize(true);

        //Calling Functions About The Firebase
//        clearAll();
//        getCastDataFromFirebase();
        
//    }

//    private void getCastDataFromFirebase() {
//        Query query = myReference.child("movie1 A Beautiful Mind");
//        query.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for(DataSnapshot snapshot : dataSnapshot.getChildren() ) {
//                    ModelOfCastFrgmForAboutMovie castModel = new ModelOfCastFrgmForAboutMovie();
//
//                    castModel.setName(snapshot.child("nameOfActor").getValue().toString());
//                    castModel.setPicture(snapshot.child("imageOfActor").getValue().toString());
//
//                    castList.add(castModel);
//                }
//
//                adapter = new CastAdapterFrgmOfAboutMovie(getContext() , castList);
//                recyclerView.setAdapter(adapter);
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
//
//    private void clearAll() {
//        if(castList != null) {
//            castList.clear();
//            if(recyclerView != null) {
//                adapter.notifyDataSetChanged();
//            }
//        }
//        castList = new ArrayList<>();
//    }


}
