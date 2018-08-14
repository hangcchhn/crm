package hn.cch.service.impl;

import hn.cch.dao.ContacterDao;
import hn.cch.entity.Contacter;
import hn.cch.service.ContacterService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ContacterServiceImpl implements ContacterService {

	private ContacterDao contacterDao;

	public ContacterDao getContacterDao() {
		return contacterDao;
	}

	public void setContacterDao(ContacterDao contacterDao) {
		this.contacterDao = contacterDao;
	}

	@Override
	public void insert(Contacter contacter) {
		contacterDao.insert(contacter);
	}

	@Override
	public List<Contacter> selectAll() {
		return contacterDao.selectAll();
	}

	@Override
	public Contacter selectOne(int contacterId) {
		return contacterDao.selectOne(contacterId);
	}

	@Override
	public void update(Contacter contacter) {
		contacterDao.update(contacter);
	}

	@Override
	public void delete(Contacter contacter) {
		contacterDao.delete(contacter);
		
	}

	@Override
	public List<Contacter> selectWhere(Contacter contacter) {
		return contacterDao.selectWhere(contacter);
	}

}
