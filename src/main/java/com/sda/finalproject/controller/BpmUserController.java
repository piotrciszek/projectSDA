//package com.sda.finalproject.controller;
//
//import com.sda.finalproject.domain.dto.BpmUserDto;
//import com.sda.finalproject.domain.dto.RegisterBpmUserDto;
//import com.sda.finalproject.domain.dto.UnregisterBpmUserDto;
//import com.sda.finalproject.manger.BpmUserManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
///*
//@CrossOrigin
//*/
///*
//@RequestMapping
//*/
//public class BpmUserController {
//
//    @Autowired
//    private BpmUserManager bpmUserManager;
//
//
////    @PostMapping("/register")
////    public void registerUser(@RequestBody RegisterBpmUserDto registerBpmUserDto) {
////        bpmUserManager.registerUser(registerBpmUserDto);
////    }
//    @PostMapping("/unregister")
//    public void unregisterUsser(@RequestBody UnregisterBpmUserDto unregisterBpmUserDto) {
//        bpmUserManager.unregisterUser(unregisterBpmUserDto);
//    }
//
//
//    @GetMapping("/listUser")
//    public ResponseEntity<List<BpmUserDto>> listUser() {
//        return ResponseEntity.ok(bpmUserManager.getBpmUserList());
//    }
//
//
//}
