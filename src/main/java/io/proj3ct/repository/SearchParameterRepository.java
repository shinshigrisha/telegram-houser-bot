package io.proj3ct.repository;


import io.proj3ct.entity.Chat;
import io.proj3ct.entity.City;
import io.proj3ct.entity.SearchParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchParameterRepository extends JpaRepository<SearchParameter, Long> {

    @Query("select s from SearchParameter s where s.chat.chatId = :chatId")
    SearchParameter getSearchParameterByChatId(@Param(("chatId")) Long chatId);

//    @Query("select s.chat from SearchParameter s where s.city = :city and s.minPrice <= :price " +
//            "and s.maxPrice >= :price and s.numberOfRoom = :numberOfRoom " +
//            "union " +
//            "")
//    List<Chat> getChatListBySearchedParameters(@Param("city") City city, @Param("price") Long price,
//                                               @Param("number_of_room") Long numberOfRoom);

    @Query("select s.chat from SearchParameter s " +
            "where s.chat.chatStage = io.proj3ct.telegramjokebot.constant.ChatStage.READY_RECEIVED " +
            "and " +
            "s.city = ?1 " +
            "and ((s.minPrice is null and ?2 >= 0L) or (s.minPrice is not null and ?2 >= s.minPrice)) " +
            "and ((s.maxPrice is null and ?2 <= 1000000L) or (s.maxPrice is not null and ?2 <= s.maxPrice)) " +
            "and (s.numberOfRoom is null or s.numberOfRoom = ?3)")
    List<Chat> getChatListBySearchParameters(@Param("city") City city, @Param("price") Long price,
                                             @Param("number_of_room") Long numberOfRoom);

}
