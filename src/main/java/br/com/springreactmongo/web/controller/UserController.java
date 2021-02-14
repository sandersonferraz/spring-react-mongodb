package br.com.springreactmongo.web.controller;

import br.com.springreactmongo.web.Repository.UserRepository;
import br.com.springreactmongo.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> listAll(){
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public User list(@PathVariable String id){
        return userRepository.findById(id).orElse(null);
    }
    
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user ) {
        return userRepository.save(user);
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public User update(@RequestBody User newUser){
        User oldUser = userRepository.findById(newUser.getId()).orElse(null);
        oldUser.setName(newUser.getName());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setPassword(newUser.getPassword());
        return oldUser;
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
        userRepository.deleteById(id);
        return id;
    }

    

}
