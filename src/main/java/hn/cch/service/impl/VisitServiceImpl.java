package hn.cch.service.impl;

import hn.cch.dao.VisitDao;
import hn.cch.entity.Visit;
import hn.cch.service.VisitService;

import java.util.List;


public class VisitServiceImpl implements VisitService {

	private VisitDao visitDao;

	public VisitDao getVisitDao() {
		return visitDao;
	}

	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}

	@Override
	public void insert(Visit visit) {
		visitDao.insert(visit);
	}

	@Override
	public List<Visit> selectAll() {
		return visitDao.selectAll();
	}

	public Visit selectOne(int visitId) {
		return visitDao.selectOne(visitId);
	}

	@Override
	public void update(Visit visit) {
		visitDao.update(visit);
	}

	@Override
	public void delete(Visit visit) {
		visitDao.delete(visit);
	}

	@Override
	public List<Visit> selectContent(String content) {
		return visitDao.selectContent(content);
	}

	@Override
	public List<Visit> selectWhere(Visit visit) {
		return visitDao.selectWhere(visit);
	}

}
