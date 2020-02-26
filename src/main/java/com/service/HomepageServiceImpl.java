package com.service;

import com.dao.HomepageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomepageServiceImpl implements HomepageService
{
    @Autowired
    private HomepageDao homepageDao;

    @Override
    public String getCountryNameByCountryId(String countryId) {
        return homepageDao.getCountryNameByCountryId(countryId);
    }
}
