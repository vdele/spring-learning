package com.hardis.springlearning.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hardis.springlearning.dao.Personne.Sexe;


@Component("personneSupport")
public class PersonneSupport
{
	@Autowired
	private PersonneDaoImpl personDAO;

	@Transactional
	public void createPersonne(final String nom, final String prenom, final int age, final String sexe)
	{
		final Personne pers = new Personne();
		pers.setAge(age);
		pers.setNom(nom);
		pers.setPrenom(prenom);
		pers.setSexe(Sexe.valueOf(sexe));
		personDAO.save(pers);
	}

	@Transactional(readOnly = true)
	public List<Personne> getPersonnes()
	{
		return personDAO.getAll();
	}

	@Transactional
	public void supprimerPersonne(final Long id)
	{

		personDAO.supprimerPersonneById(id);
	}

	@Transactional
	public void modifierPersonnes(final List<Personne> pPersonnes)
	{
		for (final Personne lPersonne : pPersonnes)
		{
			personDAO.modifierPersonne(lPersonne);
		}
	}

	@Transactional
	public void modifierPersonne(final Personne pPersonne)
	{
		personDAO.modifierPersonne(pPersonne);
	}


}
