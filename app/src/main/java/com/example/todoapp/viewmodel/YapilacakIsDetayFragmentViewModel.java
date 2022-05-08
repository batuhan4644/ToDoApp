package com.example.todoapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.todoapp.repo.IslerDaoRepository;

public class YapilacakIsDetayFragmentViewModel extends AndroidViewModel {
    private IslerDaoRepository krepo ;

    public YapilacakIsDetayFragmentViewModel(@NonNull Application application) {
        super(application);
        krepo = new IslerDaoRepository(application);
    }

    public void guncelle(int yapilicakis_id, String yapilacak_is){
        krepo.isGuncelle(yapilicakis_id,yapilacak_is);
    }
}
