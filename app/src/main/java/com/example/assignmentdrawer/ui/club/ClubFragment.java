package com.example.assignmentdrawer.ui.club;

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

public class ClubFragment extends Fragment {

    private ClubViewModel clubViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        clubViewModel =
                ViewModelProviders.of(this).get(ClubViewModel.class);
        View root = inflater.inflate(R.layout.fragment_club, container, false);
        final TextView textView = root.findViewById(R.id.text_club);
        clubViewModel.getText().observe(this, new Observer<String>() {
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