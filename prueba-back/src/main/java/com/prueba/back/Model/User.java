package com.prueba.back.Model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "user_s")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_user")
	private Integer idUser;

	@Size(max = 45)
	@Column(name = "email")
	private String email;

	@Column(name = "passord")
	private String password;

	@Column(name = "token_user")
	private String token;

	@JoinColumn(name = "fk_user_type", referencedColumnName = "id_user_type")
	@ManyToOne(optional = true)
	private UserType fkUserType;

	@JoinColumn(name = "fk_user_info", referencedColumnName = "id_user_info")
	@OneToOne(optional = false)
	private UserInfo fkUserInfo;

}
