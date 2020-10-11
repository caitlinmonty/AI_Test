package com.example.ai_test.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ai_test.R;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.textView);
        final TextView pointsTxt = root.findViewById(R.id.textView3);
        final TextView redeemTxt = root.findViewById(R.id.textView4);
        final ImageView points = (ImageView) root.findViewById(R.id.points);
        final Button button = (Button) root.findViewById(R.id.button);
        final Button helpButton = (Button) root.findViewById(R.id.helpButton);
        final Button aboutButton = (Button) root.findViewById(R.id.aboutButton);
        final ImageView logged = (ImageView) root.findViewById(R.id.rewards);
        final ImageView logged2 = (ImageView) root.findViewById(R.id.rewards2);
        logged.setVisibility(View.INVISIBLE);
        logged2.setVisibility(View.INVISIBLE);
        redeemTxt.setVisibility(View.INVISIBLE);
        logged.bringToFront();

        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                button.setVisibility(View.INVISIBLE);
                points.setVisibility(View.INVISIBLE);
                pointsTxt.setVisibility(View.INVISIBLE);
                helpButton.setVisibility(View.INVISIBLE);
                aboutButton.setVisibility(View.INVISIBLE);
                logged.setVisibility(View.VISIBLE);
                logged2.setVisibility(View.VISIBLE);
                redeemTxt.setVisibility(View.VISIBLE);
            }
        });

        return root;
    }
}
