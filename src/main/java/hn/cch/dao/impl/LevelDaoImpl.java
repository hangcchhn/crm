package hn.cch.dao.impl;

import hn.cch.dao.LevelDao;
import hn.cch.entity.Level;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class LevelDaoImpl implements LevelDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Level> selectAll() {
		List<Level> levels = (List<Level>) hibernateTemplate.find("FROM Level");
		return levels;
	}

}
