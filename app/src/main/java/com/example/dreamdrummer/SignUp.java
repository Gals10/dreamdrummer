package com.example.dreamdrummer;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.FirebaseDatabase;



public class SignUp extends AppCompatActivity {
    EditText emailId, password, username;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        btnSignUp = findViewById(R.id.button);
        tvSignIn = findViewById(R.id.textView);
        username = findViewById(R.id.usernameC);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(SignUp.this,Login.class);
                startActivity(intent);
            }
        });


    }
    private void signUp ()
    {
        String email = emailId.getText().toString().trim();
        final String passwordd =password.getText().toString().trim();
        String name = username.getText().toString().trim();

        if(email.isEmpty()){
            emailId.setError("Email is required!");
            emailId.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailId.setError("Please provide valid email!");
            emailId.requestFocus();
            return;
        }
        if(password.length()<6){
            password.setError("Min password length should be 6 characters!");
            password.requestFocus();
            return;
        }
        if(name.isEmpty()){
            username.setError("Name is required!");
            username.requestFocus();

        }
        if(name.length() < 2 ){
            username.setError("Name should be at least 2 chars and less than 8!");
            username.requestFocus();
        }
        if( name.length() > 8){
            username.setError("Name should be at least 2 chars and less than 9!");
            username.requestFocus();
        }
        if(!name.isEmpty()&&name.length()<9) {
            mAuth.createUserWithEmailAndPassword(email, passwordd).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(SignUp.this, "Failed to register! try again!", Toast.LENGTH_SHORT).show();
                        try {
                            throw task.getException();
                        } catch (FirebaseAuthUserCollisionException error) {
                            emailId.setError("Email is already used");
                            emailId.requestFocus();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        String email = emailId.getText().toString();
                        String passwordd = password.getText().toString();
                        String name = username.getText().toString();
                        User userHelper = new User(email, passwordd, name,0);
                        FirebaseDatabase.getInstance().getReference("Users")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(userHelper);
                        mAuth.getCurrentUser().sendEmailVerification();
                        Toast.makeText(SignUp.this, "User has been registered successfully!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUp.this, Login.class));
                        finish();
                    }
                }
            });
        }
    }

}


