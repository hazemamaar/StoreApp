package com.example.storeapp.ui.fragments;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.storeapp.R;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;


public class ProductDialog extends AppCompatDialogFragment implements EasyPermissions.PermissionCallbacks {
    private CircleImageView img_view;
    private TextInputEditText title_Edit_Text,category_Edit_Text,des_Edit_Text;
    private Uri uri;
    private String[] perms={Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE};
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
        LayoutInflater inflater =getActivity().getLayoutInflater();
        View view =inflater.inflate(R.layout.fragment_push_product,null);
        category_Edit_Text =view.findViewById(R.id.inputTextTitel);
        title_Edit_Text =view.findViewById(R.id.inputTextCategory);
        des_Edit_Text =view.findViewById(R.id.inputTextDes);
        img_view =view.findViewById(R.id.productimg_image);
        builder.setView(view).setTitle("Product").setNegativeButton("Cancel", (dialogInterface, i) -> {
        }).setPositiveButton("Done", (dialogInterface, i) -> {
        });
        img_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkPermission())
                     startCropImage();
                else
                    requestPermissions();
                // for fragment (DO NOT use `getActivity()`)

            }
        });
        return builder.create();
    }

    private void startCropImage(){
        ImagePicker.with(this)
                .compress(1024)	//Final image size will be less than 1 MB
                .start();
//        CropImage.activity().
//                setGuidelines(CropImageView.Guidelines.ON)
//                .setMultiTouchEnabled(true).
//                start(getContext(),this);
    }
    private boolean checkPermission(){
        return EasyPermissions.hasPermissions(getContext(),perms);
    }

    private void requestPermissions(){
        EasyPermissions.requestPermissions(this,"App Need Access to Your Gallery",305,perms);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
//            CropImage.ActivityResult result = CropImage.getActivityResult(data);
//            if (resultCode == RESULT_OK) {
//               Uri uri = result.getUri();
//               img_view.setImageURI(uri);
//            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
//                Exception error = result.getError();
//                Toast.makeText(getContext(), "Error +"+error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                Log.i("HAZEMAA", "onActivityResult: "+error.getLocalizedMessage());
//            }
//        }
        img_view.setImageURI(data.getData());
    }


    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        startCropImage();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {

        if(EasyPermissions.somePermissionPermanentlyDenied(getActivity(),perms)){
            new AppSettingsDialog.Builder(getActivity()).build().show();
        }
    }

}
