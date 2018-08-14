package hn.cch.dao;

import java.util.List;

/**
 * @author CCH
 * @version 2018.06.13.
 */

/**
 * 抽取接口
 * @param <T> 泛型
 */
public interface BaseDao<T> {


    public void insert(T t);

    public void update(T t);

    public void delete(T t);

    public List<T> selectAll();

    public T selectOne(int tId);

    //public List<T> selectWhere(T t);
}
