package com.example.assignmentdrawer.ui.shop;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.assignmentdrawer.R;

public class ShopFragment extends Fragment {

    private ShopViewModel shopViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shopViewModel =
                ViewModelProviders.of(this).get(ShopViewModel.class);
        View root = inflater.inflate(R.layout.fragment_shop, container, false);
        final TextView textView = root.findViewById(R.id.text_shop);
        shopViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}