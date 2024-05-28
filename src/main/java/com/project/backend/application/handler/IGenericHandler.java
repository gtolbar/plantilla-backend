package com.project.backend.application.handler;

import java.util.List;

public interface IGenericHandler<Request,Response,ID> {

    void saveModelIn(Request request);

    List<Response> getAllModelFrom();

    Response getModelFrom(ID id);

    void updateModelIn(Request request);

    void deleteModelFrom(ID id);
}
