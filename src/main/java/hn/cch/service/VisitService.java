package hn.cch.service;

import hn.cch.entity.Visit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface VisitService {

	public void insert(Visit visit);

	public List<Visit> selectAll();

	public Visit selectOne(int visitId);

	public void update(Visit visit);

	public void delete(Visit visit);

	public List<Visit> selectContent(String content);

	public List<Visit> selectWhere(Visit visit);

}
