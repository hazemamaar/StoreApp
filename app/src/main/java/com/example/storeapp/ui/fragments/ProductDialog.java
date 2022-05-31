package com.example.storeapp.ui.fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.storeapp.R;
import com.google.android.material.textfield.TextInputEditText;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProductDialog extends AppCompatDialogFragment {
    CircleImageView img_view;
    TextInputEditText title_Edit_Text,category_Edit_Text,des_Edit_Text;
HelperDialogListener listener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
        LayoutInflater inflater =getActivity().getLayoutInflater();
        View view =inflater.inflate(R.layout.fragment_push_product,null);
        category_Edit_Text =view.findViewById(R.id.inputTextTitel);
        title_Edit_Text =view.findViewById(R.id.inputTextCategory);
        des_Edit_Text =view.findViewById(R.id.inputTextDes);
        builder.setView(view).setTitle("Product").setNegativeButton("Cancel", (dialogInterface, i) -> {

        }).setPositiveButton("Done", (dialogInterface, i) -> {
       listener.getData(title_Edit_Text.getText().toString(),category_Edit_Text.getText().toString(),des_Edit_Text.getText().toString());

        });
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener =(HelperDialogListener)context;
        }catch (Exception e){
            Toast.makeText(context, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public  interface HelperDialogListener {
        void getData(String title,String category ,String des);
    }
}
