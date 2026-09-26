package com.elshamy.spring;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello/{username}")
    public ResponseEntity<String> hello(@PathVariable("username") String name){
        return ResponseEntity.ok("Hello %s".formatted(name));
    }

    @GetMapping("/search")
    public ResponseEntity<String> search(@RequestParam String name){
        return ResponseEntity.status(HttpStatus.FOUND.value()).body("Searching for: " + name);
    }

    @GetMapping("/calculate")
    public ResponseEntity<Integer> calculate(@RequestParam int num1, @RequestParam int num2){
        return ResponseEntity.ok(num1 + num2);
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED.value()).body( "User: " + user.getName() + ", Age: " + user.getAge());

    }


    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") int id, @RequestBody User user){
        return ResponseEntity.ok("Updating user " + id + ": " + user.getName() + ", Age: " + user.getAge());
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body("Deleting user with id: " + id);
    }
}
