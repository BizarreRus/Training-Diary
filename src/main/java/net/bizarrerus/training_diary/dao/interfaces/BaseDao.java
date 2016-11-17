package net.bizarrerus.training_diary.dao.interfaces;

import org.hibernate.Session;

public interface BaseDao {
    Session getSession();
}
