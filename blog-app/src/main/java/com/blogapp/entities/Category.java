package com.blogapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	
	@Column(name = "category",nullable = false,length = 100)
	private String categoryTitle;
	
	@Column(name="description")
	private String categoryDescription;
	
	
}
