package com.system_marine.barcos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BarcoRepository extends JpaRepository<Barco, Long> {

	List<Barco> findAll();

}
