package ru.naumen.collection.task2;

import java.util.*;

/**
 * Дано:
 * <pre>
 * public class User {
 *     private String username;
 *     private String email;
 *     private byte[] passwordHash;
 *     …
 * }
 * </pre>
 * Нужно реализовать метод
 * <pre>
 * public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB);
 * </pre>
 * <p>который возвращает дубликаты пользователей, которые есть в обеих коллекциях.</p>
 * <p>Одинаковыми считаем пользователей, у которых совпадают все 3 поля: username,
 * email, passwordHash. Дубликаты внутри коллекций collA, collB можно не учитывать.</p>
 * <p>Метод должен быть оптимален по производительности.</p>
 * <p>Пользоваться можно только стандартными классами Java SE.
 * Коллекции collA, collB изменять запрещено.</p>
 *
 * См. {@link User}
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class Task2 {
    /**
     * Возвращает дубликаты пользователей, которые есть в обеих коллекциях
     */
    public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB) {
        // Используем HashSet для хранения пользователей из collA
        Set<User> userSet = new HashSet<>(collA);

        // Список для хранения дубликатов
        List<User> duplicates = new ArrayList<>();

        // Теперь проверим, есть ли совпадения в collB
        for (User user : collB) {
            if (userSet.contains(user)) { // Если объект с таким же hashCode и equals() уже есть в userSet
                duplicates.add(user); // Добавляем пользователя в список дубликатов
            }
        }
        return duplicates;
        // Общая сложность алгоритма — O(n + m),
        // где n — количество пользователей в collA,
        // а m — количество пользователей в collB.
    }
}
