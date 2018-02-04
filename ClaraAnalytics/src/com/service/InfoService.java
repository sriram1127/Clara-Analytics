package com.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.beans.CountryBean;
import com.beans.StateBean;
import com.entity.dao.ClaraDao;
import com.entity.dao.ClaraInterface;
import com.hib.entities.Country;
import com.hib.entities.Details;
import com.hib.entities.State;

@Path("/claraservice")
public class InfoService {

	private ClaraInterface claraInterface = null;

	@GET
	@Path("/countries")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCountries(@Context HttpHeaders header, @Context HttpServletResponse response) {
		claraInterface = new ClaraDao();
		// response.
		// response.setHeader("yourheadername", "yourheadervalue");
		List<CountryBean> beans = new ArrayList<CountryBean>();
		List<Country> countries = claraInterface.getCountries();
		for (Country country : countries) {
			beans.add(new CountryBean(String.valueOf(country.getId()), country.getName()));
		}
		countries.clear();
		return Response.ok(beans).build();
	}

	@GET
	@Path("/statesByCountry")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getStatesByCountry(@QueryParam("country") String countryId) {
		claraInterface = new ClaraDao();
		List<StateBean> beans = new ArrayList<StateBean>();
		List<State> states = claraInterface.getStates(Integer.parseInt(countryId));
		for (State state : states) {
			beans.add(new StateBean(String.valueOf(state.getId()), state.getName()));
		}
		states.clear();
		return Response.ok(beans).build();
	}

	@POST
	@Path("/store")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response getStatesByCountry(@FormParam("firstname") String firstName,
			@FormParam("secondname") String secondName, @FormParam("countryId") String countryId,
			@FormParam("stateId") String stateId) {
		Details details = new Details(firstName, secondName, Integer.parseInt(countryId), Integer.parseInt(stateId),
				new Timestamp(System.currentTimeMillis()));
		claraInterface = new ClaraDao();
		claraInterface.Insert(details);
		return Response.ok(true).build();
	}
}
