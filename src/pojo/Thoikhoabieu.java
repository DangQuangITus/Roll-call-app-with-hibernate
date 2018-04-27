package pojo;
// Generated Apr 12, 2018 11:27:14 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Thoikhoabieu generated by hbm2java
 */
@Entity
@Table(name="thoikhoabieu"
    ,catalog="diemdanh"
)
public class Thoikhoabieu  implements java.io.Serializable {

     private ThoikhoabieuId id;
     private Monhoc monhoc;
     private Date ngayBatDau;
     private Date ngayKetThuc;
     private String thuTrongTuan;
     private String gioBatDau;
     private String gioKetThuc;
     private String tenPhongHoc;

    public Thoikhoabieu() {
    }

	
    public Thoikhoabieu(ThoikhoabieuId id, Monhoc monhoc) {
        this.id = id;
        this.monhoc = monhoc;
    }
    public Thoikhoabieu(ThoikhoabieuId id, Monhoc monhoc, Date ngayBatDau, Date ngayKetThuc, String thuTrongTuan, String gioBatDau, String gioKetThuc, String tenPhongHoc) {
       this.id = id;
       this.monhoc = monhoc;
       this.ngayBatDau = ngayBatDau;
       this.ngayKetThuc = ngayKetThuc;
       this.thuTrongTuan = thuTrongTuan;
       this.gioBatDau = gioBatDau;
       this.gioKetThuc = gioKetThuc;
       this.tenPhongHoc = tenPhongHoc;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="maMh", column=@Column(name="MaMH", nullable=false, length=10) ), 
        @AttributeOverride(name="tenMh", column=@Column(name="TenMH", nullable=false, length=45) ) } )
    public ThoikhoabieuId getId() {
        return this.id;
    }
    
    public void setId(ThoikhoabieuId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MaMH", nullable=false, insertable=false, updatable=false)
    public Monhoc getMonhoc() {
        return this.monhoc;
    }
    
    public void setMonhoc(Monhoc monhoc) {
        this.monhoc = monhoc;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="NgayBatDau", length=10)
    public Date getNgayBatDau() {
        return this.ngayBatDau;
    }
    
    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="NgayKetThuc", length=10)
    public Date getNgayKetThuc() {
        return this.ngayKetThuc;
    }
    
    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    
    @Column(name="ThuTrongTuan", length=10)
    public String getThuTrongTuan() {
        return this.thuTrongTuan;
    }
    
    public void setThuTrongTuan(String thuTrongTuan) {
        this.thuTrongTuan = thuTrongTuan;
    }

    
    @Column(name="GioBatDau", length=10)
    public String getGioBatDau() {
        return this.gioBatDau;
    }
    
    public void setGioBatDau(String gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    
    @Column(name="GioKetThuc", length=10)
    public String getGioKetThuc() {
        return this.gioKetThuc;
    }
    
    public void setGioKetThuc(String gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    
    @Column(name="TenPhongHoc", length=10)
    public String getTenPhongHoc() {
        return this.tenPhongHoc;
    }
    
    public void setTenPhongHoc(String tenPhongHoc) {
        this.tenPhongHoc = tenPhongHoc;
    }




}


