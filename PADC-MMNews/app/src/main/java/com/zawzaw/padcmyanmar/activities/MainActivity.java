package com.zawzaw.padcmyanmar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.zawzaw.padcmyanmar.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Fun5", "User tap login button");

                EditText etUserPhone = findViewById(R.id.user_phone);
                String userPhone = etUserPhone.getText().toString();
                if (TextUtils.isEmpty(userPhone)) {
                    etUserPhone.setError("Enter your phone number");
                    return;
                }

                EditText etUserPassword = findViewById(R.id.user_password);
                String userPassword = etUserPassword.getText().toString();
                if (TextUtils.isEmpty(userPassword)) {
                    etUserPassword.setError("Enter your password");
                    return;
                }

                if (TextUtils.equals(userPhone, "09791325374")
                        && (TextUtils.equals(userPassword, "abc")) )
                {
                    Snackbar.make(v, "Login success", Snackbar.LENGTH_INDEFINITE).show();

                }

                else {
                    Toast.makeText(v.getContext(),
                            "Phone number or Password",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

        TextView txtRegister = findViewById(R.id.tv_register);
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(), "Creating a New Account", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
