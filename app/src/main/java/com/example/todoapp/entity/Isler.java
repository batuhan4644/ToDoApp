package com.example.todoapp.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "isler")
public class Isler implements Serializable  {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "yapilacakis_id")
    @NonNull
    private int yapilacakis_id;
    @ColumnInfo(name = "yapilacak_is")
    @NonNull
    private String yapilacak_is;



    public Isler() {
    }

    public Isler(int yapilacakis_id, String yapilacak_is) {
        this.yapilacakis_id = yapilacakis_id;
        this.yapilacak_is = yapilacak_is;

    }

    public int getYapilacakis_id() {
        return yapilacakis_id;
    }

    public void setYapilacakis_id(int yapilacakis_id) {
        this.yapilacakis_id = yapilacakis_id;
    }

    public String getYapilacak_is() {
        return yapilacak_is;
    }

    public void setYapilacak_is(String yapilacak_is) {
        this.yapilacak_is = yapilacak_is;
    }


}

