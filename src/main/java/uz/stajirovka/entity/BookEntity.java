package uz.stajirovka.entity;

public record BookEntity(

    Long id,
    String title,
    String author,
    Long price) {
}
