package cloud.krzysztofkin.musicalstructure;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Krzysztof Kin on 05.03.2018.
 */

public class Track implements Parcelable {
    String album;
    String title;
    String cover;

    public Track(String album, String title, String cover) {
        this.album = album;
        this.title = title;
        this.cover = cover;
    }

    public String getAlbum() {
        return album;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return (album + " " + title);
    }

    //Parceling part

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(album);
        dest.writeString(title);
        dest.writeString(cover);
    }

    public static final Parcelable.Creator<Track> CREATOR
            = new Parcelable.Creator<Track>() {
        public Track createFromParcel(Parcel in) {
            return new Track(in);
        }

        public Track[] newArray(int size) {
            return new Track[size];
        }
    };

    private Track(Parcel in) {
        album = in.readString();
        title = in.readString();
        cover = in.readString();
    }

    public String getCover() {
        return cover;
    }
}
