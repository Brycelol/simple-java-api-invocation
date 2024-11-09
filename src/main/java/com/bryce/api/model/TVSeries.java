package com.bryce.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Object to represent a given TV show and it's corresponding metadata.
 *
 * @author Gareth
 */
public class TVSeries {

    private String name;
    @SerializedName("runtime_of_series")
    private String numtimeOfSeries;
    private String certificate;
    @SerializedName("runtime_of_episodes")
    private String numtimeOfEpisodes;
    private String genre;
    @SerializedName("imdb_rating")
    private String imdbRating;
    private String overview;
    @SerializedName("no_of_votes")
    private long numVotes;
    private int id;

    public TVSeries(String name, String numtimeOfSeries, String certificate, String numtimeOfEpisodes, String genre, String imdbRating, String overview, long numVotes, int id) {
        this.name = name;
        this.numtimeOfSeries = numtimeOfSeries;
        this.certificate = certificate;
        this.numtimeOfEpisodes = numtimeOfEpisodes;
        this.genre = genre;
        this.imdbRating = imdbRating;
        this.overview = overview;
        this.numVotes = numVotes;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumtimeOfSeries() {
        return numtimeOfSeries;
    }

    public void setNumtimeOfSeries(String numtimeOfSeries) {
        this.numtimeOfSeries = numtimeOfSeries;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getNumtimeOfEpisodes() {
        return numtimeOfEpisodes;
    }

    public void setNumtimeOfEpisodes(String numtimeOfEpisodes) {
        this.numtimeOfEpisodes = numtimeOfEpisodes;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public long getNumVotes() {
        return numVotes;
    }

    public void setNumVotes(long numVotes) {
        this.numVotes = numVotes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TVSeries tvSeries = (TVSeries) o;
        return numVotes == tvSeries.numVotes && id == tvSeries.id && Objects.equals(name, tvSeries.name) && Objects.equals(numtimeOfSeries, tvSeries.numtimeOfSeries) && Objects.equals(certificate, tvSeries.certificate) && Objects.equals(numtimeOfEpisodes, tvSeries.numtimeOfEpisodes) && Objects.equals(genre, tvSeries.genre) && Objects.equals(imdbRating, tvSeries.imdbRating) && Objects.equals(overview, tvSeries.overview);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numtimeOfSeries, certificate, numtimeOfEpisodes, genre, imdbRating, overview, numVotes, id);
    }

    @Override
    public String toString() {
        return "TVSeries{" +
                "name='" + name + '\'' +
                ", numtimeOfSeries='" + numtimeOfSeries + '\'' +
                ", certificate='" + certificate + '\'' +
                ", numtimeOfEpisodes='" + numtimeOfEpisodes + '\'' +
                ", genre='" + genre + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", overview='" + overview + '\'' +
                ", numVotes=" + numVotes +
                ", id=" + id +
                '}';
    }
}
