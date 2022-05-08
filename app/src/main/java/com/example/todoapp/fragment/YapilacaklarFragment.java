package com.example.todoapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.todoapp.R;
import com.example.todoapp.adapter.IslerAdapter;
import com.example.todoapp.databinding.FragmentYapilacaklarBinding;
import com.example.todoapp.entity.Isler;
import com.example.todoapp.viewmodel.YapilacaklarFragmentViewModel;
import com.example.todoapp.viewmodel.YapilacaklarVMF;

import java.util.ArrayList;

public class YapilacaklarFragment extends Fragment implements SearchView.OnQueryTextListener {
    private FragmentYapilacaklarBinding tasarim;
    private YapilacaklarFragmentViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yapilacaklar, container, false);
        tasarim.setYapilacaklarFragment(this);
        tasarim.setYapilacaklarToolbarBaslik("Yapılacaklar");
        ((AppCompatActivity)getActivity()).setSupportActionBar(tasarim.toolbarYapilacaklar);


       viewModel.islerListesi.observe(getViewLifecycleOwner(),liste -> {
           IslerAdapter adapter = new IslerAdapter(requireContext(),liste,viewModel);
           tasarim.setIslerAdapter(adapter);
       });



        return tasarim.getRoot();
    }
    public void fabTikla(View view){
        Navigation.findNavController(view).navigate(R.id.yapilacakIsKayitGecis);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        viewModel = new ViewModelProvider(this,
                new YapilacaklarVMF(requireActivity().getApplication())).get(YapilacaklarFragmentViewModel.class);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu,menu);

        MenuItem item = menu.findItem(R.id.action_ara);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);

        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        viewModel.ara(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        viewModel.ara(newText);
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.isleriYukle();
    }
}