package uz.stajirovka.cache;

import uz.stajirovka.entity.BookEntity;

import java.util.HashMap;
import java.util.Map;

public class BookCache {
    private final Map<String, BookEntity> cache = new HashMap<>();

    public BookEntity get(String title) {
        if (title == null) {
            System.out.println("Title is null");
            throw new IllegalArgumentException("Title is null");
        }
        return cache.get(title.toLowerCase());
    }

    public void put(String title, BookEntity bookEntity) {
        if (title == null || bookEntity == null) {
            return;
        }
        cache.put(title.toLowerCase(), bookEntity);
    }
}
