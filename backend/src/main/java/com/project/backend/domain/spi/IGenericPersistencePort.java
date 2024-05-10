package com.project.backend.domain.spi;

import java.util.List;

public interface IGenericPersistencePort<T,ID> {

    void saveModel(T model);

    List<T> getAllModel();

    T getModel(ID id);

    void updateModel(T model);

    void deleteModel(ID model);

}
