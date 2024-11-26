package org.internetstore.service;

import org.internetstore.entity.Goods;

import java.util.List;

public interface IGoodsService {
    public Goods saveGood(Goods good);
    public List<Goods> getAllGoods();
    public Boolean deleteGood(int id);
}
