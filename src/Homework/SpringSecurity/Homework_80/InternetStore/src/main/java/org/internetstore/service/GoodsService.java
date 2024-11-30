package org.internetstore.service;

import org.internetstore.entity.Goods;
import org.internetstore.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
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

    @Override
    public Goods getGoodById(int id) {
        Goods good = goodsRepository.findById(id).orElse(null);
        return good;
    }

    @Override
    public List<Goods> getGoodsByCategory(String category) {
        List<Goods> goods = goodsRepository.findAll();
        List<Goods> goodsInCategory = new ArrayList<Goods>();
        for (Goods good : goods) {
            if (good.getCategory().equals(category)) {
                goodsInCategory.add(good);
            }
        }
        return goodsInCategory;
    }

    @Override
    public List<Goods> searchGoods(String ch) {
        return goodsRepository.findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(ch, ch);
    }

    @Override
    public Page<Goods> getAllGoodsPagination(Integer pageNo, Integer pageSize, String category) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Goods> pageGoods = null;
        if (ObjectUtils.isEmpty(category)) {
            pageGoods = goodsRepository.findAllBy(pageable);
        } else {
            pageGoods = goodsRepository.findByCategory(pageable, category);
        }
        return pageGoods;
    }
}
