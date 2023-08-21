package com.vm.Vyas_Media.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vm.Vyas_Media.Entity.MovetoTrash;
import com.vm.Vyas_Media.Service.MovetoTrashService;

@RestController
@RequestMapping("/users/rest")
public class MovetoTrashRestController {

    @Autowired MovetoTrashService userService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<MovetoTrash>> findAll(@RequestParam(value = "isDeleted", required = false, defaultValue = "false") boolean isDeleted) {
        List<MovetoTrash> users = userService.findAllFilter(isDeleted);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}
