package com.example.storeapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.storeapp.R;
import com.example.storeapp.databinding.FragmentRegistrationBinding;
import com.example.storeapp.ui.viewmodel.RegistrationViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseUser;


public class Registration extends Fragment {


     private TextInputEditText userNameEditText,mobilePhoneEditText,passwordEditText,emailEditText;
    MaterialButton createButton;
    TextView alreadyHaveAcc;
     NavController navController;
     RegistrationViewModel registrationViewModel;
     FragmentRegistrationBinding binding;
    public Registration() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registrationViewModel = new ViewModelProvider(this).get(RegistrationViewModel.class);
        registrationViewModel.getUserModelMutableLiveData().observe(getActivity(), new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser != null) {
                    Toast.makeText(getContext(),"Register Done",Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(getView()).navigate(R.id.action_registration_to_signInFragment);
                }else{
                    Toast.makeText(getContext(),"Register Fails",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =FragmentRegistrationBinding.inflate(inflater, container, false);

        binding.createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrationViewModel.register(binding.inputTextEmail.getText().toString(),binding.inputTextPassword.getText().toString());
            }
        });
        binding.alreadHaveAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getView()).navigate(R.id.action_registration_to_signInFragment);

            }
        });
        return binding.getRoot();
    }
}