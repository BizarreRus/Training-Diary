package net.bizarrerus.training_diary.repository.impl;

import net.bizarrerus.training_diary.repository.interfaces.ComplexDao;
import net.bizarrerus.training_diary.model.Complex;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ComplexDaoImpl extends BaseDaoImpl implements ComplexDao {
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

    @Override
    @Transactional
    public void delete(int id) {
        Complex complex = get(id);
        complex.getExercises().clear();
        getSession().delete(complex);
    }

    @Override
    @Transactional
    public Complex get(int id) {
        return (Complex) getSession().load(Complex.class, id);
    }

    @Override
    @Transactional
    public void update(Complex complex) {
        getSession().update(complex);
    }
}
