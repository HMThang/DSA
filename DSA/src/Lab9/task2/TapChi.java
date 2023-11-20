package Lab9.task2;

import java.util.List;

public class TapChi extends AnPham {

    private String tenTapChi;

    public TapChi(String tieuDe, String soTrang, String namXuatBan, String giaTien, String tenTapChi, String author) {
        super(tieuDe, soTrang, namXuatBan, giaTien, author);
        this.tenTapChi = tenTapChi;
    }

    public void setTenTapChi(String tenTapChi) {
        this.tenTapChi = tenTapChi;
    }

    public String getTenTapChi() {
        return this.tenTapChi;
    }
}
