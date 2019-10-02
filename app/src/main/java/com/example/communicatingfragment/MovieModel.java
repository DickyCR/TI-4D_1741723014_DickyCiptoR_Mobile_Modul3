package com.example.communicatingfragment;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieModel implements Parcelable {

    String judul;
    int poster;
    String genre;
    String ratingScore;
    String sinopsis;

    public MovieModel(String judul, int poster, String genre, String ratingScore, String sinopsis){
        this.judul= judul;
        this.poster= poster;
        this.genre=genre;
        this.ratingScore=ratingScore;
        this.sinopsis=sinopsis;
    }


    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    public String getJudul(){ return judul;}

    public int getPoster() {
        return poster;
    }

    public String getGenre() {
        return genre;
    }

    public String getRatingScore() {
        return ratingScore;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.judul);
    dest.writeInt(this.poster);
    dest.writeString(this.genre);
    dest.writeString(this.ratingScore);
    dest.writeString(this.sinopsis);
    }

    protected MovieModel(Parcel in){
        this.judul = in.readString();
        this.poster = in.readInt();
        this.genre = in.readString();
        this.ratingScore = in.readString();
        this.sinopsis = in.readString();
    }


}
