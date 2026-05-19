package uz.stajirovka.cache;

import uz.stajirovka.exception.SorryException;
import uz.stajirovka.entity.BookEntity;

import java.util.HashMap;
import java.util.Map;

public class BookCache {
    private final Map<String, BookEntity> cache = new HashMap<>();

    public BookEntity get(String title) {
        if (title == null) {
            throw new SorryException();
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
