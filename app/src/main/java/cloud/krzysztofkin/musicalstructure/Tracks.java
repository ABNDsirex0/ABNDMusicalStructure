package cloud.krzysztofkin.musicalstructure;

import java.util.ArrayList;

/**
 * Created by Krzysztof Kin on 05.03.2018.
 * class to store tracks as arraylist
 */

class Tracks extends ArrayList<Track> {

    /**
     * Constructs an empty list.
     */
    public Tracks() {
        super();
    }

    /**
     * adds sample data.
     *
     * @param albums quantity
     * @param tracks quantity
     */
    void addSampleData(int albums, int tracks) {
        String[] coversList = {"ic_vinyl_blue", "ic_vinyl_pink", "ic_vinyl_cyan", "ic_vinyl_green", "ic_vinyl_magenta", "ic_vinyl_red", "ic_vinyl_yellow"};
        int coverNr = 0;
        for (int a = 1; a <= albums; a++) {
            for (int t = 1; t <= tracks; t++) {
                add(new Track("Album " + a, "track " + a + "." + t, coversList[coverNr]));
            }
            coverNr++;
            if (coverNr >= coversList.length) {
                coverNr = 0;
            }
        }
    }

    /**
     * chooses one track from each album
     *
     * @return list of tracks - one by album
     */
    Tracks getAlbums() {
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

    /**
     * get all tracks from album given as parameter
     *
     * @param album album title
     * @return list of tracks on album
     */
    Tracks getTracksFromAlbum(String album) {
        if (album.equals(""))
            return this;
        Tracks tracks = new Tracks();
        for (int a = 0; a < size(); a++) {
            if (get(a).getAlbum().equals(album))
                tracks.add(get(a));
        }
        return tracks;
    }
}
