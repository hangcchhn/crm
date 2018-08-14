package hn.cch.dao;

import hn.cch.entity.Contacter;

import java.util.List;

public interface ContacterDao extends BaseDao<Contacter> {
	
//	public void insert(Contacter contacter);
//
//	public void update(Contacter contacter);
//
//	public void delete(Contacter contacter);
//
//	public List<Contacter> selectAll();
//
//	public Contacter selectOne(int contacterId);

    public List<Contacter> selectWhere(Contacter contacter);

}
