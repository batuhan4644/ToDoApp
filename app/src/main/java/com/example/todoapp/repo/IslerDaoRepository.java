package com.example.todoapp.repo;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.todoapp.entity.Isler;
import com.example.todoapp.room.Veritabani;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class IslerDaoRepository {
    private MutableLiveData<List<Isler>> islerListesi;
    private Veritabani vt ;

    public IslerDaoRepository(Application application) {
        islerListesi = new MutableLiveData();
        vt = Veritabani.veritabaniErisim(application);
    }
    public  MutableLiveData<List<Isler>> isleriGetir(){
        return islerListesi;
    }

    public void isKayit(String yapilacak_is){
        Isler yeniIs = new Isler(0,yapilacak_is);
        vt.islerDao().isEkle(yeniIs)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onComplete() {
                        Log.e("Yapılacak İş Kayıt","Başarılı");
                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void isGuncelle(int yapilacakis_id, String yapilacak_is){
        Isler guncellenenIs = new Isler(yapilacakis_id,yapilacak_is);
        vt.islerDao().isGuncelle(guncellenenIs)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onComplete() {
                        Log.e("Yapılacak İş Güncelleme","Başarılı");
                    }

                    @Override
                    public void onError(Throwable e) {}
                });

    }


    public void isAra(String aramaKelimesi){
        Disposable disposable = vt.islerDao().isArama(aramaKelimesi)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(liste -> {
                    islerListesi.setValue(liste);
                });
    }

    public void isSil(int yapilacakis_id){
        Isler silinenIs = new Isler(yapilacakis_id,"");
        vt.islerDao().isSil(silinenIs)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onComplete() {
                        Log.e("Yapılacak İş Silme","Başarılı");
                        tumIsleriAl();
                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void tumIsleriAl(){
        Disposable disposable = vt.islerDao().tumIsler()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(liste -> {
                     islerListesi.setValue(liste);
                });

    }
}
