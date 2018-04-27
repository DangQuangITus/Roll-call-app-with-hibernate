/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Util.HibernateUtil;
import static Util.HibernateUtil.registry;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pojo.Bangdiemdanh;
import pojo.BangdiemdanhId;
import pojo.Sinhvien;

/**
 *
 * @author Gokki
 */
public class BangDiemDanhDAO {

    public static Bangdiemdanh getBDDByID(BangdiemdanhId bddID) {
        Bangdiemdanh bdd = null;
        Transaction tss = null;
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            tss = ss.beginTransaction();
            bdd = (Bangdiemdanh) ss.get(Bangdiemdanh.class, bddID);
            tss.commit();

        } catch (HibernateException e) {
            if (tss != null) {
                tss.rollback();
            }
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
            return bdd;
        }
    }

    public static boolean SaveBDD(Bangdiemdanh bdd) {
        Transaction tss = null;
        if (BangDiemDanhDAO.getBDDByID(bdd.getId()) != null) { // có rồi thì khỏi thêm
            return true;
        } else {
            Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
            try {
                tss = ss.beginTransaction();
                ss.save(bdd);
                tss.commit();
                return true;
            } catch (HibernateException e) {
                if (tss != null) {
                    tss.rollback();
                }
                e.printStackTrace();
                return false;

            } finally {
                StandardServiceRegistryBuilder.destroy(registry);
            }
        }

    }

    public static boolean UpdateBDD(Bangdiemdanh bdd) {
        Transaction tss = null;
        if (BangDiemDanhDAO.getBDDByID(bdd.getId()) == null) { // Không có thì không update được
            return false;
        } else {
            Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
            try {
                tss = ss.beginTransaction();
                ss.update(bdd);
                tss.commit();
                return true;
            } catch (HibernateException e) {
                if (tss != null) {
                    tss.rollback();
                }
                e.printStackTrace();
                return false;

            } finally {
                StandardServiceRegistryBuilder.destroy(registry);
            }
        }

    }

    public static boolean DeleteBDD(Bangdiemdanh bdd) {
        Transaction tss = null;
        if (BangDiemDanhDAO.getBDDByID(bdd.getId()) == null) { // không có thì khỏi xóa
            return true;
        } else {
            Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
            try { // nếu có thì xóa
                tss = ss.beginTransaction();
                ss.delete(bdd);
                tss.commit();
                return true;
            } catch (HibernateException e) {
                if (tss != null) {
                    tss.rollback();
                }
                e.printStackTrace();
                return false;
            } finally {

                StandardServiceRegistryBuilder.destroy(registry);
            }
        }

    }

    public static List<Bangdiemdanh> GetBDDBySinhVien(Sinhvien sv) {
        List<Bangdiemdanh> ds = null;
        Transaction tss = null;
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            tss = ss.beginTransaction();
            Query qr = ss.createQuery("from Bangdiemdanh bdd where bdd.sinhvien.mssv = :ssv");
            qr.setString("ssv", sv.getMssv());
            ds =  (List<Bangdiemdanh>) qr.list();
            tss.commit();

        } catch (HibernateException e) {
            if (tss != null) {
                tss.rollback();
            }
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
            return ds;
        }
    }
}
