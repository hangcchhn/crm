package hn.cch.dao.impl;

import hn.cch.dao.ContacterDao;
import hn.cch.entity.Contacter;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ContacterDaoImpl extends BaseDaoImpl<Contacter> implements ContacterDao {






	//private HibernateTemplate hibernateTemplate;
    //
	//public HibernateTemplate getHibernateTemplate() {
	//	return hibernateTemplate;
	//}
    //
	//public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	//	this.hibernateTemplate = hibernateTemplate;
	//}
    //
	//@Override
	//public void insert(Contacter contacter) {
	//	hibernateTemplate.save(contacter);
	//}
    //
	//@Override
	//public void update(Contacter contacter) {
	//	hibernateTemplate.update(contacter);
	//}
    //
	//@Override
	//public void delete(Contacter contacter) {
	//	hibernateTemplate.delete(contacter);
	//}
    //
	//@SuppressWarnings("unchecked")
	//@Override
	//public List<Contacter> selectAll() {
	//	List<Contacter> contacters = (List<Contacter>) hibernateTemplate
	//			.find("FROM Contacter");
	//	return contacters;
	//}
    //
	//@Override
	//public Contacter selectOne(int contacterId) {
	//	return hibernateTemplate.get(Contacter.class, contacterId);
	//}

    @Override
    public List<Contacter> selectWhere(Contacter contacter) {

        ////第一种
        ////find hql
        //String hql = "FROM Contacter WHERE 0 = 0";
        ////参数列表
        //List<Object> params = new ArrayList<Object>();
        ////判断条件是否拼接
        //if (contacter.getCustomer().getCustomerId() != null && contacter.getCustomer().getCustomerId() > 0){
        //    hql += " AND customer.customerId = ?";
        //    params.add(contacter.getCustomer().getCustomerId());
        //}
        //if (contacter.getContacterName() != null && !contacter.getContacterName().equals("")){
        //    hql += " AND contacterName = ?";
        //    params.add(contacter.getContacterName());
        //}
        //if (contacter.getContacterGender() != null && !contacter.getContacterGender().equals("")){
        //    hql += " AND contacterGender = ?";
        //    params.add(contacter.getContacterGender());
        //}
        //if (contacter.getContacterPhone() != null && !contacter.getContacterPhone().equals("")){
        //    hql += " AND contacterPhone = ?";
        //    params.add(contacter.getContacterPhone());
        //}
        //List<Contacter> contacters = (List<Contacter>) this.getHibernateTemplate().find(hql, params.toArray());





        //第二种
        //findByCriteria
        DetachedCriteria criteria = DetachedCriteria.forClass(Contacter.class);
        //判断条件是否拼接
        if (contacter.getContacterCustomer().getCustomerId() != null && contacter.getContacterCustomer().getCustomerId() > 0){
            criteria.add(Restrictions.eq("contacterCustomer.customerId", contacter.getContacterCustomer().getCustomerId()));
        }
        if (contacter.getContacterName() != null && !contacter.getContacterName().equals("")){
            criteria.add(Restrictions.eq("contacterName", contacter.getContacterName()));
        }
        if (contacter.getContacterGender() != null && !contacter.getContacterGender().equals("")){
            criteria.add(Restrictions.eq("contacterGender", contacter.getContacterGender()));
        }
        if (contacter.getContacterPhone() != null && !contacter.getContacterPhone().equals("")){
            criteria.add(Restrictions.eq("contacterPhone", contacter.getContacterPhone()));
        }
        List<Contacter> contacters = (List<Contacter>) this.getHibernateTemplate().findByCriteria(criteria);
        
        return contacters;
    }
    

}
