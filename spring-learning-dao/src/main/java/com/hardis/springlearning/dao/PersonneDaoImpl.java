package com.hardis.springlearning.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Component("personneDAO")
public class PersonneDaoImpl
{
	@PersistenceContext
	private EntityManager em;


	public Long save(final Personne person)
	{
		em.persist(person);
		return person.getId();
	}

	public List<Personne> getAll()
	{
		final CriteriaBuilder lCriteriaBuilder = em.getCriteriaBuilder();

		final CriteriaQuery<Personne> lCriteriaQuery = lCriteriaBuilder.createQuery(Personne.class);
		final Root<Personne> lRoot = lCriteriaQuery.from(Personne.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<Personne> lTypedQuery = em.createQuery(lCriteriaQuery);

		return lTypedQuery.getResultList();
	}

	public void supprimerPersonneById(final Long id)
	{
		final Personne lPersonne = em.getReference(Personne.class, id);
		em.remove(lPersonne);
	}

	public void modifierPersonne(final Personne pPersonne)
	{

		final CriteriaBuilder lCriteriaBuilder = em.getCriteriaBuilder();

		final CriteriaUpdate<Personne> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Personne.class);
		final Root<Personne> lRoot = lCriteriaUpdate.from(Personne.class);
		final Path<Personne> lPath = lRoot.get("id");

		final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, pPersonne.getId());

		lCriteriaUpdate.where(lExpression);
		lCriteriaUpdate.set("age", pPersonne.getAge());

		final Query lQuery = em.createQuery(lCriteriaUpdate);
		final int lRowCount = lQuery.executeUpdate();

		if (lRowCount != 1)
		{
			final org.hibernate.Query lHQuery = lQuery.unwrap(org.hibernate.Query.class);
			final String lSql = lHQuery.getQueryString();
			throw new RuntimeException("Nombre d'occurences (" + lRowCount + ") modifiés différent de 1 pour " + lSql);
		}
	}


}
