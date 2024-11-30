package org.internetstore.service;

import org.internetstore.entity.Goods;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IGoodsService {
    public Goods saveGood(Goods good);
    public List<Goods> getAllGoods();
    public Boolean deleteGood(int id);
    public Goods getGoodById(int id);
    public List<Goods> getGoodsByCategory(String name);
    public List<Goods> searchGoods(String ch);
    public Page<Goods> getAllGoodsPagination(Integer pageNo, Integer pageSize, String category);
}
