package hn.cch.service.impl;

import hn.cch.dao.LevelDao;
import hn.cch.entity.Level;
import hn.cch.service.LevelService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public class LevelServiceImpl implements LevelService {

	private LevelDao levelDao;

	public LevelDao getLevelDao() {
		return levelDao;
	}

	public void setLevelDao(LevelDao levelDao) {
		this.levelDao = levelDao;
	}


	@Override
	public List<Level> selectAll() {
		return levelDao.selectAll();
	}

}
