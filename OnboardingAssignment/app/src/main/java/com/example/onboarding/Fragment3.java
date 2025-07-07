package com.example.onboarding;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Fragment3 extends Fragment {

    CheckBox checkBox;
    Button btnAction;
    TextView textWelcome;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);

        checkBox = view.findViewById(R.id.checkBox);
        btnAction = view.findViewById(R.id.btnAction);
        textWelcome = view.findViewById(R.id.textWelcome);

        btnAction.setEnabled(false);

        Bundle args = getArguments();
        if (args != null) {
            String name = args.getString("name", "");
            textWelcome.setText("مرحبًا " + name + "!");
        }

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            btnAction.setEnabled(isChecked);
            btnAction.setText(isChecked ? "إنهاء" : "متابعة");
        });

        return view;
    }
}