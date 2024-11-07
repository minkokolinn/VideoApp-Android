package com.example.admin.videoapp.models;

import java.util.List;

/**
 * Created by Admin on 9/14/2018.
 */

public class Video
{
    private String total;

    private List<Hits> hits;

    private String totalHits;

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public List<Hits> getHits ()
    {
        return hits;
    }

    public void setHits (List<Hits> hits)
    {
        this.hits = hits;
    }

    public String getTotalHits ()
    {
        return totalHits;
    }

    public void setTotalHits (String totalHits)
    {
        this.totalHits = totalHits;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [total = "+total+", hits = "+hits+", totalHits = "+totalHits+"]";
    }
}