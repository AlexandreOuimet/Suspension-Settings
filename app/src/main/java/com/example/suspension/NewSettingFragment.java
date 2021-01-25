package com.example.suspension;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suspension.database.DataModel;
import com.example.suspension.database.DatabaseHelper;


public class NewSettingFragment extends Fragment implements View.OnClickListener {

    private String settingsName;
    private EditText settingNameEditText;
    private TextView forkReboundTxtView;
    private TextView forkCompressionTxtView;
    private TextView shockReboundTxtView;
    private TextView shockLowCompTxtView;
    private TextView shockHighCompTxtView;


    public NewSettingFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_setting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        settingNameEditText = view.findViewById(R.id.setup_name_edit_text);
        forkReboundTxtView = view.findViewById(R.id.fork_rebound_txt);
        forkCompressionTxtView = view.findViewById(R.id.fork_compression_txt);
        shockReboundTxtView = view.findViewById(R.id.shock_rebound_txt);
        shockLowCompTxtView = view.findViewById(R.id.shock_low_comp_txt);
        shockHighCompTxtView = view.findViewById(R.id.shock_high_comp_txt);

        initiateButtons(view);
    }

    private void initiateButtons(View view){
        Button save_btn = view.findViewById(R.id.save_button);
        Button forkReboundPlus = view.findViewById(R.id.fork_rebound_plus);
        Button forkReboundMinus = view.findViewById(R.id.fork_rebound_minus);
        Button forkCompressionPlus = view.findViewById(R.id.fork_compression_plus);
        Button forkCompressionMinus = view.findViewById(R.id.fork_compression_minus);
        Button shockReboundPlus = view.findViewById(R.id.shock_rebound_plus);
        Button shockReboundMinus = view.findViewById(R.id.shock_rebound_minus);
        Button shockLowCompPlus = view.findViewById(R.id.shock_low_comp_plus);
        Button shockLowCompMinus = view.findViewById(R.id.shock_low_comp_minus);
        Button shockHighCompPlus = view.findViewById(R.id.shock_high_comp_plus);
        Button shockHighCompMinus = view.findViewById(R.id.shock_high_comp_minus);

        save_btn.setOnClickListener(this);
        forkReboundPlus.setOnClickListener(this);
        forkReboundMinus.setOnClickListener(this);
        forkCompressionPlus.setOnClickListener(this);
        forkCompressionMinus.setOnClickListener(this);
        shockReboundPlus.setOnClickListener(this);
        shockReboundMinus.setOnClickListener(this);
        shockLowCompPlus.setOnClickListener(this);
        shockLowCompMinus.setOnClickListener(this);
        shockHighCompPlus.setOnClickListener(this);
        shockHighCompMinus.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.save_button:
                saveToDatabase();
                break;

            case R.id.fork_rebound_plus:
                addOne(forkReboundTxtView);
                break;

            case R.id.fork_rebound_minus:
                removeOne(forkReboundTxtView);
                break;

            case R.id.fork_compression_plus:
                addOne(forkCompressionTxtView);
                break;

            case R.id.fork_compression_minus:
                removeOne(forkCompressionTxtView);
                break;

            case R.id.shock_rebound_plus:
                addOne(shockReboundTxtView);
                break;

            case R.id.shock_rebound_minus:
                removeOne(shockReboundTxtView);
                break;

            case R.id.shock_low_comp_plus:
                addOne(shockLowCompTxtView);
                break;

            case R.id.shock_low_comp_minus:
                removeOne(shockLowCompTxtView);
                break;

            case R.id.shock_high_comp_plus:
                addOne(shockHighCompTxtView);
                break;

            case R.id.shock_high_comp_minus:
                removeOne(shockHighCompTxtView);
                break;

        }
    }

    private void saveToDatabase() {
        DatabaseHelper dbHelper = new DatabaseHelper(this.getActivity());

        DataModel data = new DataModel(-1, Integer.parseInt(forkReboundTxtView.getText().toString()),
                Integer.parseInt(forkCompressionTxtView.getText().toString()), Integer.parseInt(shockReboundTxtView.getText().toString()),
                Integer.parseInt(shockLowCompTxtView.getText().toString()), Integer.parseInt(shockHighCompTxtView.getText().toString()),
                settingNameEditText.getText().toString());

        boolean success = dbHelper.addOne(data);
        Toast.makeText(this.getActivity(), "Success: " + success, Toast.LENGTH_LONG).show();
    }

    @SuppressLint("SetTextI18n")
    private void addOne(TextView textView){
        int currentValue = Integer.parseInt(textView.getText().toString());
        int newValue = currentValue + 1;
        textView.setText(Integer.toString(newValue));
    }

    @SuppressLint("SetTextI18n")
    private void removeOne(TextView textView){
        int currentValue = Integer.parseInt(textView.getText().toString());

        if (currentValue != 0) {
            int newValue = currentValue - 1;
            textView.setText(Integer.toString(newValue));
        }
    }
}

















