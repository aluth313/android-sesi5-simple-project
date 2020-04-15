package id.ac.lpkia.registrationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import id.ac.lpkia.registrationexample.data.DataHolder;
import id.ac.lpkia.registrationexample.data.Mahasiswa;

public class HomeActivity extends AppCompatActivity {
    TextView welcome, namaLengkap, email, gender, provinsi;
    Button ubah, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        welcome = findViewById(R.id.tv_welcome);
        namaLengkap = findViewById(R.id.tv_namaLengkap);
        email = findViewById(R.id.tv_email);
        gender = findViewById(R.id.tv_gender);
        provinsi = findViewById(R.id.tv_provinsi);
        ubah = findViewById(R.id.btn_ubah);
        logout = findViewById(R.id.btn_logout);

        final Intent intent = getIntent();

        String sNama = intent.getStringExtra("nama");
        String sEmail = intent.getStringExtra("email");
        String sGender = intent.getStringExtra("jenisKelamin");
        String sProvinsi = intent.getStringExtra("provinsi");
//        String sPassword = intent.getStringExtra("password");


        welcome.setText("Selamat Datang, " + sNama);
        namaLengkap.setText(sNama);
        email.setText(sEmail);
        gender.setText(sGender);
        provinsi.setText(sProvinsi);

        ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sUsername = intent.getStringExtra("username");
                String index = String.valueOf(DataHolder.getIndexMahasiswa(sUsername));
                Intent ubah = new Intent(HomeActivity.this, UbahActivity.class);
                ubah.putExtra("index",index);
                startActivity(ubah);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent1);
            }
        });
    }
}
