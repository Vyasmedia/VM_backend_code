package com.vm.Vyas_Media.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.vm.Vyas_Media.Entity.MovetoTrash;
import com.vm.Vyas_Media.Service.MovetoTrashService;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/cms")
public class MovetoTrashController {

	    @Autowired MovetoTrashService userService;

	    /** @Controller & @RestController
	     * Removing @ResponseBody from methods findAll,save will results in 404 Not Found "path": "/users/list"
	     * Is @ResponseBody is mandatory?
	     *   -> Use RestController which is combination of @Controller and @ResponseBody
	     *   -> We can use ResponseEntity to resolve 404 Not Found without using @ResponseBody
	     */

	    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
	    public @ResponseBody MovetoTrash save(@RequestBody MovetoTrash user) {
	        user = userService.save(user);
	        return user;
	    }

	    @GetMapping(value = "/list")
	    public @ResponseBody List<MovetoTrash> findAll() {
	        List<MovetoTrash> users = userService.findAll();
	        return users;
	    }

	    @GetMapping(value = "/list/error")
	    public List<MovetoTrash> findAllWithError() {
	        List<MovetoTrash> users = userService.findAll();
	        return users;
	    }

	    @GetMapping(value = "/response-entity/list")
	    public ResponseEntity<List<MovetoTrash>> findAllWithResponseEntity() {
	        List<MovetoTrash> users = userService.findAll();
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }

	    @GetMapping(value = "/headline")
	    public @ResponseBody MovetoTrash findUserByContact(@RequestParam(value = "headline") String headline) {
	    	MovetoTrash user = userService.findByHeadline(headline);
	        return user;
	    }

	    @GetMapping(value = "/user/{id}")
	    public @ResponseBody Optional<MovetoTrash>  findUserById(@PathVariable Integer id) {
	        Optional<MovetoTrash> user = userService.findById(id); 
	        return user;
	    }

	    @DeleteMapping("/delete/{id}")
	    public void deleteUser(@PathVariable Integer id) {
	        userService.delete(id);
	    }
	}
