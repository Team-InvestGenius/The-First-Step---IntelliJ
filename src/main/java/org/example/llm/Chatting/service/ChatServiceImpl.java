package org.example.llm.Chatting.service;

import jakarta.transaction.Transactional;
import org.example.llm.Chatting.entity.ChatRoom;
import org.example.llm.Chatting.repository.chatContentsRepository;
import org.example.llm.Chatting.repository.chatRoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ChatServiceImpl implements ChatService{

    private final chatRoomRepository chatRoomRepository;

    private final chatContentsRepository chatContentsRepository;


    public ChatServiceImpl(org.example.llm.Chatting.repository.chatRoomRepository chatRoomRepository, org.example.llm.Chatting.repository.chatContentsRepository chatContentsRepository) {

        this.chatRoomRepository = chatRoomRepository;
        this.chatContentsRepository = chatContentsRepository;
    }


    public ChatRoom createChatRoom(String userId) {
        long count = chatRoomRepository.countByUserId(userId);
        if (count >= 3) {
            throw new RuntimeException("User can't create more than 3 chat rooms");
        }

        String roomName = "ChatRoom " + (count + 1);

        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setUserId(userId);
        chatRoom.setName(roomName);
        chatRoom.setOpenedAt(LocalDateTime.now());

        return chatRoomRepository.save(chatRoom);
    }

    public List<ChatRoom> getChatRooms(String userId) {
        return chatRoomRepository.findByUserIdOrderByOpenedAtDesc(userId);
    }


    public void deleteChatRoom(Long roomId, String userId) throws Exception {
        Optional<ChatRoom> chatRoom = chatRoomRepository.findByRoomIdAndUserId(roomId, userId);
        if (chatRoom.isPresent()) {
            chatRoomRepository.delete(chatRoom.get());
        } else {
            throw new Exception("Chat room not found or user not authorized");
        }
    }



}
