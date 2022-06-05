package com.example.projetointegrador_4.ui.contato;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projetointegrador_4.R;
import com.example.projetointegrador_4.databinding.ContatoFragmentBinding;
import com.example.projetointegrador_4.databinding.FragmentGalleryBinding;
import com.example.projetointegrador_4.ui.gallery.GalleryViewModel;

public class ContatoFragment extends Fragment {

    private ContatoFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ContatoViewModel contatoViewModel =
                new ViewModelProvider(this).get(ContatoViewModel.class);

        binding = ContatoFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.TextView;
//        ContatoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}