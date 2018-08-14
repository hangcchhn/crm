package hn.cch.dao;

import hn.cch.entity.Visit;

import java.util.List;

public interface VisitDao {

	public void insert(Visit visit);

	public List<Visit> selectAll();

	public Visit selectOne(int userId);

	public void update(Visit visit);

	public void delete(Visit visit);

	public List<Visit> selectContent(String content);

	public List<Visit> selectWhere(Visit visit);

}
