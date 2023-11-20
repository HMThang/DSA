package Lab9.task2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnPham {
    protected String tieuDe;
    protected String soTrang;
    protected String namXuatBan;
    protected String giaTien;
    protected String author;

    public AnPham(String tieuDe, String soTrang, String namXuatBan, String giaTien, String author) {
        super();
        this.tieuDe = tieuDe;
        this.soTrang = soTrang;
        this.namXuatBan = namXuatBan;
        this.giaTien = giaTien;
        this.author = author;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(String soTrang) {
        this.soTrang = soTrang;
    }

    public String getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(String namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public String type() {
        if (this instanceof SachThamKhao) {
            return "Sach tham khao";
        }
        return "TapChi";
    }

    public boolean isTapChi10Year() {
        if (type().equals("TapChi")) {
            return (2021 - Integer.parseInt(namXuatBan) == 10);
        }
        return false;
    }
}
