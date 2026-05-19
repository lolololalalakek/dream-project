package uz.stajirovka.repository;

import uz.stajirovka.entity.BookEntity;

import java.util.HashMap;
import java.util.Map;

public class BookRepository {

    private final Map<String, BookEntity> storage = new HashMap<>();

    public BookRepository() {
        storage.put("norwegian wood", new BookEntity(1L, "Norwegian Wood", "Haruki Murakami", 400_000L));
        storage.put("khtulkus call", new BookEntity(2L, "Khtulkus call", "Howard LoveCraft", 300_000L));
    }

    public BookEntity findByTitle(String title) {
        if (title == null) {
            System.out.println("Title is null");
            throw new IllegalArgumentException("Title is null");
        }
        return storage.get(title.toLowerCase());
    }
}