package com.study.nosql.controller;

import com.study.nosql.domain.User;
import com.study.nosql.domain.dto.UserDTO;
import com.study.nosql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> userList = service.findAll();
        List<UserDTO> dtoList = userList.stream()
                .map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail()))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = service.findById(id);
        var dto = new UserDTO(user.getId(), user.getName(), user.getEmail());

        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO dto){
        User user = service.insert(dto);
        var dtoResponse = new UserDTO(user.getId(), user.getName(), user.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(dtoResponse);
    }

}
