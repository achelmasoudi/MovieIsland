package org.myprojectofnotes2022.moviemax12.moviesisland20012;

import static android.app.Activity.RESULT_OK;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {

    private CircleImageView profileImage;
    private TextView profileName;
    private TextView logout;

    //Save Data With Shared Prefereneces
    private final static String MY_KEY = "secret";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile , container , false);

        profileImage = view.findViewById(R.id.ProfileImageId);
        profileName = view.findViewById(R.id.YournameInProfileId);
        logout = view.findViewById(R.id.logoutfromprofileId);

        //Functions Calling
        addProfileImage();

        return view;
    }

    private void addProfileImage() {
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK , MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(intent , 100);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100 && resultCode==RESULT_OK) {
            Uri selectedImage = data.getData();
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
            sharedPreferences.edit().putString("KEY_IMAGE", selectedImage.getPath()).apply();

            String uri = sharedPreferences.getString("KEY_IMAGE" , "Not found");
            profileImage.setImageURI(Uri.parse(uri));

        }
    }

    @Override
    public void onCreate(@androidx.annotation.Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@androidx.annotation.NonNull Menu menu, @androidx.annotation.NonNull MenuInflater inflater) {
        MenuInflater menuInflater = inflater;
        menuInflater.inflate(R.menu.my_profile_menu , menu);
        super.onCreateOptionsMenu(menu, inflater);
    }





}
