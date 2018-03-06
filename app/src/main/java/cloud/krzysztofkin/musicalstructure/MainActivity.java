package cloud.krzysztofkin.musicalstructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Tracks discography;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create discography with sample data
        discography = new Tracks();
        discography.addSampleData(21, 5, 3);
        AlbumAdapter adapter = new AlbumAdapter(this, discography);
        GridView listView = findViewById(R.id.album_list);
        listView.setAdapter(adapter);
    }
}
