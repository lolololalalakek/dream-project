package uz.stajirovka;

import uz.stajirovka.cache.BookCache;
import uz.stajirovka.entity.BookEntity;
import uz.stajirovka.repository.BookRepository;
import uz.stajirovka.service.BookService;

public class Main {
    public static void main(String[] args) {


        BookService service = new BookService(new BookCache(), new BookRepository());

        System.out.println();
        System.out.println();
        BookEntity firstCall = service.findByTitle("Khtulkus call");
        System.out.println("First call result: " + firstCall);

        System.out.println();
        System.out.println();

        BookEntity secondCall = service.findByTitle("KHTULkus call");
        System.out.println("Second call result: " + secondCall);

        System.out.println();
        System.out.println();
        BookEntity missing = service.findByTitle("sad call");
        System.out.println("Missing result: " + missing);
    }
}
