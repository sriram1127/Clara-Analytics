package com.entity.dao;

import java.util.List;

import com.hib.entities.Country;
import com.hib.entities.Details;
import com.hib.entities.State;

public interface ClaraInterface {

	public void Insert(Details details);

	public List<Country> getCountries();

	public List<State> getStates(Integer countryId);

}
