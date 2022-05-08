package com.example.todoapp.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todoapp.entity.Isler;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface IslerDao {
    @Query("SELECT * FROM isler")
    Single<List<Isler>> tumIsler();

    @Insert
    Completable isEkle(Isler is);

    @Update
    Completable isGuncelle(Isler is);

    @Delete
    Completable isSil(Isler is);

    @Query("SELECT * FROM isler WHERE yapilacak_is like '%' || :aramaKelimesi || '%'")
    Single<List<Isler>> isArama(String aramaKelimesi);
}
