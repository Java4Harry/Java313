package org.spring.mvc.service;

import org.spring.mvc.dao.TireDao;
import org.spring.mvc.entity.Tire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TireService implements ITireService{
    @Autowired
    private TireDao tireDao;
    @Override
    public int tireChoose(Tire tire){
        int i = tireDao.saveTire(tire);
        return i;
    }
}
