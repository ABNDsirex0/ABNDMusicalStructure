package cloud.krzysztofkin.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class TracksOnAlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Tracks discography = new Tracks();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracks_on_album_activity);
        Intent i = getIntent();
        String albumName = i.getStringExtra("album");
        Log.v("TracksOnAlbumActivity","I'm on "+albumName);
        ArrayList<Track> arrayListFromIntent = i.getParcelableArrayListExtra("discography");
        for(Track track:arrayListFromIntent)
            discography.add(track);

        TracksOnAlbumAdapter adapter = new TracksOnAlbumAdapter(this, discography.getTracksFromAlbum(albumName));
        ListView listView = findViewById(R.id.track_list);
        listView.setAdapter(adapter);


/*        for(Track track:discography.getTracksFromAlbum(albumName))
            Log.i("TracksOnAlbum",track.getTitle());*/
    }
}
