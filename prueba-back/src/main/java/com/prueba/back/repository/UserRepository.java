package com.prueba.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.back.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select us from User us where us.email=:emailUser")
	public User findUserByEmail(@Param("emailUser") String email);

	@Query("select us from User us" + " inner join UserInfo ui on us.fkUserInfo = ui.idUserInfo"
			+ " where ui.phone =:phoneUser")
	public  User findUserByPhone(@Param("phoneUser") String phone);

	@Query("select us from User us where us.email=:email and us.password=:password")
	public User findByUserAndUserPass(@Param("email") String user, @Param("password") String user_pass);


}
