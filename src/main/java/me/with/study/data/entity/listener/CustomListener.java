package me.with.study.data.entity.listener;

import me.with.study.data.entity.ListenerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

public class CustomListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostLoad
    public void postLoad(ListenerEntity entity){
        logger.info("[postLoad] called!!");
    }

    @PrePersist
    public void prePersist(ListenerEntity entity){
        logger.info("[prePersist] called!!");
    }

    @PostPersist
    public void postPersist(ListenerEntity entity){
        logger.info("[postPersist] called!!");
    }

    @PreUpdate
    public void preUpdate(ListenerEntity entity){
        logger.info("[preUpdate] called!!");
    }

    @PostUpdate
    public void postUpdate(ListenerEntity entity){
        logger.info("[postUpdate] called!!");
    }

    @PreRemove
    public void preRemove(ListenerEntity entity){
        logger.info("[preRemove] called!!");
    }

    @PostRemove
    public void postRemove(ListenerEntity entity){
        logger.info("[postRemove] called!!");
    }
}
