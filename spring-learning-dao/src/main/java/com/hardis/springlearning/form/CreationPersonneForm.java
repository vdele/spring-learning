package com.hardis.springlearning.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;


public class CreationPersonneForm
{

	@NotEmpty
	private String nom;
	@NotEmpty
	private String prenom;
	@NotEmpty
	@Pattern(regexp = "\\d*")
	private String age;
	@NotEmpty
	private String sexe;

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

	public String getAge()
	{
		return age;
	}

	public void setAge(final String age)
	{
		this.age = age;
	}

	public String getSexe()
	{
		return sexe;
	}

	public void setSexe(final String sexe)
	{
		this.sexe = sexe;
	}




}
