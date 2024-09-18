package com.example.todo_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items/")
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
    public Item getItemById(Long id) {
        return itemService.getItemById(id);
    }

    // POST /api/items/ - create a new item
    @PostMapping
    public Item createItem(Item item) {
        return itemService.createItem(item);
    }

    // POST /api/items/{id} - update an item
    @PostMapping("/{id}")
    public Item updateItem(Long id, Item item) {
        return itemService.updateItem(id, item).get();
    }

    // delete /api/items/{id} - deletes an item by id
    @DeleteMapping("/{id}")
    public void deleteItem(long id) {
        itemService.deleteItem(id);
    }

}




