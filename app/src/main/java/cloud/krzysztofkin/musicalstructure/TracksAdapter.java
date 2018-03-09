package cloud.krzysztofkin.musicalstructure;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Krzysztof Kin on 05.03.2018.
 */

public class TracksAdapter extends ArrayAdapter<Track> {
    private ArrayList<Track> tracksOnList;

    /**
     * Constructor
     *
     * @param context The current context.
     * @param objects The objects to represent in the ListView.
     */
    TracksAdapter(@NonNull Context context, @NonNull ArrayList<Track> objects) {
        super(context, 0, objects);
        tracksOnList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.tracks_item, parent, false);
        }
        final Track track = getItem(position);
        TextView albumName;
        albumName = listItemView.findViewById(R.id.album_title);
        albumName.setText(track.getAlbum());
        TextView trackName;
        trackName = listItemView.findViewById(R.id.track_title);
        trackName.setText(track.getTitle());
        ImageView playButton;
        playButton = listItemView.findViewById(R.id.play_button);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), PlayerActivity.class);
                i.putParcelableArrayListExtra("tracksOnList", tracksOnList);
                i.putExtra("trackToPlay", track);
                getContext().startActivity(i);
            }
        };
        playButton.setOnClickListener(listener);
        return listItemView;
    }
}
