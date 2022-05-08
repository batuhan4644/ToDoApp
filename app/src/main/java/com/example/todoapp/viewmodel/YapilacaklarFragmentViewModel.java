package com.example.todoapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.todoapp.entity.Isler;
import com.example.todoapp.repo.IslerDaoRepository;

import java.util.List;

public class YapilacaklarFragmentViewModel extends AndroidViewModel {
    private IslerDaoRepository krepo;
    public MutableLiveData<List<Isler>> islerListesi = new MutableLiveData<>();

    public YapilacaklarFragmentViewModel(@NonNull Application application) {
        super(application);
        krepo = new IslerDaoRepository(application);
        isleriYukle();
        islerListesi = krepo.isleriGetir();

    }


    public void ara(String aramaKelimesi){ krepo.isAra(aramaKelimesi); }

    public void sil(int yapilicakis_id ){
        krepo.isSil(yapilicakis_id);
    }
    public void isleriYukle(){
        krepo.tumIsleriAl();
    }
}
