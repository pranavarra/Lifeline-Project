package com.lifeline.lifelineApp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {
    private Button Submit;
    EditText username, phone, email, ps, confirmPs;
    TextView error;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        error = findViewById(R.id.textView2);

        username = findViewById(R.id.newUsername);
        phone = findViewById(R.id.newPhone);
        email = findViewById(R.id.newEmail);
        ps = findViewById(R.id.newPs);
        confirmPs = findViewById(R.id.confirmPs);

        EditText[] fields = {username, phone, email, ps, confirmPs};

        Submit = findViewById(R.id.submit);
        Submit.setOnClickListener(v -> {
            int c=0;
            if(!fields[3].getText().toString().equals(fields[4].getText().toString())){
                c-=1;
                error.setText("Passwords do not match!");
                error.setVisibility(View.VISIBLE);
            }
            for(EditText i: fields){
                String txt = i.getText().toString();
                if(!TextUtils.isEmpty(txt)){
                    c+=1;
                }
                else{
                    error.setText("A field is blank!");
                    error.setVisibility(View.VISIBLE);
                }
            }
            if(c==5){
                error.setVisibility(View.GONE);
//                No error occurred!
            }
        });
    }
}
