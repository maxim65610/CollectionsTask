package ru.naumen.collection.task1;

import java.util.Objects;

/**
 * Билет
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class Ticket {
    private long  id;
    private String client;

    /**
     * Переопределяет метод hashCode() для генерации хеш-кода
     * на основе уникального идентификатора билета.
     *
     * @return хеш-код для объекта Ticket, основанный на его уникальном идентификаторе (id).
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);  // Используем id для хеширования
    }
    /**
     * Переопределяет метод equals() для сравнения двух объектов Ticket.
     * Сравнение осуществляется по уникальному идентификатору билета (id).
     *
     * @param obj объект, с которым проводится сравнение.
     * @return true, если объекты одинаковы по id; false в противном случае.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Ticket ticket = (Ticket) obj;
        return id == ticket.id;  // Сравниваем только по id
    }
}
