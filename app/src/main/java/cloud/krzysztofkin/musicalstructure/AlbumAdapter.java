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

public class AlbumAdapter extends ArrayAdapter<Track> {
    private Tracks discography;

    /**
     * Constructor
     *
     * @param context The current context.
     * @param objects The objects to represent in the ListView.
     */
    AlbumAdapter(@NonNull Context context, @NonNull Tracks objects) {
        super(context, 0, objects.getAlbums());
        discography = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View gridItemView = convertView;
        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(R.layout.album_item, parent, false);
        }
        final Track currentAlbum = getItem(position);
        TextView albumNameTextView;
        albumNameTextView = gridItemView.findViewById(R.id.album_name);
        albumNameTextView.setText(currentAlbum.getAlbum());
        ImageView albumCoverImageView;
        albumCoverImageView = gridItemView.findViewById(R.id.album_cover);
        int coverId = parent.getResources().getIdentifier(currentAlbum.getCover(), "drawable", getContext().getPackageName());
        albumCoverImageView.setImageResource(coverId);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tracksIntent = new Intent(getContext(), TracksActivity.class);
                tracksIntent.putParcelableArrayListExtra("tracksOnList", discography.getTracksFromAlbum(currentAlbum.getAlbum()));
                getContext().startActivity(tracksIntent);
            }
        };
        albumCoverImageView.setOnClickListener(listener);
        albumNameTextView.setOnClickListener(listener);
        return gridItemView;
    }
}
