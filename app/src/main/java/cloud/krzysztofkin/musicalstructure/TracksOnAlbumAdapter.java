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

/**
 * Created by Krzysztof Kin on 05.03.2018.
 */

public class TracksOnAlbumAdapter extends ArrayAdapter<Track> {
    //Tracks discography;

    /**
     * Constructor
     *
     * @param context The current context.
     * @param objects The objects to represent in the ListView.
     */
    TracksOnAlbumAdapter(@NonNull Context context, @NonNull Tracks objects) {
        super(context, 0, objects);
        // discography = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.track_on_album_item, parent, false);
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
                Intent i = new Intent(getContext(), player.class);
                //i.putParcelableArrayListExtra("discography",discography);
                //i.putExtra("album",track.getAlbum());
                getContext().startActivity(i);
            }
        };

        playButton.setOnClickListener(listener);
        return listItemView;
    }
}
