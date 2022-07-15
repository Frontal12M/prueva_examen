package com.prueba.back.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.back.Model.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

	@Query("select ut from UserType  ut where ut.type=:type")
	public Optional<UserType> findByName(@Param("type") String type);
	
	@Query(value="SELECT t FROM UserType t WHERE t.type = :type")
	public UserType findByUserType(@Param("type") String userType);
	
}
