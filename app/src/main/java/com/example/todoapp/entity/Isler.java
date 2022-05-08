package com.example.todoapp.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "isler")
public class Isler implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "yapilacakis_id")
    @NonNull
    private int yapilicakis_id;
    @ColumnInfo(name = "yapilacak_is")
    @NonNull
    private String yapilacak_is;

    public Isler() {
    }

    public Isler(int yapilicakis_id, String yapilacak_is) {
        this.yapilicakis_id = yapilicakis_id;
        this.yapilacak_is = yapilacak_is;
    }

    public int getYapilicakis_id() {
        return yapilicakis_id;
    }

    public void setYapilicakis_id(int yapilicakis_id) {
        this.yapilicakis_id = yapilicakis_id;
    }

    public String getYapilacak_is() {
        return yapilacak_is;
    }

    public void setYapilacak_is(String yapilacak_is) {
        this.yapilacak_is = yapilacak_is;
    }
}
