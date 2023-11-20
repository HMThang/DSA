package Lab9.task2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<AnPham> listAnPham = new ArrayList<>();
        // Tạo các chương sách
        ChuongSach sach1 = new ChuongSach("1", 50);
        ChuongSach sach2 = new ChuongSach("1", 25);
        List<ChuongSach> listChuongSach = new ArrayList<>();
        listChuongSach.add(sach1);
        listChuongSach.add(sach2);
        // Tạo danh sách các ấn phẩm
        SachThamKhao book1 = new SachThamKhao("Sach 1", "200", "2031", "100000", "Linh Vuc 1", listChuongSach, "Alan");
        SachThamKhao book2 = new SachThamKhao("Sach 2", "250", "2021", "120000", "Linh Vuc 2", listChuongSach, "Saga");
        TapChi journal1 = new TapChi("Tap chi 1", "50", "2011", "50", "Ten Tap Chi 1", "Casey");
        TapChi journal2 = new TapChi("Tap chi 2", "60", "2022", "60", "Ten Tap Chi 2", "Casey");
        listAnPham.add(book1);
        listAnPham.add(book2);
        listAnPham.add(journal1);
        listAnPham.add(journal2);

        // Tạo đối tượng DanhMucAnPham và thực hiện các thao tác
        DanhMucAnPham danhMuc = new DanhMucAnPham(listAnPham);

        // 6) Phương thức xác định loại của ấn phẩm (Tạp chí hay Sách tham khảo)
        for (AnPham anPham : danhMuc.getListAnPham()) {
            System.out.println(anPham.getTieuDe() + " là  " + anPham.type());
        }

        // 7) Phương thức kiểm tra ấn phẩm là tạp chí và có thời gian xuất bản cách đây (2021) 10 năm hay không
        for (AnPham anPham : danhMuc.getListAnPham()) {
            if (anPham.isTapChi10Year()) {
                System.out.println(anPham.getTieuDe() + " was published 10 years ago.");
            }
        }

        // 8) Phương thức kiểm tra hai ấn phẩm có cùng loại và cùng tác giả hay không
        boolean sameTypeAndAuthor = danhMuc.hasSameTypeAndAuthor(book1, book2);
        System.out.println("Book1 and Book2 have same type and author: " + sameTypeAndAuthor);

        // 9) Tính tổng tiền của tất cả các ấn phẩm trong nhà sách
        double totalPrice = danhMuc.tongTien();
        System.out.println("Total price of all publications: " + totalPrice);

        // 10) Tìm quyển sách tham khảo có chương sách nhiều trang nhất
        SachThamKhao bookWithMostPages = danhMuc.findBookWithMostPages();
        System.out.println("Book with most pages in a chapter: " + bookWithMostPages.getTieuDe());

        // 11) Tìm xem trong danh sách các ấn phẩm có chứa một tạp chí có tên cho trước hay không
        boolean containsJournal = danhMuc.containsJournalWithName("Ten Tap Chi 2");
        System.out.println("Contains journal with name 'Ten Tap Chi 2': " + containsJournal);

        // 12) Lấy ra danh sách các tạp chí được xuất bản vào 1 năm cho trước
        List<TapChi> journalsPublishedInYear = danhMuc.getJournalsPublishedInYear(2021);
        System.out.println("Journals published in 2021: " + journalsPublishedInYear.size());
        for (TapChi tapChi : journalsPublishedInYear) {
            System.out.print(tapChi.getTenTapChi() + " và ");
        }

        // 13) Sắp xếp ấn phẩm tăng dần theo tiêu đề và giảm dần theo năm xuất bản
        danhMuc.sortPublications();
        System.out.println("Sorted publications: ");
        for (AnPham anPham : danhMuc.getListAnPham()) {
            System.out.println(anPham.getTieuDe() + " - " + anPham.getNamXuatBan());
        }

        // 14) Thống kê số lượng ấn phẩm theo năm xuất bản
        System.out.println("Count of publications by year: ");
        for (var entry : danhMuc.countPublicationsByYear().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
