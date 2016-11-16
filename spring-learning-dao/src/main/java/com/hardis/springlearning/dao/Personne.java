package com.hardis.springlearning.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "PERSONNE")
public class Personne
{
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	private int age;
	private Sexe sexe;

	public static enum Sexe
	{
		H, F
	};

	public String getNom()
	{
		return nom;
	}

	public void setNom(final String nom)
	{
		this.nom = nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(final String prenom)
	{
		this.prenom = prenom;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(final int age)
	{
		this.age = age;
	}

	public Sexe getSexe()
	{
		return sexe;
	}

	public void setSexe(final Sexe sexe)
	{
		this.sexe = sexe;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(final Long id)
	{
		this.id = id;
	}


	@Override
	public String toString()
	{
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}


}
