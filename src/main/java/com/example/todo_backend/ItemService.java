package com.example.todo_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    public Optional<Item> updateItem(Long id, Item updatedItem) {
        return itemRepository.findById(id).map(item -> {
            item.setDescription(updatedItem.getDescription());
            item.setComplete(updatedItem.getComplete());
            item.setDueDate(updatedItem.getDueDate());
            return itemRepository.save(item);
        });
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}