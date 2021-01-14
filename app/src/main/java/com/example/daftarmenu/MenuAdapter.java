package com.example.daftarmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.daftarmenu.model.Daftar;

import java.util.List;

public class MenuAdapter extends ArrayAdapter<Daftar> {

    Context context;

    public MenuAdapter(@NonNull Context context, @NonNull List<Daftar> objects) {
        super(context, R.layout.row_daftar, objects);
        this.context = context;
    }

    class ViewHolder {
        TextView txNama;
        TextView txHarga;
        TextView txJenisMakanan;
        TextView txDeskripsi;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Daftar tr = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_daftar, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txNama = convertView.findViewById(R.id.row_nama);
            viewHolder.txHarga = convertView.findViewById(R.id.row_hr);
            viewHolder.txJenisMakanan = convertView.findViewById(R.id.row_js);
            viewHolder.txDeskripsi = convertView.findViewById(R.id.row_ds);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txNama.setText(tr.getNama());
        viewHolder.txHarga.setText(tr.getHarga());
        viewHolder.txDeskripsi.setText(tr.getDeskripsi());
        if (tr.getJenis().equals(Daftar.NASI_KUNING)) {
            viewHolder.txJenisMakanan.setText("NASI_KUNING");
        } else if (tr.getJenis().equals(Daftar.PECEL_LELE)) {
            viewHolder.txJenisMakanan.setText("PECEL_LELE");
        } else if (tr.getJenis().equals(Daftar.ES_JERUK)) {
            viewHolder.txJenisMakanan.setText("ES_JERUK");
        } else if (tr.getJenis().equals(Daftar.COKLAT)) {
            viewHolder.txJenisMakanan.setText("COKLAT");
        } else if (tr.getJenis().equals(Daftar.TEH_MANIS)) {
            viewHolder.txJenisMakanan.setText("TEH_MANIS");
        } else {
            viewHolder.txJenisMakanan.setText("UMUM");
        }
        return convertView;
    }
}

