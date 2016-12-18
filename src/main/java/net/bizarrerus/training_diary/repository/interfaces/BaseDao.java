package net.bizarrerus.training_diary.repository.interfaces;

import org.hibernate.Session;

public interface BaseDao {
    Session getSession();
}
