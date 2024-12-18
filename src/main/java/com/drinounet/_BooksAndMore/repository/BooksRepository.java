package com.drinounet._BooksAndMore.repository;

import com.drinounet._BooksAndMore.datas.BooksDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<BooksDTO, Integer> {

}
