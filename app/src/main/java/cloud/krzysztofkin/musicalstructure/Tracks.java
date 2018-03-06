package cloud.krzysztofkin.musicalstructure;

import java.util.ArrayList;

/**
 * Created by Krzysztof Kin on 05.03.2018.
 */

public class Tracks extends ArrayList<Track> {
    /**
     * Constructs an empty list.
     */
    public Tracks() {
        super();
    }

    /**
     * Constructs list with sample data.
     *
     * @param albums
     * @param tracks
     * @param covers
     */
    public Tracks(int albums, int tracks, int covers) {
        for (int a = 1; a <= albums; a++) {
            for (int t = 1; t <= tracks; t++) {
                add(new Track("Album " + a, "track " + t, "ic_vinyl_red"));
            }
        }
    }

    /**
     * chooses one track from each album
     *
     * @return list of tracks one by album
     */
    public Tracks getAlbums() {
        Tracks albums = new Tracks();
        albums.add(get(0));
        boolean onList;
        for (int d = 0; d < size(); d++) {
            onList = false;
            for (Track a : albums) {
                if (get(d).getAlbum().equals(a.getAlbum())) {
                    onList = true;
                    break;
                }
            }
            if (!onList) {
                albums.add(get(d));
            }
        }
        return albums;
    }
}
