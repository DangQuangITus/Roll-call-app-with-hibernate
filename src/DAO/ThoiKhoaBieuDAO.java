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
import pojo.Bangdiemdanh;
import pojo.Monhoc;
import pojo.Sinhvien;
import pojo.Thoikhoabieu;
import pojo.ThoikhoabieuId;

/**
 *
 * @author Gokki
 */
public class ThoiKhoaBieuDAO {

    private static Transaction tss = null;
    private static Session ss = null;

    public static boolean SaveThoiKhoaBieu(Thoikhoabieu tkb) {
        ss = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tss = ss.beginTransaction();
            ss.save(tkb);
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

    public static Thoikhoabieu GetTKBByTKBId(ThoikhoabieuId tkbid) {
        Thoikhoabieu tkb = null;
        ss = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tss = ss.beginTransaction();
            tkb = (Thoikhoabieu) ss.get(Thoikhoabieu.class, tkbid);
            tss.commit();
        } catch (Exception e) {
            if (tss != null) {
                tss.rollback();
            }
        } finally {
            StandardServiceRegistryBuilder.destroy(HibernateUtil.registry);
        }
        return tkb;
    }

    public static List<Thoikhoabieu> GetTKBListBySinhVien(Sinhvien sv) {
        List<Thoikhoabieu> tkbs = null;
        try {
            ss = HibernateUtil.getSessionFactory().getCurrentSession();
            tss = ss.beginTransaction();
            tkbs = (List<Thoikhoabieu>) ss.get(Bangdiemdanh.class, sv);
            tss.commit();

        } catch (HibernateException e) {
            if (tss != null) {
                tss.rollback();
            }
        } finally {
            StandardServiceRegistryBuilder.destroy(HibernateUtil.registry);
        }
        return tkbs;
    }
}
