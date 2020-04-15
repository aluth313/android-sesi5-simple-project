package id.ac.lpkia.registrationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import id.ac.lpkia.registrationexample.data.DataHolder;
import id.ac.lpkia.registrationexample.data.Mahasiswa;

public class RegisterActivity extends AppCompatActivity {
    EditText namaLengkap, email, username, password;
    RadioGroup gender;
    Spinner provinsi;
    Button regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        namaLengkap = findViewById(R.id.et_namaLengkap);
        email = findViewById(R.id.et_email);
        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        gender = findViewById(R.id.rg_gender);
        provinsi = findViewById(R.id.sp_provinsi);
        regis = findViewById(R.id.btn_registrasi);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sNamaLengkap = namaLengkap.getText().toString();
                String sEmail = email.getText().toString();
                String sUsername = username.getText().toString();
                String sPassword = password.getText().toString();
                String sProvinsi = provinsi.getSelectedItem().toString();
                String sGender = "";
                RadioButton radioButton = findViewById(gender.getCheckedRadioButtonId());
                sGender = radioButton.getText().toString();

                if (sNamaLengkap.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Nama tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (sEmail.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Email tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (sUsername.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Username tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (sPassword.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Password tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (sProvinsi.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Provinsi tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (sGender.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Gender tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else {
                    Mahasiswa cekMahasiswa = DataHolder.getByUsername(sUsername);
                    if (cekMahasiswa != null){
                        Toast.makeText(RegisterActivity.this, "Username sudah digunakan!", Toast.LENGTH_SHORT).show();
                    } else {
                        Mahasiswa mahasiswa = new Mahasiswa();
                        mahasiswa.setNama(sNamaLengkap);
                        mahasiswa.setEmail(sEmail);
                        mahasiswa.setUsername(sUsername);
                        mahasiswa.setPassword(sPassword);
                        mahasiswa.setProvinsi(sProvinsi);
                        mahasiswa.setJenisKelamin(sGender);

                        DataHolder.addMahasiswa(mahasiswa);
                        Toast.makeText(RegisterActivity.this, "Good Job! Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
