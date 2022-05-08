package com.example.todoapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoapp.R;
import com.example.todoapp.databinding.CardTasarimBinding;
import com.example.todoapp.entity.Isler;
import com.example.todoapp.fragment.YapilacakIsDetayFragment;
import com.example.todoapp.fragment.YapilacakIsKayitFragment;
import com.example.todoapp.fragment.YapilacaklarFragment;
import com.example.todoapp.fragment.YapilacaklarFragmentDirections;
import com.example.todoapp.viewmodel.YapilacaklarFragmentViewModel;
import com.google.android.material.snackbar.Snackbar;


import java.util.List;

public class IslerAdapter extends RecyclerView.Adapter<IslerAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Isler> islerListesi;
    private YapilacaklarFragmentViewModel viewModel;

    public IslerAdapter(Context mContext, List<Isler> islerListesi, YapilacaklarFragmentViewModel viewModel) {
        this.mContext = mContext;
        this.islerListesi = islerListesi;
        this.viewModel = viewModel;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{

            private CardTasarimBinding tasarim;

            public CardTasarimTutucu(CardTasarimBinding tasarim) {
                super(tasarim.getRoot());
                this.tasarim = tasarim;
            }
        }
    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardTasarimBinding tasarim= DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim, parent, false);
        return new CardTasarimTutucu(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Isler is = islerListesi.get(position);
        CardTasarimBinding t = holder.tasarim;

        t.setYapilacakIsNesnesi(is);
        t.satirCard.setOnClickListener(view -> {
            YapilacaklarFragmentDirections.YapilacakIsDetayGecis gecis = YapilacaklarFragmentDirections.yapilacakIsDetayGecis(is);
             Navigation.findNavController(view).navigate(gecis);

        });
        t.imageViewSilResim.setOnClickListener(view -> {
            Snackbar.make(view,is.getYapilacak_is()+" silinsin mi?",Snackbar.LENGTH_LONG)
                    .setAction("Evet",v1 -> {
                        viewModel.sil(is.getYapilicakis_id());
                    } ).show();
        });
    }

    @Override
    public int getItemCount() {
        return islerListesi.size();
    }
}
