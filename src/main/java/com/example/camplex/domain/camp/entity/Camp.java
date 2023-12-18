package com.example.camplex.domain.camp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Camp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
