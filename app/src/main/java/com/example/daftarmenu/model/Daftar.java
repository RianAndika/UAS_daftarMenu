package com.example.daftarmenu.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

public class Daftar {
    public static final String NASI_KUNING = "NASI_KUNING";
    public static final String PECEL_LELE = "PECEL_LELE";
    public static final String ES_JERUK = "ES_JERUK";
    public static final String TEH_MANIS = "TEH_MANIS";
    public static final String COKLAT = "COKLAT";


    private String id;
    private String nama;
    private String deskripsi;
    private String jenis;
    private String harga;

    public Daftar() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {return nama; }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {this.harga = harga; }

    public static Daftar fromJSONObject(JSONObject obj) {
        Daftar tr = new Daftar();
        try {
            tr.setId(obj.getString("id"));
            tr.setNama(obj.getString("nama"));
            tr.setDeskripsi(obj.getString("deskripsi"));
            tr.setJenis(obj.getString("jenis"));
            tr.setHarga(obj.getString("harga"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tr;
    }

    public JSONObject toJSONObject() {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("id", this.id);
            jsonObj.put("nama", this.nama);
            jsonObj.put("deskripsi", this.deskripsi);
            jsonObj.put("jenis", this.jenis);
            jsonObj.put("harga", this.harga);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObj;
    }
}
