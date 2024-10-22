package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Item;
import fr.efrei.pokemon.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(String id) {
        return itemRepository.findById(id).orElse(null);
    }

    public void save(Item item) {
        itemRepository.save(item);
    }

    public void update(String id, Item item) {
        Item existingItem = findById(id);
        if (existingItem != null) {
            existingItem.setName(item.getName());
            existingItem.setDescription(item.getDescription());
            itemRepository.save(existingItem);
        }
    }

    public void delete(String id) {
        itemRepository.deleteById(id);
    }
}
