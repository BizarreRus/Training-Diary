package net.bizarrerus.training_diary.dao;

import net.bizarrerus.training_diary.model.Complex;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ComplexDaoImpl extends BaseDaoImpl implements ComplexDao{
    @Override
    @Transactional
    public void save(Complex complex) {
        getSession().save(complex);
    }

    @Override
    @Transactional
    public List getAll() {
        return getSession().createQuery("FROM Complex").list();
    }
}
