package com.example.myshoppingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity2 extends AppCompatActivity {

    EditText edtuser_reg;
    EditText edtpass_reg;
    Button registerbtn;
    FirebaseAuth mFireBaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        edtuser_reg = findViewById(R.id.edtusername_reg);
        edtpass_reg = findViewById(R.id.edtpassword_reg);
        registerbtn = findViewById(R.id.registerbtn_reg);

        mFireBaseAuth = FirebaseAuth.getInstance();
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtuser_reg.getText().toString();
                String pass = edtpass_reg.getText().toString();

                if (user.isEmpty()){
                    edtuser_reg.setError("Enter an email address");
                    edtuser_reg.requestFocus();
                }else if(pass.isEmpty()){
                    edtpass_reg.setError("Enter a password");
                    edtpass_reg.requestFocus();
                }else if(user.isEmpty() && pass.isEmpty()){
                    Toast.makeText(RegisterActivity2.this, "fields cannot be empty!", Toast.LENGTH_SHORT).show();
                }else if(!(user.isEmpty() && pass.isEmpty())){
                    mFireBaseAuth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(RegisterActivity2.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(RegisterActivity2.this, "Registeration unsuccesfull!", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(RegisterActivity2.this, "Registeration succesfull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity2.this, MainActivity.class));
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(RegisterActivity2.this, "Error occured", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
