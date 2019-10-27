package com.example.assignmentdrawer.ui.beans;

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
import com.google.android.material.navigation.NavigationView;

public class BeansFragment extends Fragment {

    private BeansViewModel beansViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        beansViewModel =
                ViewModelProviders.of(this).get(BeansViewModel.class);
        View root = inflater.inflate(R.layout.fragment_beans, container, false);
        final TextView textView = root.findViewById(R.id.text_beans);
        beansViewModel.getText().observe(this, new Observer<String>() {
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
