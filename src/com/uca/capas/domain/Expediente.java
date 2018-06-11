package com.uca.capas.domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name="expediente")
public class Expediente {

	
	@Id
	@Column(name = "c_expediente")
	@NotNull(message="El campo c_expediente no puede estar vacio")
	private Integer ccliente;

	
	@Column(name = "s_nombre")
	private String snombre;
	@Column(name = "s_apellido")
	private String sapellido;
	@Column(name = "f_ingreso")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar fingreso;
	@Column(name = "f_vencimiento")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar fvencimiento;
	@Column(name = "s_codigo")
	private String scodigo;
	@Column(name = "s_nit")
	private String snit;
	@Column(name = "s_dui")
	private String sdui;
	@Column(name = "b_estado")
	private Boolean bestado;
	
	
	
	
	//Delegate para conversion de fecha.
	//Utilizar el argumento flag para determinar si
	//Se trata de la fecha de ingreso(0) o vencimiento(2)
		public String getFechaDelegate(int flag){
			Calendar date;
			if(flag == 0) date = fingreso;
			else date = fvencimiento;
			if(date == null){
				return "";
			}
			else{
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String shortdate = sdf.format(date.getTime());
				return shortdate;
			}
		}
		
		//Delegate para activo o inactivo
		public String getBactivoDelegate(){
			if(this.bestado == null){
				return "";
			}
			else{
				if(this.bestado) return "ACTIVO";
				else return "INACTIVO";
			}
		}
	
	
}
