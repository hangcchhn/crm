package hn.cch.dao.impl;

import hn.cch.dao.BaseDao;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author CCH
 * @version 2018.06.13.
 */

/**
 * 抽取实现类
 *
 * @param <T> 泛型
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    //泛型类型
    private Class tClass;

    public BaseDaoImpl() {
        //获取对象类型
        Class clazz = this.getClass();
        //获取超类参数类型
        ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
        //System.out.println(type);
        //获取实际参数类型
        Type[] types = type.getActualTypeArguments();
        this.tClass = (Class) types[0];
    }


    @Override
    public void insert(T t) {
        this.getHibernateTemplate().save(t);

    }

    @Override
    public void update(T t) {
        this.getHibernateTemplate().update(t);

    }

    @Override
    public void delete(T t) {
        this.getHibernateTemplate().delete(t);

    }

    @Override
    public List<T> selectAll() {
        return (List<T>) this.getHibernateTemplate().find("FROM " + this.tClass.getSimpleName());
    }

    @Override
    public T selectOne(int tId) {
        return (T) this.getHibernateTemplate().get(this.tClass, tId);
    }



}
