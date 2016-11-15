package net.bizarrerus.training_diary.dao;

import org.hibernate.Session;

public interface BaseDao {
    Session getSession();
}
