package org.myprojectofnotes2022.moviemax12.moviesisland20012;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WatchOrDownloadFragmentForAboutMovie extends Fragment {

    private static final int PERMISSION_STORAGE_CODE = 1000;
    private View view;
    private Button download , watch;
    private String uri;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.watch_or_down_movie_fragment_foraboutmovie , container , false);

        download = view.findViewById(R.id.buttonToDownloadMovieId);
        watch = view.findViewById(R.id.buttonToWatchMovieId);

        AboutTheMovie activity = (AboutTheMovie) getActivity();
        Bundle results = activity.getMyData();
        this.uri = results.getString("uri");

        downloadMovie(uri);
        watchMovie(uri);

        return view;
    }

    private void watchMovie(String uri) {

        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity() , WatchMovie.class);
                intent.putExtra("videoURL",uri);
                startActivity(intent);
            }
        });
    }



    private void downloadMovie(String uri) {

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if(getContext().checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                        String [] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permissions , PERMISSION_STORAGE_CODE);
                    }
                    else {
                        startDownloading(uri);
                    }
                }
                else {
                    startDownloading(uri);
                }
            }
        });

    }

    private void startDownloading(String uri) {

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(uri));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);

        String title = URLUtil.guessFileName(uri , null , null);
        request.setTitle(title);
        request.setDescription("Downloading File Please Wait...");

        request.allowScanningByMediaScanner();

        String cookie = CookieManager.getInstance().getCookie(uri);
        request.addRequestHeader("cookie" , cookie);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS , title);

        DownloadManager downloadManager = (DownloadManager) getContext().getSystemService(getContext().DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);

        Toast.makeText(getContext(), "Downloading Started !", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode) {
            case PERMISSION_STORAGE_CODE: {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startDownloading(this.uri);
                }
                else {
                    Toast.makeText(getContext(), "Permission denied...", Toast.LENGTH_SHORT).show();
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
