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
@Table(name = "persona")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_persona")
	private Integer idPersona;

	@Size(max = 100)
	@Column(name = "nombre")
	private String nombre;

	@Size(max = 100)
	@Column(name = "apellidoPaterno")
	private String apellidoP;

	@Size(max = 100)
	@Column(name = "apellidoMaterno")
	private String apellidoM;

	@Size(max = 100)
	@Column(name = "identificacion")
	private String identifiacion;

	@JoinColumn(name = "fk_factura", referencedColumnName = "id_factura")
	@ManyToOne(optional = true)
	private Factura fkFactura;
}
