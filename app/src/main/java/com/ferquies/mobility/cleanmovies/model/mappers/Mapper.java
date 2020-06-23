package com.ferquies.mobility.cleanmovies.model.mappers;

public interface Mapper<Model, Entity> {
    Model map(Entity entity);
}
