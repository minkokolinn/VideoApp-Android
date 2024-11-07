package com.example.admin.videoapp.models;

public class Hits
{
    private String tags;

    private Videos videos;

    private String favorites;

    private String type;

    private String downloads;

    private String pageURL;

    private String userImageURL;

    private String id;

    private String duration;

    private String views;

    private String likes;

    private String picture_id;

    private String user_id;

    private String user;

    private String comments;

    public String getTags ()
    {
        return tags;
    }

    public void setTags (String tags)
    {
        this.tags = tags;
    }

    public Videos getVideos ()
    {
        return videos;
    }

    public void setVideos (Videos videos)
    {
        this.videos = videos;
    }

    public String getFavorites ()
    {
        return favorites;
    }

    public void setFavorites (String favorites)
    {
        this.favorites = favorites;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getDownloads ()
    {
        return downloads;
    }

    public void setDownloads (String downloads)
    {
        this.downloads = downloads;
    }

    public String getPageURL ()
    {
        return pageURL;
    }

    public void setPageURL (String pageURL)
    {
        this.pageURL = pageURL;
    }

    public String getUserImageURL ()
    {
        return userImageURL;
    }

    public void setUserImageURL (String userImageURL)
    {
        this.userImageURL = userImageURL;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getViews ()
    {
        return views;
    }

    public void setViews (String views)
    {
        this.views = views;
    }

    public String getLikes ()
    {
        return likes;
    }

    public void setLikes (String likes)
    {
        this.likes = likes;
    }

    public String getPicture_id ()
    {
        return picture_id;
    }

    public void setPicture_id (String picture_id)
    {
        this.picture_id = picture_id;
    }

    public String getUser_id ()
    {
        return user_id;
    }

    public void setUser_id (String user_id)
    {
        this.user_id = user_id;
    }

    public String getUser ()
    {
        return user;
    }

    public void setUser (String user)
    {
        this.user = user;
    }

    public String getComments ()
    {
        return comments;
    }

    public void setComments (String comments)
    {
        this.comments = comments;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [tags = "+tags+", videos = "+videos+", favorites = "+favorites+", type = "+type+", downloads = "+downloads+", pageURL = "+pageURL+", userImageURL = "+userImageURL+", id = "+id+", duration = "+duration+", views = "+views+", likes = "+likes+", picture_id = "+picture_id+", user_id = "+user_id+", user = "+user+", comments = "+comments+"]";
    }
}

	