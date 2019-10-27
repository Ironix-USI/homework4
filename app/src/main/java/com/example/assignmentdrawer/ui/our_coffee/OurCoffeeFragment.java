package com.example.assignmentdrawer.ui.our_coffee;

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

public class OurCoffeeFragment extends Fragment {

    private OurCoffeeViewModel ourCoffeeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ourCoffeeViewModel =
                ViewModelProviders.of(this).get(OurCoffeeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_our_coffee, container, false);
        final TextView textView = root.findViewById(R.id.text_our_coffee);
        ourCoffeeViewModel.getText().observe(this, new Observer<String>() {
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