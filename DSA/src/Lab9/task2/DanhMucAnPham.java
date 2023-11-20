package Lab9.task2;

import java.util.*;

public class DanhMucAnPham {
    private List<AnPham> listAnPham;

    public DanhMucAnPham(List<AnPham> listAnPham) {
        super();
        this.listAnPham = listAnPham;
    }

    public List<AnPham> getListAnPham() {
        return listAnPham;
    }

    public void setListAnPham(List<AnPham> listAnPham) {
        this.listAnPham = listAnPham;
    }

    public void add(AnPham anPham) {
        listAnPham.add(anPham);
    }

    public String getType(AnPham publication) {
        if (publication instanceof SachThamKhao) {
            return "Sach Tham Khao";
        } else if (publication instanceof TapChi) {
            return "Tap Chi";
        }
        return "Khong biet";
    }

    // Phương thức kiểm tra ấn phẩm là tạp chí và có thời gian xuất bản cách đây (2021) 10 năm hay không
    public boolean isTapChi10Year(AnPham anPham) {
        return anPham.isTapChi10Year() && anPham instanceof TapChi;
    }

    // Phương thức kiểm tra hai ấn phẩm có cùng loại và cùng tác giả hay không
    public boolean hasSameTypeAndAuthor(AnPham anPham1, AnPham anPham2) {
        return anPham1.type().equals(anPham2.type()) && anPham1.getAuthor().equals(anPham2.getAuthor());
    }

    // Phương thức tính tổng tiền của tất cả các ấn phẩm trong nhà sách
    public double tongTien() {
        double sum = 0;
        for (AnPham anPham : listAnPham) {
            sum += Double.parseDouble(anPham.getGiaTien());
        }
        return sum;
    }

    // Phương thức tìm quyển sách tham khảo có chương sách nhiều trang nhất
    public SachThamKhao findBookWithMostPages() {
        SachThamKhao maxBook = null;
        int maxPages = 0;
        for (AnPham anPham : listAnPham) {
            if (anPham instanceof SachThamKhao) {
                SachThamKhao sachThamKhao = (SachThamKhao) anPham;
                for (ChuongSach chuong : sachThamKhao.getListChuongSach()) {
                    if (chuong.getSoTrang() > maxPages) {
                        maxPages = chuong.getSoTrang();
                        maxBook = sachThamKhao;
                    }
                }
            }
        }
        return maxBook;
    }

    // Phương thức tìm xem trong danh sách các ấn phẩm có chứa một tạp chí có tên cho trước hay không
    public boolean containsJournalWithName(String journalName) {
        for (AnPham anPham : listAnPham) {
            if (anPham instanceof TapChi && ((TapChi) anPham).getTenTapChi().equals(journalName)) {
                return true;
            }
        }
        return false;
    }

    // Phương thức lấy ra danh sách các tạp chí được xuất bản vào 1 năm cho trước
    public List<TapChi> getJournalsPublishedInYear(int year) {
        List<TapChi> journals = new ArrayList<>();
        for (AnPham anPham : listAnPham) {
            if (anPham instanceof TapChi && Integer.parseInt(anPham.getNamXuatBan()) == year) {
                journals.add((TapChi) anPham);
            }
        }
        return journals;
    }

    // Phương thức sắp xếp ấn phẩm tăng dần theo tiêu đề và giảm dần theo năm xuất bản
    public void sortPublications() {
        Collections.sort(listAnPham, Comparator.comparing(AnPham::getTieuDe)
                .thenComparing(AnPham::getNamXuatBan).reversed());
    }

    // Phương thức thống kê số lượng ấn phẩm theo năm xuất bản
    public Map<String, Integer> countPublicationsByYear() {
        Map<String, Integer> publicationCountByYear = new HashMap<>();
        for (AnPham anPham : listAnPham) {
            String year = anPham.getNamXuatBan();
            publicationCountByYear.put(year, publicationCountByYear.getOrDefault(year, 0) + 1);
        }
        return publicationCountByYear;
    }
}
