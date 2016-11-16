package com.hardis.springlearning.controller;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hardis.springlearning.dao.Personne;
import com.hardis.springlearning.dao.PersonneSupport;
import com.hardis.springlearning.form.CreationPersonneForm;
import com.hardis.springlearning.form.ModificationListePersonneForm;
import com.hardis.springlearning.form.ModificationPersonneForm;


@Controller
public class PersonneController
{
	@Autowired
	private PersonneSupport personDAO;

	@RequestMapping(value = "/personnes", method = RequestMethod.GET)
	public String afficherPersonnes(final ModelMap pModel)
	{
		final List<Personne> personnes = personDAO.getPersonnes();
		pModel.addAttribute("personnes", personnes);
		if (pModel.get("creationPersonne") == null)
		{
			pModel.addAttribute("creationPersonne", new CreationPersonneForm());
		}

		initFormModification(pModel, personnes);


		return "personnes";
	}

	private void initFormModification(final ModelMap pModel, final List<Personne> personnes)
	{
		if (pModel.get("modificationPersonne") == null)
		{
			final ModificationListePersonneForm lModificationForm = new ModificationListePersonneForm();
			final List<ModificationPersonneForm> lListe = new LinkedList<ModificationPersonneForm>();
			for (final Personne personne : personnes)
			{
				final ModificationPersonneForm lModificationPersonne = new ModificationPersonneForm();
				lModificationPersonne.setId(personne.getId());
				lModificationPersonne.setAge(String.valueOf(personne.getAge()));
				lListe.add(lModificationPersonne);
			}
			lModificationForm.setListePersonnes(lListe);
			pModel.addAttribute("modificationPersonne", lModificationForm);
		}
	}

	@RequestMapping(value = "/creerPersonne", method = RequestMethod.POST)
	public String creer(@Valid @ModelAttribute(value = "creationPersonne") final CreationPersonneForm pCreation,
			final BindingResult pBindingResult, final ModelMap pModel)
	{

		if (!pBindingResult.hasErrors())
		{

			personDAO.createPersonne(pCreation.getNom(), pCreation.getPrenom(), Integer.valueOf(pCreation.getAge()),
					pCreation.getSexe());
			pModel.addAttribute("creationPersonne", new CreationPersonneForm());
		}
		return afficherPersonnes(pModel);
	}


	@RequestMapping(value = "/supprimerPersonne", method = RequestMethod.GET)
	public String supprimer(@RequestParam(value = "idPersonne") final Long pIdPersonne, final ModelMap pModel)
	{

		personDAO.supprimerPersonne(pIdPersonne);
		return afficherPersonnes(pModel);
	}

	@RequestMapping(value = "/modifierPersonne", method = RequestMethod.POST)
	public String modifier(
			@Valid @ModelAttribute(value = "modificationPersonne") final ModificationListePersonneForm pModification,
			final BindingResult pBindingResult, final ModelMap pModel)
	{
		if (!pBindingResult.hasErrors())
		{
			final List<Personne> lListePersonnes = new LinkedList<Personne>();
			for (final ModificationPersonneForm lModificationPersonne : pModification.getListePersonnes())
			{
				final Personne lPersonne = new Personne();
				lPersonne.setId(lModificationPersonne.getId());
				final Integer lAge = Integer.valueOf(lModificationPersonne.getAge());
				lPersonne.setAge(lAge);
				lListePersonnes.add(lPersonne);
			}
			personDAO.modifierPersonnes(lListePersonnes);
		}

		return afficherPersonnes(pModel);
	}
}
