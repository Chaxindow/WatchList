package com.spring_demo.watch_list.dao;

import com.spring_demo.watch_list.entity.ContentStatus;
import com.spring_demo.watch_list.entity.UserContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserContentDAO extends JpaRepository<UserContent, Integer> {

    List<UserContent> findByUserId(String userId);

    // Kullanıcı ve içerik ID'sine göre kaydı getir (Tekil sonuç)
    Optional<UserContent> findByUserIdAndContentId(String userId, int contentId);

    // Belirli bir içeriği takip eden tüm kullanıcıları getir
    List<UserContent> findByContentId(int contentId);

    // Kullanıcının belirli bir içerikteki durumunu getir
    List<UserContent> findByUserIdAndStatus(String userId, ContentStatus status);
}
