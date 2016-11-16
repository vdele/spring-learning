package com.hardis.springlearning.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;


public class ModificationPersonneForm
{
	private Long id;
	@NotEmpty
	@Pattern(regexp = "\\d*")
	private String age;

	public Long getId()
	{
		return id;
	}

	public void setId(final Long pId)
	{
		id = pId;
	}

	public String getAge()
	{
		return age;
	}

	public void setAge(final String pAge)
	{
		age = pAge;
	}
}
