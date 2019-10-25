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
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText edtuser;
    EditText edtpass;
    Button submitbtn;
    Button registerbtn;
    FirebaseAuth mFireBaseAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtuser = findViewById(R.id.edtusername);
        edtpass = findViewById(R.id.edtpassword);
        submitbtn = findViewById(R.id.btnsubmit);
        registerbtn = findViewById(R.id.btnregister);
        mFireBaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFireBaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(MainActivity.this, "Logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, MenuActivity3.class);
                    startActivity(i);
                }
            }
        };
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtuser.getText().toString();
                String pass = edtpass.getText().toString();

                if (user.isEmpty()) {
                    Toast.makeText(MainActivity.this, "username cannot be emtpy", Toast.LENGTH_SHORT).show();
                } else if (pass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "password cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (user.isEmpty() && pass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "fields cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (!(user.isEmpty() && pass.isEmpty())) {
                    mFireBaseAuth.signInWithEmailAndPassword(user, pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!(task.isSuccessful())){
                                Toast.makeText(MainActivity.this, "login failed", Toast.LENGTH_SHORT).show();
                            }else{
                                Intent i = new Intent(MainActivity.this, MenuActivity3.class) ;
                                startActivity(i);
                            }
                        }
                    });
                }
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RegisterActivity2.class);
                startActivity(i);
            }
        });
    }
}
