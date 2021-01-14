package com.example.daftarmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.daftarmenu.model.Daftar;
import com.google.android.material.textfield.TextInputLayout;

public class FormMenuActifity extends AppCompatActivity {

    Button btnSimpan;
    TextInputLayout tilNM, tilHr, tilDs;
    Spinner spnJm;
    final String[] tipeMenu = {Daftar.NASI_KUNING, Daftar.PECEL_LELE, Daftar.ES_JERUK, Daftar.TEH_MANIS, Daftar.COKLAT};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_menu_actifity);
        inisialisasiView();
    }

    private void inisialisasiView() {
        btnSimpan = findViewById(R.id.btn_simpan);
        btnSimpan.setOnClickListener(view -> simpan());
        tilNM = findViewById(R.id.til_nm);
        tilHr = findViewById(R.id.til_hr);
        tilDs = findViewById(R.id.til_ds);
        spnJm = findViewById(R.id.spn_jm);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                tipeMenu
        );
        spnJm.setAdapter(adapter);
        spnJm.setSelection(0);
    }

    private void simpan() {
        if (isDataValid()) {
            Daftar tr = new Daftar();
            tr.setNama(tilNM.getEditText().getText().toString());
            tr.setHarga(tilHr.getEditText().getText().toString());
            tr.setDeskripsi(tilDs.getEditText().getText().toString());
            tr.setJenis(spnJm.getSelectedItem().toString());
            SharePerefernceUtility.addMenu(this, tr);
            Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();

            // Kembali ke layar sebelumnya setelah 500 ms (0.5 detik)
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 500);

        }
    }

    private boolean isDataValid() {
        if (tilNM.getEditText().getText().toString().isEmpty()
                || tilHr.getEditText().getText().toString().isEmpty()
                    || spnJm.getSelectedItem().toString().isEmpty()
                         || tilDs.getEditText().getText().toString().isEmpty()

        ) {
            Toast.makeText(this, "Data tidak bileh ada yang kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
