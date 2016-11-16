package net.bizarrerus.training_diary.service;

import net.bizarrerus.training_diary.model.Complex;

import java.util.List;

public interface ComplexService {
    void save(Complex complex, List<Integer> exercisesID);
    List getAll();
}
