package com.example.daftarmenu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daftarmenu.model.Daftar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton btnupdate;
    ImageButton btnedit;
    ListView lvdaftar;
    TextView txnodata, txusername;
    MenuAdapter adapter;
    List<Daftar> daftarMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();
        loadDataTransaksi();
        setupListview();
    }

    private void inisialisasiView() {

            btnupdate = findViewById(R.id.btntambah);
            btnupdate.setOnClickListener(view -> bukaFormMenu());
            btnedit = findViewById(R.id.btn_change_username);
            btnedit.setOnClickListener(view -> changeUserName());
            lvdaftar = findViewById(R.id.lv_list);
            txnodata = findViewById(R.id.tx_nodata);
            txusername = findViewById(R.id.tx_user_name);
            txusername.setText(SharePerefernceUtility.getUserName(this));
            txusername = findViewById(R.id.tx_user_name);
        }

    private void setupListview() {
        adapter = new MenuAdapter(this, daftarMenu);
        lvdaftar.setAdapter(adapter);

    }

    private void loadDataTransaksi() {
        daftarMenu = SharePerefernceUtility.getAllMenu(this);
        if (daftarMenu.size() > 0) {
            txnodata.setVisibility(View.GONE);
        } else {
            txnodata.setVisibility(View.VISIBLE);
        }

    }
    private void refreshListView() {
        adapter.clear();
        loadDataTransaksi();
        adapter.addAll(daftarMenu);
    }

    private void bukaFormMenu() {
        Intent intent = new Intent(this, FormMenuActifity.class);
        startActivity(intent);
    }


    private void changeUserName() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ganti nama");

        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharePerefernceUtility.saveUserName(getApplicationContext(),input.getText().toString());
                Toast.makeText(getApplicationContext(),"Nama user berhasil disimpan",Toast.LENGTH_SHORT).show();
                txusername.setText(SharePerefernceUtility.getUserName(getApplicationContext()));
            }
        });
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshListView();
    }

}

