package hn.cch.service;

import hn.cch.entity.Contacter;

import java.util.List;

public interface ContacterService {

	public void insert(Contacter contacter);

	public List<Contacter> selectAll();

	public Contacter selectOne(int contacterId);

	public void update(Contacter contacter);

	public void delete(Contacter contacter);

	public List<Contacter> selectWhere(Contacter contacter);


}
