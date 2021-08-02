package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterFeeTest {

    @Test
    @DisplayName("ทดสอบการคำนวณค่า fee จากประสบการณ์ทำงาน")
    void getFee() {
        // Arrange == Given == Pre Condition
        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act == When == Action == Call target method
//        int feeResult = registerBusiness.getFee(1);
        // Assert == Validate with expected result
        assertEquals(500,registerBusiness.getFee(1));
        assertEquals(250,registerBusiness.getFee(3));
        assertEquals(100,registerBusiness.getFee(5));
        assertEquals(50,registerBusiness.getFee(9));
        assertEquals(0,registerBusiness.getFee(10));
    }
}