package com.example.restaurantepepito.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.restaurantepepito.MainActivity;
import com.example.restaurantepepito.NavigationHost;
import com.example.restaurantepepito.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login_Fragment extends Fragment {


    private TextInputEditText correo;
    private TextInputEditText contraseña;
    private Button boton;
    private Button boton_registrar;
    FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_, container, false);

        correo = view.findViewById(R.id.login_correo_usuario);
        contraseña = view.findViewById(R.id.login_contraseña_usuario);
        boton = view.findViewById(R.id.login_boton_iniciar_sesion);
        boton_registrar = view.findViewById(R.id.login_boton_crear_cuenta);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciar_Sesion(correo.getText().toString(),contraseña.getText().toString());
            }
        });

        boton_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((NavigationHost) getActivity()).navigateTo(new Registrar_UsuarioDireccion_Fragment(),true);
            }
        });

        return view;
    }

    public void iniciar_Sesion(String correo, String contraseña){
        mAuth.signInWithEmailAndPassword(correo,contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Intent intent = new Intent (getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

}






