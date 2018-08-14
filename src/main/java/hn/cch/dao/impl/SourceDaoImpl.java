package hn.cch.dao.impl;

import hn.cch.dao.SourceDao;
import hn.cch.entity.Source;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class SourceDaoImpl implements SourceDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Source> selectAll() {
		List<Source> sources = (List<Source>) hibernateTemplate.find("FROM Source");
		return sources;
	}

}
