package com.udacity.jwdnd.c1.review.mapper;

import com.udacity.jwdnd.c1.review.dtos.entity.ChatMessage;
import com.udacity.jwdnd.c1.review.dtos.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Insert("INSERT INTO MESSAGES (username, messagetext, time_sent) VALUES(#{username}, #{messageText}, #{time})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insert(ChatMessage chatMessage);

    @Select("SELECT * FROM MESSAGES WHERE username = #{userName}")
    List<ChatMessage> getMessages(String userName);
}
