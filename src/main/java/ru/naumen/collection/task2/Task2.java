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
public class Task2
{
    /**
     * Возвращает дубликаты пользователей, которые есть в обеих коллекциях
     */
    public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB) {
        // Используем HashSet для хранения хешей пользователей из collA
        Set<Integer> userHashes = new HashSet<>();
        // Список для хранения дубликатов
        List<User> duplicates = new ArrayList<>();

        // Пройдем по первой коллекции и добавим хеши пользователей в Set
        for (User user : collA) {
            userHashes.add(computeUserHash(user)); // хэшируем каждого пользователя с помощью метода computeUserHash
        }

        // Теперь проверим, есть ли совпадения в collB
        for (User user : collB) {
            if (userHashes.contains(computeUserHash(user))) { // если хеш присутствует в Set
                duplicates.add(user); // добавляем пользователя в список дубликатов
            }
        }
        return duplicates;
        //Общая сложность алгоритма — O(n + m),
        // где n — количество пользователей в collA,
        // а m — количество пользователей в collB.
    }
    /**
     * Метод для вычисления хеша пользователя
     */
    private static int computeUserHash(User user) {
        int result = 17;
        result = 31 * result + (user.getUsername() != null ? user.getUsername().hashCode() : 0);
        result = 31 * result + (user.getEmail() != null ? user.getEmail().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(user.getPasswordHash()); // Обрабатываем массив байтов
        return result;
    }
}
