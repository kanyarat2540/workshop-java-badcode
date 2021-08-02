package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessTest {
    @Test
    @DisplayName("First name of Speaker มีค่าเป็น null ซึ่งทำให้เกิด exception ขึ้นมา")
    public void case01() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Exception exception = assertThrows(ArgumentNullException.class, () ->
                registerBusiness.register(null, new Speaker()));
        assertEquals("First name is required.", exception.getMessage());
    }
}