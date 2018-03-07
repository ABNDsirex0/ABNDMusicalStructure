package cloud.krzysztofkin.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class TracksOnAlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Tracks discography = new Tracks();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        Intent i = getIntent();
        String albumName = i.getStringExtra("album");
        Log.v("TracksOnAlbumActivity","I'm on "+albumName);
        ArrayList<Track> arrayListFromIntent = i.getParcelableArrayListExtra("discography");
        for(Track track:arrayListFromIntent)
            discography.add(track);
        for(Track track:discography.getTracksFromAlbum(albumName))
            Log.i("TracksOnAlbum",track.getTitle());
    }
}
