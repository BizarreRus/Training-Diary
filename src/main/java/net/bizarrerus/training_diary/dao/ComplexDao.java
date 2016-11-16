package net.bizarrerus.training_diary.dao;

import net.bizarrerus.training_diary.model.Complex;

import java.util.List;

public interface ComplexDao {
    void save(Complex complex);
    List getAll();
}
