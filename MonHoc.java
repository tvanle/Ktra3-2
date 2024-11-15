package KiemtraTH;

import java.io.Serializable;

public class MonHoc implements Serializable {
    private int    id;
    private String maMonHoc;
    private String tenMon;
    private int    soTinChi;
    private String loaiMonHoc;

    public MonHoc(String tenMon, int soTinChi, String loaiMonHoc) {
        this.tenMon = tenMon;
        this.soTinChi = soTinChi;
        this.loaiMonHoc = loaiMonHoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        this.maMonHoc = "INT" + String.format("%03d", id);
        ;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMon;
    }

    public void setTenMonHoc(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public String getLoaiMonHoc() {
        return loaiMonHoc;
    }

    public void setLoaiMonHoc(String loaiMonHoc) {
        this.loaiMonHoc = loaiMonHoc;
    }

    @Override
    public String toString() {
        return maMonHoc + " - " + tenMon + " - " + soTinChi + " - " + loaiMonHoc;
    }

//    public void toObject()

}
