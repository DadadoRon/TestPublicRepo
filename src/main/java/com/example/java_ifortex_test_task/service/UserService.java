package com.example.java_ifortex_test_task.service;

import com.example.java_ifortex_test_task.dto.UserResponseDTO;
import com.example.java_ifortex_test_task.entity.DeviceType;
import com.example.java_ifortex_test_task.entity.User;
import com.example.java_ifortex_test_task.mapper.UserMapper;
import com.example.java_ifortex_test_task.repository.SessionRepository;
import com.example.java_ifortex_test_task.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;
    private final UserMapper userMapper;

    // Returns a User with the biggest amount of sessions
    public UserResponseDTO getUserWithMostSessions() {
        User user = userRepository.getUserWithMostSessions();
        return userMapper.toDto(user);
    }

    // Returns Users that have at least 1 Mobile session
    public List<UserResponseDTO> getUsersWithAtLeastOneMobileSession() {
        DeviceType deviceType = DeviceType.MOBILE;
        List<User> users = userRepository.getUsersWithAtLeastOneMobileSession(deviceType);
        return users.stream()
                .map(userMapper :: toDto)
                .collect(Collectors.toList());
    }
}
