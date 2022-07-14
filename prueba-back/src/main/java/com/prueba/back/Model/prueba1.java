package com.prueba.back.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name ="prueba1")
public class prueba1 implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_activity_log")
	private Integer idActivityLog;

	@Size(max = 100)
	private String topic;
	@Size(max = 100)
	@Column(name = "message")
	private String message;

	
	@Size(max = 100)
	@Column(name = "message_type")
	private String type;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss aa",timezone = "America/Mexico_City")
	@Column(name = "date_at")
	private Date dateAt ;
	
	@Size(max = 100)
	@Column(name = "severity")
	private String severity;
	

}
