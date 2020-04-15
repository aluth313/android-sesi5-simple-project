package id.ac.lpkia.registrationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import id.ac.lpkia.registrationexample.data.DataHolder;
import id.ac.lpkia.registrationexample.data.Mahasiswa;

public class LoginActivity extends AppCompatActivity {
    EditText et_username, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DataHolder.initData();

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        findViewById(R.id.tv_registration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sUsername = et_username.getText().toString();
                String sPassword = et_password.getText().toString();

                if (sUsername.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Username tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (sPassword.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Password tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else {
                    Mahasiswa mahasiswa = DataHolder.getByUsername(sUsername);
                    if (mahasiswa != null){
                        if (mahasiswa.getPassword().equals(sPassword)){
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            intent.putExtra("nama", mahasiswa.getNama());
                            intent.putExtra("email", mahasiswa.getEmail());
                            intent.putExtra("jenisKelamin", mahasiswa.getJenisKelamin());
                            intent.putExtra("provinsi", mahasiswa.getProvinsi());
//                            intent.putExtra("password", mahasiswa.getPassword());
                            intent.putExtra("username", mahasiswa.getUsername());

                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "Password tidak valid!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Mahasiswa tidak terdaftar!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
