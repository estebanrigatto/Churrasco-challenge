package com.churrasco.challenge.auth.service;

import com.churrasco.challenge.auth.dto.AuthenticationRequest;
import com.churrasco.challenge.auth.dto.UserDTO;
import com.churrasco.challenge.auth.entity.UserEntity;
import com.churrasco.challenge.auth.mapper.UserMapper;
import com.churrasco.challenge.auth.repository.UserRepository;
import com.churrasco.challenge.exception.ExceptionEnum;
import com.churrasco.challenge.exception.UserAlreadyExistException;
import com.churrasco.challenge.exception.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtTokenUtil;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);

        if (userEntity == null) {
            throw new UsernameNotFoundException(ExceptionEnum.USERNAMENOTFOUND.getMessage());
        }

        UserDetails userDetails = User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles(userEntity.getRole().toUpperCase())
                .build();

        return userDetails;
    }

    public boolean save(UserDTO userDTO) throws UserAlreadyExistException {
        UserEntity user = userRepository.findByUsernameOrEmail(userDTO.getUsername(), userDTO.getEmail());
        if (user != null) {
            throw new UserAlreadyExistException(ExceptionEnum.USERALREADYEXIST.getMessage());
        }
        UserEntity userEntity =  userRepository.save(userMapper.DTO2Entity(userDTO));

        return userEntity != null;
    }

    public String signIn(AuthenticationRequest authReq) throws Exception {

        UserDetails userDetails;
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authReq.getUsernameOrEmail(), authReq.getPassword())
            );

            userDetails = (UserDetails) auth.getPrincipal();
            return jwtTokenUtil.generateToken(userDetails);
        } catch (BadCredentialsException e) {
            throw new Exception(ExceptionEnum.INVALIDUSERNAMEORPASSWORD.getMessage(), e);
        }

    }
}
