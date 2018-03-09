package cloud.krzysztofkin.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    Button tracksButton;
    Button playButton;
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
        tracksButton = findViewById(R.id.tracks_button);
        tracksButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TracksActivity.class);
                i.putParcelableArrayListExtra("tracksOnList", discography);
                startActivity(i);
            }
        });
        playButton = findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PlayerActivity.class);
                i.putParcelableArrayListExtra("tracksOnList", discography);
                startActivity(i);
            }
        });
    }
}
