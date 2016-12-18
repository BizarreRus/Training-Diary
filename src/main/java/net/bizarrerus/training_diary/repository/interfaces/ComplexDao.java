package net.bizarrerus.training_diary.repository.interfaces;

import net.bizarrerus.training_diary.model.Complex;

import java.util.List;

public interface ComplexDao {
    void save(Complex complex);

    List getAll();

    void delete(int id);

    Complex get(int id);

    void update(Complex complex);
}
