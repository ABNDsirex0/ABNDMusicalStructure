package cloud.krzysztofkin.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {
    private ArrayList<Track> tracksOnList;
    private ArrayList<Track> tracksToPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Track track;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Intent i = getIntent();
        tracksOnList = i.getParcelableArrayListExtra("tracksOnList");
        //todo przesylanie 1 utworu do grania i całej listy by można było powrócić (hasextra trackto play)
        if (i.hasExtra("trackToPlay")) {
            track = i.getParcelableExtra("trackToPlay");
            tracksToPlay = new ArrayList<Track>();
            tracksToPlay.add(track);
        } else {
            tracksToPlay = tracksOnList;
        }

    }

    public void goToMain(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void goToTrackList(View view) {
        Intent i = new Intent(this, TracksActivity.class);
        i.putParcelableArrayListExtra("tracksOnList", tracksOnList);
        startActivity(i);
    }
}
