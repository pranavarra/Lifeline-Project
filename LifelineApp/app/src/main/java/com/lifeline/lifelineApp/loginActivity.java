package com.lifeline.lifelineApp;

import static com.lifeline.lifelineApp.R.string.if_email_not_exist;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class loginActivity extends AppCompatActivity {
    TextView errorText_email, errorText_ps;

    public void setError(@NonNull EditText err, @NonNull TextView errorText, int err_text_from_stringxml) {
        GradientDrawable drawable = (GradientDrawable) err.getBackground();
        drawable.mutate();
        drawable.setStroke(4,Color.rgb(176,0,32));
        errorText.setVisibility(View.VISIBLE);
        errorText.setText(err_text_from_stringxml);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Objects.requireNonNull(getSupportActionBar()).hide();
//        if user clicks on login button after entering details
        Button button = findViewById(R.id.button);
        errorText_email = findViewById(R.id.error_username);
        errorText_ps = findViewById(R.id.error_ps);
        final boolean[] isEmailAlreadyError = {false};
        button.setOnClickListener(v -> {
            EditText editText_email = findViewById(R.id.editTextTextPersonName);
            String email = editText_email.getText().toString();
            EditText editText_ps = findViewById(R.id.editTextTextPassword);
            String password = editText_ps.getText().toString();
            // If email field is blank
            if (TextUtils.isEmpty(email)){
                setError(editText_email, errorText_email, R.string.if_email_blank);
                isEmailAlreadyError[0] = true;
            }
            else if(false/*replace this with if email is not in database*/) {
                if(isEmailAlreadyError[0]){
                    errorText_email.setText(if_email_not_exist);
                }
                else setError(editText_email, errorText_email, if_email_not_exist);
                isEmailAlreadyError[0]=true;
            }
//            if email and password do not match i.e password is incorrect
            else if (false/*replace with condition*/){
                setError(editText_ps, errorText_ps, R.string.ps_incorrect);
            }
            else{
                //If no issues encountered yet... (Login successful)
                if(isEmailAlreadyError[0]){
//                    Revert to original state
                    editText_email.setBackgroundResource(R.drawable.edit_text_border);
                    errorText_email.setVisibility(View.GONE);
                    errorText_email.setText(R.string.error);
                }
                Intent intent = new Intent(loginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
////        If user clicks on signup link
        TextView signup = findViewById(R.id.signup);
        signup.setOnClickListener(view -> {
            Intent intent = new Intent(loginActivity.this, com.lifeline.lifelineApp.signup.class);
            startActivity(intent);
        });
    }
}