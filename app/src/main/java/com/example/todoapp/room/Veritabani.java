package com.example.todoapp.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.todoapp.entity.Isler;

@Database(entities = {Isler.class},version = 1)
public abstract class Veritabani extends RoomDatabase {
    public abstract IslerDao islerDao();
    public static Veritabani INSTANCE;

    public static Veritabani veritabaniErisim(Context context){
        if(INSTANCE == null){
            synchronized (Veritabani.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        Veritabani.class,"isler.sqlite")
                        .createFromAsset("isler.sqlite")
                        .build();
            }
        }
        return INSTANCE;
    }
}
