import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<MonHoc> monHocs = new ArrayList<>();
        ArrayList<GiangVien> giangViens = new ArrayList<>();
        ArrayList<GiangVien> giangVienArrayList = new ArrayList<>();
        while (n-->0) {
            String ma = sc.next();
            String ten = sc.nextLine();
            monHocs.add(new MonHoc(ma, ten));
        }

        sc = new Scanner(new File("GIANGVIEN.in"));
        n = Integer.parseInt(sc.nextLine());
        while (n-->0) {
            String ma = sc.next();
            String ten = sc.nextLine().substring(1);
            giangViens.add(new GiangVien(ma, ten));
        }

        sc = new Scanner(new File("GIOCHUAN.in"));
        n = Integer.parseInt(sc.nextLine());
        while (n-->0) {
            String ma = sc.next();
            String maMon = sc.next();
            Float gioDay = Float.parseFloat(sc.next());
            boolean added = false;
            for (GiangVien giangVien : giangVienArrayList) {
                if(giangVien.getMa().equals(ma)) {
                    giangVien.setGioDay(gioDay);
                    added = true;
                    break;
                }
            }
            if(!added) {
                for (GiangVien giangVien : giangViens) {
                    if(giangVien.getMa().equals(ma)) {
                        giangVien.setGioDay(gioDay);
                        giangVienArrayList.add(giangVien);
                        break;
                    }
                }
            }
        }
        for (GiangVien giangVien : giangVienArrayList) System.out.println(giangVien);
    }
}

class MonHoc {
    private String ma, ten;

    public MonHoc(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }
}

class GiangVien {
    private String ma, ten;
    private Float gioDay;

    public GiangVien(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
        gioDay = 0f;
    }

    public void setGioDay(Float gioDay) {
        this.gioDay += gioDay;
    }

    public String getMa() {
        return ma;
    }

    @Override
    public String toString() {
        return ten + " " + String.format("%.2f", gioDay);
    }
}

