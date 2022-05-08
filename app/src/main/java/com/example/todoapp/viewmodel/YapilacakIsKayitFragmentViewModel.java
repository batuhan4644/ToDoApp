package com.example.todoapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.todoapp.repo.IslerDaoRepository;

public class YapilacakIsKayitFragmentViewModel extends AndroidViewModel {

    private IslerDaoRepository krepo ;

    public YapilacakIsKayitFragmentViewModel(@NonNull Application application) {
        super(application);
        krepo = new IslerDaoRepository(application);
    }

    public void kayit(String yapilacak_is){krepo.isKayit(yapilacak_is);}
}
