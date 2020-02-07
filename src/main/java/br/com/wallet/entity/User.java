package br.com.wallet.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class User implements Serializable{

	
	private static final long serialVersionUID = 4719246330754265998L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String passoword;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	
	
}
