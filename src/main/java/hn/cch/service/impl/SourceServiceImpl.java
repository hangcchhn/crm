package hn.cch.service.impl;

import hn.cch.dao.SourceDao;
import hn.cch.entity.Source;
import hn.cch.service.SourceService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public class SourceServiceImpl implements SourceService {

	private SourceDao sourceDao;

	public SourceDao getSourceDao() {
		return sourceDao;
	}

	public void setSourceDao(SourceDao sourceDao) {
		this.sourceDao = sourceDao;
	}

	@Override
	public List<Source> selectAll() {
		return sourceDao.selectAll();
	}

}
