package cloud.krzysztofkin.musicalstructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        AlbumsAdapter adapter = new AlbumsAdapter(this, discography);
        GridView listView = findViewById(R.id.album_list);
        listView.setAdapter(adapter);
    }
}
