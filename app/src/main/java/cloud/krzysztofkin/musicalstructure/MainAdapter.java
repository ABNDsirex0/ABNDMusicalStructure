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

public class MainAdapter extends ArrayAdapter<Track> {
    Tracks discography;

    /**
     * Constructor
     *
     * @param context The current context.
     * @param objects The objects to represent in the ListView.
     */
    MainAdapter(@NonNull Context context, @NonNull Tracks objects) {
        super(context, 0, objects.getAlbums());
        discography = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.main_item, parent, false);
        }
        final Track currentAlbum = getItem(position);
        TextView albumName;
        albumName = listItemView.findViewById(R.id.album_name);
        albumName.setText(currentAlbum.getAlbum());
        ImageView albumCover;
        albumCover = listItemView.findViewById(R.id.album_cover);
        int coverId = parent.getResources().getIdentifier(currentAlbum.getCover(), "drawable", getContext().getPackageName());
        albumCover.setImageResource(coverId);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TracksActivity.class);
                i.putParcelableArrayListExtra("discography", discography);
                i.putExtra("album", currentAlbum.getAlbum());
                getContext().startActivity(i);
            }
        };
        albumCover.setOnClickListener(listener);
        albumName.setOnClickListener(listener);
        return listItemView;
    }
}
