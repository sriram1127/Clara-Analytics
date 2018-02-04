package com.entity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.hib.entities.Country;
import com.hib.entities.Details;
import com.hib.entities.State;
import com.utility.HibernateUtil;

public class ClaraDao implements ClaraInterface {
	private SessionFactory sf = null;
	private Session session = null;
	private Transaction tx = null;

	@Override
	public void Insert(Details details) {
		// TODO Auto-generated method stub
		try {
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			tx = session.beginTransaction();
			session.save(details);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (session.isOpen())
				session.close();
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Country> getCountries() {
		// TODO Auto-generated method stub
		List<Country> list = null;
		try {
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Country.class);
			list = criteria.list();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (session.isOpen())
				session.close();
		}

		return list;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<State> getStates(Integer countryId) {
		// TODO Auto-generated method stub
		List<State> list = null;
		try {
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();

			Criteria criteria = session.createCriteria(State.class);
			criteria.add(Restrictions.eq("countryId", countryId));
			list = criteria.list();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (session.isOpen())
				session.close();
		}

		return list;
	}

}
