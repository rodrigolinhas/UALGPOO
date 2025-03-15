import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class T2timeTests {

    @Test
    public void testConstructor0() {
        assertEquals(0,new T2time(0).asSeconds());
        assertEquals(3661, new T2time(3661).asSeconds());
        assertEquals(48435, new T2time(48435).asSeconds());
    }

    @Test
    public void testConstructor1() {
        assertThrows(IllegalArgumentException.class, () -> {new T2time(-1);});
    }

    @Test
    public void testConstructor2() {
        assertThrows(IllegalArgumentException.class, () -> {new T2time(48436);});
    }

    @Test
    public void testtoString0() {
        assertEquals("00:00:00", new T2time( 0).toString());
        assertEquals("00:00:01", new T2time( 1).toString());
        assertEquals("01:01:01", new T2time(3661).toString());
        assertEquals("13:27:15", new T2time(T2time.T2DAYSECONDS-1).toString());
    }

    @Test
    public void testAdd() {
        assertEquals("00:00:00",
                (new T2time(0,0,0).add(new T2time(0,0,0))).toString());
        assertEquals("00:00:01",
                (new T2time(0,0,1).add(new T2time(0,0,0))).toString());
        assertEquals("00:00:00",
                (new T2time(13,27,15).add(new T2time(0,0,1))).toString());
        assertEquals("00:00:01",
                (new T2time(13,27,15).add(new T2time(0,0,2))).toString());
        assertEquals("01:01:01",
                (new T2time(13,27,15).add(new T2time(1,1,2))).toString());
    }

    @Test
    public void testIsTime() {
        // Casos válidos
        assertTrue(T2time.isTime("00:00:00"));
        assertTrue(T2time.isTime("13:27:15")); // Máximo permitido pelo T2time
        assertTrue(T2time.isTime("01:30:45"));
        assertTrue(T2time.isTime("13:59:59")); // Formato válido (mas valor excede T2DAYSECONDS)
    }
}