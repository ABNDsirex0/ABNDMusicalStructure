package cloud.krzysztofkin.musicalstructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Tracks discography;
    Tracks albums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create discography with sample data
        discography = new Tracks(21, 5, 3);
        //create list of albums
        albums = discography.getAlbums();
        for (Track a : albums) {
            Log.v("Main activity albums:", a.toString());
        }
        AlbumAdapter adapter = new AlbumAdapter(this, albums);
        GridView listView = (GridView) findViewById(R.id.album_list);
        listView.setAdapter(adapter);
    }
}
