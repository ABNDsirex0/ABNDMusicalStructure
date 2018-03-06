package cloud.krzysztofkin.musicalstructure;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Krzysztof Kin on 05.03.2018.
 */

public class AlbumAdapter extends ArrayAdapter<Track> {
    /**
     * Constructor
     *
     * @param context The current context.
     * @param objects The objects to represent in the ListView.
     */
    AlbumAdapter(@NonNull Context context, @NonNull Tracks objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.album_item, parent, false);
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
                Log.i("Listener",currentAlbum.getAlbum());
            }
        };
        albumCover.setOnClickListener(listener);
        albumName.setOnClickListener(listener);

        return listItemView;
    }
}
