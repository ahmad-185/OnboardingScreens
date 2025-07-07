package com.example.onboarding;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment2 extends Fragment {

    EditText editName, editEmail, editUniversity;
    Button btnContinue;

    OnDataPass dataPasser;

    public interface OnDataPass {
        void onDataPass(String name, String email, String university);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDataPass) {
            dataPasser = (OnDataPass) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnDataPass interface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        editName = view.findViewById(R.id.editName);
        editEmail = view.findViewById(R.id.editEmail);
        editUniversity = view.findViewById(R.id.editUniversity);
        btnContinue = view.findViewById(R.id.btnContinue);

        btnContinue.setOnClickListener(v -> {
            String name = editName.getText().toString();
            String email = editEmail.getText().toString();
            String university = editUniversity.getText().toString();

            dataPasser.onDataPass(name, email, university);
        });

        return view;
    }
}