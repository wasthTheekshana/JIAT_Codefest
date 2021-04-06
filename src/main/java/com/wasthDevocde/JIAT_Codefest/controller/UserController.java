package com.wasthDevocde.JIAT_Codefest.controller;

import com.wasthDevocde.JIAT_Codefest.model.User;
import com.wasthDevocde.JIAT_Codefest.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    userService userService;

    @GetMapping
    public List<User> hello() {
        return userService.getUsers();
    }

    @PostMapping(path = "/save")
    public String saveUserReturnString(@RequestBody @RequestParam("un") String un, @RequestBody @RequestParam("pw") String pw) {

        List<User> usersByName = userService.getUsersByUserName(un);

        if(usersByName.size()==0) {
            User u = new User();
            u.setUsername(un);
            u.setPassword(pw);
            User user = userService.saveUser(u);
            return user.getUsername()+" Admin Registered";
        }else{
            return "Already Registered Word!";
        }

    }

    @PutMapping(path = "/update")
    //public User updateUser(@RequestBody @RequestParam("id") String id, @RequestBody @RequestParam("un") String un, @RequestBody @RequestParam("pw") String pw) {
    public String updateUser(@RequestBody @RequestParam("id") String id, @RequestBody @RequestParam("un") String un, @RequestBody @RequestParam("pw") String pw) {

        List<User> adminsByName = userService.getUsersByUserName(un);

        if(adminsByName.size()==0) {
            User u = new User();
            u.setId(Integer.parseInt(id));
            u.setUsername(un);
            u.setPassword(pw);
            userService.updateUser(u);
            return u.getUsername()+" Admin Updated!";
        }else{

            User user=adminsByName.get(0);
            if(Integer.parseInt(id.trim())==user.getId()){
                User u2 = new User();
                u2.setId(Integer.parseInt(id));
                u2.setUsername(un);
                u2.setPassword(pw);
                userService.updateUser(u2);
                return u2.getUsername()+" Admin Updated!";
            }else{
                return "Update Admin Name Already Registered!";
            }

        }

    }
    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

}
