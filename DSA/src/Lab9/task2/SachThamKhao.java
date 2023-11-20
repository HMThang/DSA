package Lab9.task2;

import java.util.List;

public class SachThamKhao extends AnPham {
    private String linhVuc;
    List<ChuongSach> listChuongSach;

    public SachThamKhao(String tieuDe, String soTrang, String namXuatBan, String giaTien, String linhVuc,
                        List<ChuongSach> listChuongSach, String author) {
        super(tieuDe, soTrang, namXuatBan, giaTien, author);
        this.linhVuc = linhVuc;
        this.listChuongSach = listChuongSach;
    }

    public String getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    public List<ChuongSach> getListChuongSach() {
        return listChuongSach;
    }

    public void setListChuongSach(List<ChuongSach> listChuongSaches) {
        this.listChuongSach = listChuongSaches;
    }


}
