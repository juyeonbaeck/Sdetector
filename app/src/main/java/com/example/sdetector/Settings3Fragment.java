package com.example.sdetector;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import static android.content.Context.MODE_PRIVATE;

public class Settings3Fragment extends Fragment {
    private ViewGroup rootView;
    private SharedPreferences appData;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_settings3, container, false);

        appData = getActivity().getSharedPreferences("Terms and Conditions", MODE_PRIVATE);
        Button button1 = (Button) rootView.findViewById(R.id.tacBtn1);
        button1.setOnClickListener(this::onClick);
        ToggleButton toggle1 = (ToggleButton) rootView.findViewById(R.id.tacToggle1);
        boolean tacService = appData.getBoolean("tacService", true);  //default is true
        if (tacService = true)
        {
            toggle1.setChecked(true);
        }
        else
        {
            toggle1.setChecked(false);
        }
        toggle1.setOnCheckedChangeListener(this::onCheckedChange);
        Button button2 = (Button) rootView.findViewById(R.id.tacBtn2);
        button2.setOnClickListener(this::onClick);
        ToggleButton toggle2 = (ToggleButton) rootView.findViewById(R.id.tacToggle2);
        boolean tacPersonal = appData.getBoolean("tacPersonal", true);  //default is true
        if (tacPersonal = true)
        {
            toggle2.setChecked(true);
        }
        else
        {
            toggle2.setChecked(false);
        }
        toggle2.setOnCheckedChangeListener(this::onCheckedChange);
        Button button3 = (Button) rootView.findViewById(R.id.tacBtn3);
        button3.setOnClickListener(this::onClick);
        ToggleButton toggle3 = (ToggleButton) rootView.findViewById(R.id.tacToggle3);
        boolean tacAccess = appData.getBoolean("tacAccess", true);  //default is true
        if (tacPersonal = true)
        {
            toggle3.setChecked(true);
        }
        else
        {
            toggle3.setChecked(false);
        }
        toggle3.setOnCheckedChangeListener(this::onCheckedChange);

        return rootView;
    }

    // ?????? ?????? ?????? ?????? ?????????
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        switch (view.getId()) {
            case R.id.tacBtn1:
                builder.setTitle("????????? ?????? ??????");
                builder.setMessage(R.string.arg_textView1);
                builder.setNegativeButton("??????",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // ??????
                            }
                        });
                builder.show();
                break;
            case R.id.tacBtn2:
                builder.setTitle("???????????? ?????? ??? ??????");
                builder.setMessage(R.string.arg_textView2);
                builder.setNegativeButton("??????",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // ??????

                            }
                        });
                builder.show();
                break;
            /*case R.id.tacBtn3:
                builder.setTitle("????????? ????????????");
                builder.setMessage(R.string.arg_textView3);
                builder.setNegativeButton("??????",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // ??????

                            }
                        });
                builder.show();
                break;*/
        }
    }

    // ?????? ?????? ?????? Toggle Button ?????????
    public void onCheckedChange(CompoundButton compoundButton, boolean isChecked) {

        String toastMessage;

        switch (compoundButton.getId()) {
            case R.id.tacToggle1:
                //toggle ????????? on??? ??????
                if(isChecked){
                    toastMessage = "????????? ?????? ????????? ???????????????";
                    SharedPreferences.Editor editor = appData.edit();
                    editor.putBoolean("tacService", true); // value to store
                    editor.commit();
                    
                }else{
                    toastMessage = "????????? ?????? ????????? ??????????????????";
                    SharedPreferences.Editor editor = appData.edit();
                    editor.putBoolean("tacService", false); // value to store
                    editor.commit();
                }

                Toast.makeText(getActivity(),toastMessage,Toast.LENGTH_SHORT).show();
                break;
            case R.id.tacToggle2:
                //toggle ????????? on??? ??????
                if(isChecked){
                    toastMessage = "???????????? ?????? ??? ????????? ???????????????";
                    SharedPreferences.Editor editor = appData.edit();
                    editor.putBoolean("tacPersonal", true); // value to store
                    editor.commit();
                }else{
                    toastMessage = "???????????? ?????? ??? ????????? ??????????????????";
                    SharedPreferences.Editor editor = appData.edit();
                    editor.putBoolean("tacPersonal", false); // value to store
                    editor.commit();
                }

                Toast.makeText(getActivity(),toastMessage,Toast.LENGTH_SHORT).show();
                break;
            case R.id.tacToggle3:
                if(isChecked){
                    toastMessage = "????????? ?????? ????????? ???????????????";
                    SharedPreferences.Editor editor = appData.edit();
                    editor.putBoolean("tacAccess", true); // value to store
                    editor.commit();
                }else{
                    toastMessage = "????????? ?????? ????????? ??????????????????";
                    SharedPreferences.Editor editor = appData.edit();
                    editor.putBoolean("tacAccess", false); // value to store
                    editor.commit();
                }

                Toast.makeText(getActivity(),toastMessage,Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
