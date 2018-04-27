/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pojo.Monhoc;

/**
 *
 * @author Gokki
 */
public class MonHocDAO {

    private static Transaction tss = null;
    private static Session ss = null;

    public static List<Monhoc> GetListMonHoc() {
        List<Monhoc> ds = null;
        ss = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tss = ss.beginTransaction();
            Query qr = ss.createQuery("from Monhoc");
            ds = qr.list();
            tss.commit();
        } catch (Exception e) {
            if (tss != null) {
                tss.rollback();
            }
        }finally{
            StandardServiceRegistryBuilder.destroy(HibernateUtil.registry);
        }
        return ds;
    }

    public static Monhoc getMonHocByMaMH(String MaMH) {
        Monhoc mh = null;
        try {
            ss = HibernateUtil.getSessionFactory().getCurrentSession();
            tss = ss.beginTransaction();
            mh = (Monhoc) ss.get(Monhoc.class, MaMH);
            tss.commit();

        } catch (HibernateException e) {
            if (tss != null) {
                tss.rollback();
            }
        }finally{
            StandardServiceRegistryBuilder.destroy(HibernateUtil.registry);
        }
        return mh;
    }

    public static boolean SaveMonHoc(Monhoc mh) {
        ss = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tss = ss.beginTransaction();
            ss.save(mh);
            tss.commit();
            return true;
        } catch (Exception e) {
            if (tss != null) {
                tss.rollback();
            }
            return false;
        }finally{
            StandardServiceRegistryBuilder.destroy(HibernateUtil.registry);
        }
    }

    public static Monhoc GetMonHocByTenMH(String TenMh) {
        Monhoc mh = null;
        try {
            ss = HibernateUtil.getSessionFactory().getCurrentSession();
            tss = ss.beginTransaction();
            String hql = "from Monhoc mh where tenMh = :tenMH";//Lập Trình Ứng Dụng java";// + TenMh;
            Query qr = ss.createQuery(hql);
            qr.setString("tenMh", TenMh);
            List<Monhoc> lmh = qr.list();
            mh = lmh.get(0);
            tss.commit();
        } catch (Exception e) {
            if (tss != null) {
                tss.rollback();
            }
        }finally{
            StandardServiceRegistryBuilder.destroy(HibernateUtil.registry);
        }
        return mh;
    }
}
