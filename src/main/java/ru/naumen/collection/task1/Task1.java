package ru.naumen.collection.task1;

import java.util.HashMap;
import java.util.Map;

/**
 * Дано:
 * <pre>
 * public class Ticket {
 *     private long id;
 *     private String client;
 *     …
 * }</pre>
 * <p>Разработать программу для бармена в холле огромного концертного зала.
 * Зрители в кассе покупают билет (класс Ticket), на котором указан идентификатор билета (id) и имя зрителя.
 * При этом, есть возможность докупить наборы разных товаров (комбо-обед): нет товаров, напитки, еда и напитки.
 * Доп. услуги оформляются через интернет и привязываются к билету, но хранятся отдельно от билета
 * (нельзя добавить товары в класс Ticket).</p>
 * <p>Бармен сканирует билет и получает объект Ticket. По этому объекту нужно уметь
 * находить необходимые товары по номеру билета. И делать это нужно очень быстро,
 * ведь нужно как можно быстрее всех накормить.</p>
 * <p>
 * См. {@link Ticket}
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class Task1
{
    // Хранение товаров по id билета
    // Я использовал HashMap потому что он очень быстр и в среднем его сложность составляет O(1)
    // В худшем случае(в случае сильных коллизий) сложность O(n),
    private Map<Long, Goods> ticketGoodsMap = new HashMap<>();

    public enum Goods {
        /**
         * нет товаров
         */
        EMPTY,
        /**
         * напитки
         */
        DRINKS,
        /**
         * еда и напитки
         */
        FOOD_AND_DRINKS
    }
    /**
     * Пример метода для добавления товара для билета.
     */
    public void addGoodsForTicket(Ticket ticket, Goods goods){
        ticketGoodsMap.put(ticket.getId(), goods);
    }
    /**
     * Получить товары по билету
     */
    public Goods getGoods(Ticket ticket) {
        return ticketGoodsMap.getOrDefault(ticket.getId(), Goods.EMPTY);
    }
}
