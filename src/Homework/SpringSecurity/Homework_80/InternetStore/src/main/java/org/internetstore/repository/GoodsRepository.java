package org.internetstore.repository;

import org.internetstore.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {
    List<Goods> findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(String ch, String ch2);
    Page<Goods> findByCategory (Pageable pageable, String category);
    Page<Goods> findAllBy (Pageable pageable);
}
