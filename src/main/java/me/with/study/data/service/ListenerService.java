package me.with.study.data.service;

import me.with.study.data.entity.ListenerEntity;

public interface ListenerService {

    ListenerEntity getEntity(Long id);

    void saveEntity(ListenerEntity listenerEntity);
    void updateEntity(ListenerEntity listenerEntity);
    void removeEntity(ListenerEntity listenerEntity);

}
