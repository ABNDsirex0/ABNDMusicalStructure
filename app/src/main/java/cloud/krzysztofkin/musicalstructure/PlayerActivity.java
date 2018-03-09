package cloud.krzysztofkin.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {
    private ArrayList<Track> tracksOnList;
    private ArrayList<Track> tracksToPlay;
    int currentTrack;
    TextView albumTitle;
    TextView trackTitle;
    TextView counter;
    ProgressBar progressBar;
    ImageView albumCover;
    Button albumButton;
    Button tracksButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Track track;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Intent i = getIntent();
        tracksOnList = i.getParcelableArrayListExtra("tracksOnList");
        if (i.hasExtra("trackToPlay")) {
            track = i.getParcelableExtra("trackToPlay");
            tracksToPlay = new ArrayList<>();
            tracksToPlay.add(track);
        } else {
            tracksToPlay = tracksOnList;
        }
        albumTitle = findViewById(R.id.album_title);
        trackTitle = findViewById(R.id.track_title);
        counter = findViewById(R.id.counter);
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setMax(tracksToPlay.size());
        albumCover = findViewById(R.id.album_cover);
        albumButton = findViewById(R.id.album_button);
        tracksButton = findViewById(R.id.tracks_button);
        albumButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlayerActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        tracksButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlayerActivity.this, TracksActivity.class);
                i.putParcelableArrayListExtra("tracksOnList", tracksOnList);
                startActivity(i);
            }
        });
        refreschPlayer();
    }

    public void onPrevious(View view) {
        if (currentTrack > 0) {
            --currentTrack;
        }
        refreschPlayer();
    }

    public void onPlay(View view) {
        String textToToast;
        textToToast = "Alphabet/" + tracksToPlay.get(currentTrack).getAlbum() + "/" + tracksToPlay.get(currentTrack).getTitle();
        Toast.makeText(this, textToToast, Toast.LENGTH_SHORT).show();
    }

    public void onNext(View view) {
        if (currentTrack < tracksToPlay.size() - 1) {
            ++currentTrack;
        }
        refreschPlayer();
    }

    private void refreschPlayer() {
        int coverId = getResources().getIdentifier(tracksToPlay.get(currentTrack).getCover(), "drawable", getPackageName());
        albumCover.setImageResource(coverId);
        albumTitle.setText(tracksToPlay.get(currentTrack).getAlbum());
        trackTitle.setText((tracksToPlay.get(currentTrack).getTitle()));
        counter.setText(currentTrack + 1 + "/" + tracksToPlay.size());
        progressBar.setProgress(currentTrack + 1);
    }
}
