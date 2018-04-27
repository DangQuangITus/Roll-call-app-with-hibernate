/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Util.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pojo.Giaovu;

/**
 *
 * @author Gokki
 */
public class GiaoVuDAO {

    private static Transaction tss = null;
    private static Session ss = null;

    public static List<Giaovu> getListGiaoVu() {
        List<Giaovu> ds = null;
        ss = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tss = ss.beginTransaction();
            String hql = "from Giaovu";
            Query qr = ss.createQuery(hql);
            ds = qr.list();
            tss.commit();
        } catch (Exception e) {
            if (tss != null) {
                tss.rollback();
            }
            e.printStackTrace();
        }finally{
            StandardServiceRegistryBuilder.destroy(HibernateUtil.registry);
        }
        return ds;
    }

    public static Giaovu GetGiaoVuByMaGV(String MaGV) {

        Giaovu gv = null;
        tss = null;
        ss = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tss = ss.beginTransaction();
            gv = (Giaovu) ss.get(Giaovu.class, MaGV);
            tss.commit();
        } catch (Exception e) {
            if (tss != null) {
                tss.rollback();
            }
            e.printStackTrace();
        }finally{
            StandardServiceRegistryBuilder.destroy(HibernateUtil.registry);
        }
        return gv;

    }

    public static boolean UpdateGiaoVu(Giaovu gv) {
        try {
            if (GiaoVuDAO.GetGiaoVuByMaGV(gv.getMaGv()) == null) { // không tìm thấy thông tin để update
                return false;
            } else { // tìm thấy giáo vụ
                ss = HibernateUtil.getSessionFactory().getCurrentSession();
                tss = ss.beginTransaction();
                ss.update(gv);
                tss.commit();
                return true;
            }
        } catch (Exception e) {
            if (tss != null) {
                tss.rollback();
            }
            e.printStackTrace();
            return false;
        }finally{
            StandardServiceRegistryBuilder.destroy(HibernateUtil.registry);
        }
    }

}
