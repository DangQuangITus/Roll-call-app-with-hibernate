package pojo;
// Generated Apr 12, 2018 11:27:14 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ThoikhoabieuId generated by hbm2java
 */
@Embeddable
public class ThoikhoabieuId  implements java.io.Serializable {


     private String maMh;
     private String tenMh;

    public ThoikhoabieuId() {
    }

    public ThoikhoabieuId(String maMh, String tenMh) {
       this.maMh = maMh;
       this.tenMh = tenMh;
    }
   


    @Column(name="MaMH", nullable=false, length=10)
    public String getMaMh() {
        return this.maMh;
    }
    
    public void setMaMh(String maMh) {
        this.maMh = maMh;
    }


    @Column(name="TenMH", nullable=false, length=45)
    public String getTenMh() {
        return this.tenMh;
    }
    
    public void setTenMh(String tenMh) {
        this.tenMh = tenMh;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ThoikhoabieuId) ) return false;
		 ThoikhoabieuId castOther = ( ThoikhoabieuId ) other; 
         
		 return ( (this.getMaMh()==castOther.getMaMh()) || ( this.getMaMh()!=null && castOther.getMaMh()!=null && this.getMaMh().equals(castOther.getMaMh()) ) )
 && ( (this.getTenMh()==castOther.getTenMh()) || ( this.getTenMh()!=null && castOther.getTenMh()!=null && this.getTenMh().equals(castOther.getTenMh()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getMaMh() == null ? 0 : this.getMaMh().hashCode() );
         result = 37 * result + ( getTenMh() == null ? 0 : this.getTenMh().hashCode() );
         return result;
   }   


}


