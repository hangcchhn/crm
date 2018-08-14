package hn.cch.dao.impl;

import hn.cch.dao.VisitDao;
import hn.cch.entity.Visit;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class VisitDaoImpl implements VisitDao {
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void insert(Visit visit) {
        hibernateTemplate.save(visit);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Visit> selectAll() {
        List<Visit> visits = (List<Visit>) hibernateTemplate.find("From Visit");
        return visits;
    }

    @Override
    public Visit selectOne(int visitId) {
        return hibernateTemplate.get(Visit.class, visitId);
    }


    @Override
    public void update(Visit visit) {
        hibernateTemplate.update(visit);
    }

    @Override
    public void delete(Visit visit) {
        hibernateTemplate.delete(visit);
    }

    @Override
    public List<Visit> selectContent(String content) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Visit.class);
        criteria.add(Restrictions.like("visitContent", "%" + content + "%"));
        List<Visit> visits = (List<Visit>) hibernateTemplate.findByCriteria(criteria);
        return visits;
    }

    @Override
    public List<Visit> selectWhere(Visit visit) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Visit.class);
        //判断条件是否拼接
        if (visit.getVisitUser().getUserId() != null && visit.getVisitUser().getUserId() > 0) {
            criteria.add(Restrictions.eq("visitUser.userId", visit.getVisitUser().getUserId()));
        }
        if (visit.getVisitCustomer().getCustomerId() != null && visit.getVisitCustomer().getCustomerId() > 0) {
            criteria.add(Restrictions.eq("visitCustomer.customerId", visit.getVisitCustomer().getCustomerId()));
        }
        if (visit.getVisitAddress() != null && !visit.getVisitAddress().equals("")) {
            criteria.add(Restrictions.eq("visitAddress", visit.getVisitAddress()));
        }
        if (visit.getVisitContent() != null && !visit.getVisitContent().equals("")) {
            criteria.add(Restrictions.eq("visitContent", visit.getVisitContent()));
        }
        List<Visit> visits = (List<Visit>) hibernateTemplate.findByCriteria(criteria);
        return visits;
    }
}
