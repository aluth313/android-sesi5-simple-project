package id.ac.lpkia.registrationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import id.ac.lpkia.registrationexample.data.DataHolder;
import id.ac.lpkia.registrationexample.data.Mahasiswa;

public class UbahActivity extends AppCompatActivity {
    EditText namaLengkap, email, password;
    RadioGroup gender;
    Spinner provinsi;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah);

        namaLengkap = findViewById(R.id.et_namaLengkapUbah);
        email = findViewById(R.id.et_emailUbah);
        password = findViewById(R.id.et_passwordUbah);
        RadioButton laki = findViewById(R.id.rb_laki);
        RadioButton perempuan = findViewById(R.id.rb_perempuan);
        provinsi = findViewById(R.id.sp_provinsiUbah);
        update = findViewById(R.id.btn_update);
        gender = findViewById(R.id.rg_genderUbah);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.provinces, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provinsi.setAdapter(adapter);

        Intent intent = getIntent();
        final int index = Integer.parseInt(intent.getStringExtra("index"));
        final String[] dataDummy = DataHolder.getData(index);

        namaLengkap.setText(dataDummy[0]);
        email.setText(dataDummy[1]);
        password.setText(dataDummy[2]);
        if (dataDummy[3].equals("Laki - laki")){
            laki.setChecked(true);
        } else {
            perempuan.setChecked(true);
        }

        int position = adapter.getPosition(dataDummy[4]);
        provinsi.setSelection(position);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sNamaLengkap = namaLengkap.getText().toString();
                String sEmail = email.getText().toString();
                String sPassword = password.getText().toString();
                String sProvinsi = provinsi.getSelectedItem().toString();
                String sGender = "";
                RadioButton radioButton = findViewById(gender.getCheckedRadioButtonId());
                sGender = radioButton.getText().toString();
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setUsername(dataDummy[5]);
                mahasiswa.setNama(sNamaLengkap);
                mahasiswa.setEmail(sEmail);
                mahasiswa.setPassword(sPassword);
                mahasiswa.setJenisKelamin(sGender);
                mahasiswa.setProvinsi(sProvinsi);

                DataHolder.updateMahasiswa(index, mahasiswa);
                Toast.makeText(UbahActivity.this, "Good Job! Data berhasil diupdate", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(UbahActivity.this, HomeActivity.class);
                intent1.putExtra("nama", sNamaLengkap);
                intent1.putExtra("email", sEmail);
                intent1.putExtra("jenisKelamin", sGender);
                intent1.putExtra("provinsi", sProvinsi);
                intent1.putExtra("username", dataDummy[5]);
                startActivity(intent1);
            }
        });
    }
}
