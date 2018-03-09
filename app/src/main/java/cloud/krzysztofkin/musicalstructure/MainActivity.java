package cloud.krzysztofkin.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    Tracks discography;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create discography with sample data
        discography = new Tracks();
        discography.addSampleData(21, 5);
        MainAdapter adapter = new MainAdapter(this, discography);
        GridView listView = findViewById(R.id.album_list);
        listView.setAdapter(adapter);
    }

    /**
     * After click track list label starts TracksActivity
     * onclick defined in layout
     * @param view view clicked
     */
    public void goToTrackList(View view) {
        Intent i = new Intent(this,TracksActivity.class);
        i.putParcelableArrayListExtra("tracksOnList", discography);
        startActivity(i);
    }

    /**
     * After click "play all" label starts PlayerActivity
     * onclick defined in layout
     * @param view view clicked
     */
    public void goToPlay(View view) {
        Intent i = new Intent(this,PlayerActivity.class);
        i.putParcelableArrayListExtra("tracksOnList", discography);
        startActivity(i);
    }
}
