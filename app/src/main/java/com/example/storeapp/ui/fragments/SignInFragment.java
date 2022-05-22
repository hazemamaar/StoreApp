package com.example.storeapp.ui.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.storeapp.R;
import com.example.storeapp.databinding.FragmentSignBinding;
import com.example.storeapp.ui.viewmodel.LoginViewModel;
import com.google.firebase.auth.FirebaseUser;


public class SignInFragment extends Fragment {



    private  NavController navController;
    FragmentSignBinding binding;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    LoginViewModel loginViewModel;

    public SignInFragment() {

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel= new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.getUserModelLiveData().observe(getActivity(), new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser != null) {
                    Toast.makeText(getContext(),"login Done",Toast.LENGTH_SHORT).show();
                    if(binding.switchRememberMe.isChecked()) {
                                sharedPreferences = getActivity().getSharedPreferences("logininfo", getContext().MODE_PRIVATE);
                                editor = sharedPreferences.edit();
                                editor.putString("Email", binding.inputTextEmail.getText().toString()).
                                        putString("Password", binding.inputTextPassword.getText().toString()).apply();
                                editor.commit();
                                Log.i("HAZ", "TRue"); }
                    Navigation.findNavController(getView()).navigate(R.id.action_splashScreen_to_productActivity);
                }else{
                    Toast.makeText(getContext(),"Login Fail",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSignBinding.inflate(inflater,container,false);
        binding.singinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginViewModel.login(binding.inputTextEmail.getText().toString(),binding.inputTextPassword.getText().toString());
            }
        });
        binding.textSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getView()).navigate(R.id.action_signInFragment_to_registration);
            }
        });

        return binding.getRoot();
    }

//    void init(View view){
//        emailEditText =view.findViewById(R.id.inputTextEmail);
//        passwordEditText=view.findViewById(R.id.inputTextPassword);
//        signInBtn=view.findViewById(R.id.singin_btn);
//        signUpTxt=view.findViewById(R.id.textSignUp);
//        navController = Navigation.findNavController(view);
//        switchCompat=view.findViewById(R.id.switchRememberMe);
//    }
//    void signInWithFirebase(String email,String password ){
//        FirebaseConnect.firebaseAuth.
//                signInWithEmailAndPassword(email,password).
//                addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//                            if(switchCompat.isChecked()) {
//                                sharedPreferences = getActivity().getSharedPreferences("logininfo", Context.MODE_PRIVATE);
//                                editor = sharedPreferences.edit();
//                                editor.putString("Email", email);
//                                editor.putString("Password", password);
//                                editor.apply();
//                                editor.commit();
//                                Log.i("HAZ", "TRue");
//                            }
//                        }else {
//                            Toast.makeText(getContext(),"Fail",Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }

}