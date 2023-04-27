import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Шерементьево", "Сочи", 12000, 17, 24);
    Ticket ticket2 = new Ticket("Пулково", "Волгоград", 10000, 17, 22);
    Ticket ticket3 = new Ticket("Самара", "Пулково", 8000, 17, 22);
    Ticket ticket4 = new Ticket("Воронеж", "Архангельск", 17000, 17, 21);
    Ticket ticket5 = new Ticket("Пулково", "Краснодар", 15500, 17, 20);
    Ticket ticket6 = new Ticket("Пулково", "Волгоград", 12300, 17, 19);
    Ticket ticket7 = new Ticket("Пулково", "Волгоград", 12000, 17, 18);
    Ticket ticket8 = new Ticket("Самара", "Домодедово", 11000, 17, 18);
    AviaSouls souls = new AviaSouls();
    TicketTimeComparator timeComparator = new TicketTimeComparator();

    @BeforeEach
    public void setup() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);
        souls.add(ticket7);
        souls.add(ticket8);
    }

    @Test
    public void shouldCompareTicketPrice() {
        int expected = 1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);

        int expected2 = -1;
        int actual2 = ticket1.compareTo(ticket4);
        Assertions.assertEquals(expected2, actual2);

        int expected3 = 0;
        int actual3 = ticket1.compareTo(ticket7);
        Assertions.assertEquals(expected3, actual3);
    }

    @Test
    public void shouldSearchTicketsAndShowInRisingPrice() {
        Ticket[] expected = {ticket2, ticket7, ticket6};
        Ticket[] actual = souls.search("Пулково", "Волгоград");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestOfComparator() {

        Assertions.assertEquals(1, timeComparator.compare(ticket1, ticket3));
        Assertions.assertEquals(-1, timeComparator.compare(ticket5, ticket4));
        Assertions.assertEquals(0, timeComparator.compare(ticket7, ticket8));
    }

    /* @Test
     public void testOfComparator1() {
         TicketTimeComparator timeComparator = new TicketTimeComparator();

         Ticket[] arr = {ticket5,ticket6};
         Ticket[] expected = {ticket6,ticket5};
         Arrays.sort(arr, timeComparator);
         Assertions.assertArrayEquals(arr, expected);
     }

     */
    @Test
    public void shouldSearchAndSortForMoreTimeFlight() {
        Ticket[] expected = {ticket7, ticket6, ticket2};
        Ticket[] actual = souls.searchAndSortBy("Пулково", "Волгоград", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }


}
