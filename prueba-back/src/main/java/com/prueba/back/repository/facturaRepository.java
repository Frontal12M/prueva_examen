package com.prueba.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prueba.back.Model.Factura;

public interface facturaRepository extends JpaRepository<Factura, Integer> {
	
	@Query("select f from Factura f where f.monto=:monto ")
	public Factura finByMonto(String monto);

	
}
