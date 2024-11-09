package com.bryce.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Simple POJO to define a paged result of TV series.
 */
public class TVSeriesPage {

    private int page;

    @SerializedName("per_page")
    private int perPage;
    private int total;

    @SerializedName("total_pages")
    private int totalPages;

    private List<TVSeries> data;

    public TVSeriesPage(int page, int perPage, int total, int totalPages, List<TVSeries> data) {
        this.page = page;
        this.perPage = perPage;
        this.total = total;
        this.totalPages = totalPages;
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<TVSeries> getData() {
        return data;
    }

    public void setData(List<TVSeries> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TVSeriesPage that = (TVSeriesPage) o;
        return page == that.page && perPage == that.perPage && total == that.total && totalPages == that.totalPages && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, perPage, total, totalPages, data);
    }

    @Override
    public String toString() {
        return "TVSeriesPage{" +
                "page=" + page +
                ", perPage=" + perPage +
                ", total=" + total +
                ", totalPages=" + totalPages +
                ", data=" + data +
                '}';
    }
}
