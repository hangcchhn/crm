package hn.cch.dao.impl;

import hn.cch.dao.CustomerDao;
import hn.cch.entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.HashMap;
import java.util.List;

/**
 * 用户数据库访问实现
 */

public class CustomerDaoImpl implements CustomerDao {

    //使用hibernate框架实现数据库访问层的增删改查
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void insert(Customer customer) {
        hibernateTemplate.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        hibernateTemplate.delete(customer);
    }

    @Override
    public void update(Customer customer) {
        hibernateTemplate.update(customer);
    }

    //查询所有记录
    @Override
    public List<Customer> selectAll() {
        List<Customer> customers = (List<Customer>) hibernateTemplate
                .find("FROM Customer");
        return customers;
    }

    //根据主键查询
    @Override
    public Customer selectOne(int customerId) {
        return hibernateTemplate.get(Customer.class, customerId);
    }

    //查询记录数量
    @Override
    public int selectCount() {
        List<Object> list = (List<Object>) hibernateTemplate
                .find("SELECT count(*) FROM Customer");
        if (list != null && list.size() != 0) {
            Long l = (Long) list.get(0);
            return l.intValue();
        }
        return 0;
    }

    //分页查询
    @Override
    public List<Customer> selectPage(int pageInit, int pageSize) {

        // 第一种
        // Query query =
        // hibernateTemplate.getSessionFactory().getCurrentSession()
        // .createQuery("FROM Customer");
        // query.setFirstResult(pageInit);
        // query.setMaxResults(pageSize);
        // List<Customer> list = query.list();

        // 第二种
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
        List<Customer> list = (List<Customer>) hibernateTemplate
                .findByCriteria(criteria, pageInit, pageSize);

        return list;
    }

    //名称查询
    @Override
    public List<Customer> selectName(String name) {

        // 第一种
        // Query query =
        // hibernateTemplate.getSessionFactory().getCurrentSession()
        // .createQuery("FROM Customer WHERE customerName LIKE ?");
        // query.setParameter(0, "%" + name + "%");
        // List<Customer> customers = query.list();

        // 第二种
        //List<Customer> customers = (List<Customer>) hibernateTemplate.find(
        //	"FROM Customer WHERE customerName LIKE ?",
        //	"%" + name + "%");

        //第三种
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
        criteria.add(Restrictions.like("customerName", "%" + name + "%"));
        List<Customer> customers = (List<Customer>) hibernateTemplate.findByCriteria(criteria);

        return customers;
    }

    //组合查询
    public List<Customer> selectWhere(Customer customer) {

        ////第一种
        ////find() 拼接hql语句
        //String hql = "FROM Customer WHERE 0 = 0";
        ////参数列表
        //List<Object> params = new ArrayList<Object>();
        ////判断条件是否拼接
        //if (customer.getCustomerName() != null && !customer.getCustomerName().equals("")){
        //    hql += " AND customerName = ?";
        //    params.add(customer.getCustomerName());
        //}
        //if (customer.getCustomerLevel() != null && !customer.getCustomerLevel().equals("")){
        //    hql += " AND customerLevel = ?";
        //    params.add(customer.getCustomerLevel());
        //}
        //if (customer.getCustomerSource() != null && !customer.getCustomerSource().equals("")){
        //    hql += " AND customerSource = ?";
        //    params.add(customer.getCustomerSource());
        //}
        //if (customer.getCustomerMoblie() != null && !customer.getCustomerMoblie().equals("")){
        //    hql += " AND customerMoblie = ?";
        //    params.add(customer.getCustomerMoblie());
        //}
        //if (customer.getCustomerPhone() != null && !customer.getCustomerPhone().equals("")){
        //    hql += " AND customerPhone = ?";
        //    params.add(customer.getCustomerPhone());
        //}
        //List<Customer> customers = (List<Customer>) hibernateTemplate.find(hql, params.toArray());


        //第二种
        //findByCriteria
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
        //判断条件是否拼接
        if (customer.getCustomerName() != null && !customer.getCustomerName().equals("")){
            criteria.add(Restrictions.eq("customerName", customer.getCustomerName()));
        }
        if (customer.getCustomerLevel() != null && !customer.getCustomerLevel().equals("")){
            criteria.add(Restrictions.eq("customerLevel", customer.getCustomerLevel()));
        }
        if (customer.getCustomerSource() != null && !customer.getCustomerSource().equals("")){
            criteria.add(Restrictions.eq("customerSource", customer.getCustomerSource()));
        }
        if (customer.getCustomerMoblie() != null && !customer.getCustomerMoblie().equals("")){
            criteria.add(Restrictions.eq("customerMoblie", customer.getCustomerMoblie()));
        }
        if (customer.getCustomerPhone() != null && !customer.getCustomerPhone().equals("")){
            criteria.add(Restrictions.eq("customerPhone", customer.getCustomerPhone()));
        }
        List<Customer> customers = (List<Customer>) hibernateTemplate.findByCriteria(criteria);



        return customers;

    }

    //级别统计
    @Override
    public List countLevel() {

        String sql = "SELECT levelName, COUNT(*) AS levelCount  FROM customer, level WHERE customer.levelId = level.levelId GROUP BY levelName";

        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

        Query query = session.createSQLQuery(sql);

        query.setResultTransformer(Transformers.aliasToBean(HashMap.class));

        List list = query.list();

        return list;
    }

    //来源统计
    @Override
    public List countSource() {
        String sql = "SELECT sourceName, COUNT(*) AS sourceCount  FROM customer, source WHERE customer.sourceId = source.sourceId GROUP BY sourceName";

        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

        Query query = session.createSQLQuery(sql);

        query.setResultTransformer(Transformers.aliasToBean(HashMap.class));

        List list = query.list();

        return list;
    }

}
