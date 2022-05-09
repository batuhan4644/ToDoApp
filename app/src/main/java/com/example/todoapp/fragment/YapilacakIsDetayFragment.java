package com.example.todoapp.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todoapp.R;
import com.example.todoapp.databinding.FragmentYapilacakIsDetayBinding;
import com.example.todoapp.entity.Isler;
import com.example.todoapp.viewmodel.YapilacakIsDetayFragmentViewModel;
import com.example.todoapp.viewmodel.YapilacakIsDetayVMF;


public class YapilacakIsDetayFragment extends Fragment {
    private FragmentYapilacakIsDetayBinding tasarim;
    private YapilacakIsDetayFragmentViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yapilacak_is_detay, container, false);
        tasarim.setYapilacakIsDetayFragment(this);
        tasarim.setYapilacakIsDetayToolbarBaslik("Yapılacak İş Detay");

        YapilacakIsDetayFragmentArgs bundle = YapilacakIsDetayFragmentArgs.fromBundle(getArguments());
        Isler gelenIs = bundle.getIs();
        tasarim.setYapilacakIsNesnesi(gelenIs);

        return tasarim.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this,
                new YapilacakIsDetayVMF(requireActivity().getApplication())).get(YapilacakIsDetayFragmentViewModel.class);
    }

    public void buttonGuncelle(int yapilicakis_id, String yapilacak_is){
        viewModel.guncelle(yapilicakis_id, yapilacak_is);
    }
}