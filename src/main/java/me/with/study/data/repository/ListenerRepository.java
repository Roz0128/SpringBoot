package me.with.study.data.repository;

import me.with.study.data.entity.ListenerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListenerRepository extends JpaRepository<ListenerEntity, Long> {
}
