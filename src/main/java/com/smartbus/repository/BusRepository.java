package com.smartbus.repository;
import com.smartbus.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BusRepository extends JpaRepository<Bus, Long> {
}
