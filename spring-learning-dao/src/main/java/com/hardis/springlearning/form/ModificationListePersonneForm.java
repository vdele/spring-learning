package com.hardis.springlearning.form;

import java.util.List;

import javax.validation.Valid;


public class ModificationListePersonneForm
{
	@Valid
	private List<ModificationPersonneForm> listePersonnes;

	public void setListePersonnes(final List<ModificationPersonneForm> pListePersonnes)
	{
		listePersonnes = pListePersonnes;
	}

	public List<ModificationPersonneForm> getListePersonnes()
	{
		return listePersonnes;
	}
}
