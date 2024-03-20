package org.myprojectofnotes2022.moviemax12.moviesisland20012;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.exoplayer2.util.Util;

public class WatchMovie extends AppCompatActivity {

    private StyledPlayerView playerView;
    private ExoPlayer player;
    private ProgressBar progressBar;
    private int currentWindow = 0;
    private long playBackPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_movie);
        playerView = findViewById(R.id.playerView);
        progressBar = findViewById(R.id.progress_bar_id);
    }
    private void initializePlayer() {
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String url = bundle.getString("videoURL");

            player = new ExoPlayer.Builder(this).build();
            playerView.setPlayer(player);
            MediaItem mediaItem = MediaItem.fromUri(Uri.parse(url));
            player.setMediaItem(mediaItem);
            player.prepare();
            player.setPlayWhenReady(true);
            player.play();
            player.seekTo(currentWindow , playBackPosition);
            playerView.requestFocus();


            player.addListener(new Player.Listener() {
                @Override
                public void onPlaybackStateChanged(int playbackState) {
                    Player.Listener.super.onPlaybackStateChanged(playbackState);
                    if (playbackState == ExoPlayer.STATE_BUFFERING) {
                        progressBar.setVisibility(View.VISIBLE);
                    } else if (playbackState == ExoPlayer.STATE_READY) {
                        progressBar.setVisibility(View.GONE);
                    }
                }
            });
        }
    }

    private void releasePlayer() {
        if(player != null) {
            player.setPlayWhenReady(true);
            playBackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            player.release();
            player = null;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (Util.SDK_INT >= 24) {
            initializePlayer();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (Util.SDK_INT < 24 || player == null) {
            initializePlayer();
            hideSystemUi();
        }
    }

    private void hideSystemUi() {
        playerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LOW_PROFILE |
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION );
    }

    @Override
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT < 24) {
            releasePlayer();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT >= 24) {
            releasePlayer();
        }
    }
}