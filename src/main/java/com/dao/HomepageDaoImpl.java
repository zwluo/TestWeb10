package com.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HomepageDaoImpl implements HomepageDao
{
    @Autowired
    private SessionFactory mysqlSessionFactory;

    @Override
    public String getCountryNameByCountryId(String countryId) {
        String sql = "select countryname from country where id = :countryId";
        return String.valueOf(mysqlSessionFactory.getCurrentSession().createSQLQuery(sql).setParameter("countryId", countryId).uniqueResult());
    }
}
