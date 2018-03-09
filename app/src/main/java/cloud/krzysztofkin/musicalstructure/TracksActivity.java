package cloud.krzysztofkin.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class TracksActivity extends AppCompatActivity {
    ArrayList<Track> tracksOnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracks_activity);
        Intent i = getIntent();
        String albumName = i.getStringExtra("album");
        tracksOnList = i.getParcelableArrayListExtra("discography");
        TracksAdapter adapter = new TracksAdapter(this, tracksOnList);
        ListView listView = findViewById(R.id.track_list);
        listView.setAdapter(adapter);
    }

    public void goToMain(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void goToPlay(View view) {
        Intent i = new Intent(this, PlayerActivity.class);
        i.putParcelableArrayListExtra("discography", tracksOnList);
        startActivity(i);
    }
}
