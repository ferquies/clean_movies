package com.ferquies.mobility.cleanmovies.domain.mappers;

public interface Mapper<Model, Entity> {
    Model map(Entity entity);
}
