package org.internetstore.service;

import org.internetstore.entity.Goods;
import org.internetstore.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService implements IGoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Goods saveGood(Goods good) {
        return goodsRepository.save(good);
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsRepository.findAll();
    }

    @Override
    public Boolean deleteGood(int id) {
        Goods good = goodsRepository.findById(id).orElse(null);
        if (good != null) {
            goodsRepository.delete(good);
            return true;
        }
        return false;
    }
}
