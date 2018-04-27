/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pojo.Sinhvien;

/**
 *
 * @author Gokki
 */
public class SinhVienDAO {

    private static Transaction tss = null;
    private static Session ss = null;

    public static List<Sinhvien> getListSinhVien() {
        List<Sinhvien> ds = null;
        ss = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tss = ss.beginTransaction();
            String hql = "from Sinhvien";
            Query qr = ss.createQuery(hql);
            ds = qr.list();
        } catch (Exception e) {
            if (tss != null) {
                tss.rollback();
            }
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(HibernateUtil.registry);
        }
        return ds;
    }

    public static Sinhvien getSinhVienByMSSV(String MSSV) {
        Sinhvien sv = null;
        ss = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tss = ss.beginTransaction();
            sv = (Sinhvien) ss.get(Sinhvien.class, MSSV);
            tss.commit();

        } catch (Exception e) {
            if (tss != null) {
                tss.rollback();
            }
        } finally {
            StandardServiceRegistryBuilder.destroy(HibernateUtil.registry);
        }
        return sv;

    }

    public static boolean SaveNewSinhVien(Sinhvien sv) {
        if (SinhVienDAO.getSinhVienByMSSV(sv.getMssv()) != null) {
            return true;
        } else {
            ss = HibernateUtil.getSessionFactory().getCurrentSession();
            try {
                tss = ss.beginTransaction();
                ss.save(sv);
                tss.commit();
                return true;
            } catch (Exception e) {
                if (tss != null) {
                    tss.rollback();
                }
                return false;

            } finally {
                StandardServiceRegistryBuilder.destroy(HibernateUtil.registry);
            }
        }

    }

    public static boolean UpdateSinhVien(Sinhvien sv) {

        if (SinhVienDAO.getSinhVienByMSSV(sv.getMssv()) == null) {
            return false;
        }
        try {
            ss = HibernateUtil.getSessionFactory().getCurrentSession();
            tss = ss.beginTransaction();
            ss.update(sv);
            tss.commit();
            return true;
        } catch (Exception e) {
            if (tss != null) {
                tss.rollback();
            }
            return false;
        } finally {
            StandardServiceRegistryBuilder.destroy(HibernateUtil.registry);
        }
    }
}
