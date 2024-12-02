package ru.naumen.collection.task2;

import java.util.Arrays;
import java.util.Objects;

/**
 * Пользователь
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class User {
    private String username;
    private String email;
    private byte[] passwordHash;
    /**
     * Переопределяет метод hashCode для корректной работы с хеш-коллекциями.
     * Генерирует хеш-код на основе полей username, email и passwordHash.
     * Возвращает хеш-код объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(username, email, Arrays.hashCode(passwordHash));
    }
    /**
     * Переопределяет метод equals для сравнения объектов User.
     * Сравнивает объекты по полям username, email и passwordHash.
     * Принимает объект для сравнения и возвращает true, если объекты равны, и false в противном случае.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Если оба объекта идентичны
        if (obj == null || getClass() != obj.getClass()) return false;  // Если объект другой или null

        User user = (User) obj;
        return Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Arrays.equals(passwordHash, user.passwordHash);  // Сравниваем все поля
    }
}
