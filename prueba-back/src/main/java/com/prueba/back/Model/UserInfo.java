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
@Table(name="user_info")
public class UserInfo implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user_info")
    private Integer idUserInfo;
    
    @Size(max = 45)
    @Column(name = "user_name")
    private String name;
    
    @Size(max = 120)
    @Column(name = "surname")
    private String surname;
    
    @Column(name="phone")
    private String phone;
    
    @JoinColumn(name = "fk_gender", referencedColumnName = "id_gender")
    @ManyToOne(optional = true)
    private Gender fkGender;
}
