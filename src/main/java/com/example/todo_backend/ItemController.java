package com.example.todo_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    // GET /api/items - gets all items
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    // GET /api/items/{id} - gets item by id
    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    // POST /api/items - create a new item
    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    // POST /api/items/{id} - update an item
    @PostMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        return itemService.updateItem(id, item).get();
    }

    // delete /api/items/{id} - deletes an item by id
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable long id) {
        itemService.deleteItem(id);
    }

}




