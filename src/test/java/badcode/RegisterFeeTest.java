package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RegisterFeeTest {

    @Test
    @DisplayName("ทดสอบการคำนวณค่า fee จากประสบการณ์ทำงาน")
    public void getFee() {
        // Arrange == Given == Pre Condition
        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act == When == Action == Call target method
//        int feeResult = registerBusiness.getFee(1);
        // Assert == Validate with expected result
        assertEquals(500, registerBusiness.getFee(1));
        assertEquals(250, registerBusiness.getFee(3));
        assertEquals(100, registerBusiness.getFee(5));
        assertEquals(50, registerBusiness.getFee(9));
        assertEquals(0, registerBusiness.getFee(10));
    }

    @ParameterizedTest
    @CsvSource({
            "0,500",
            "1,500",
            "2,250",
            "3,250",
            "4,100",
            "5,100",
            "6,50",
            "7,50",
            "8,50",
            "9,50",
            "10,0",
            "11,0"
    })
    public void getFeeWithTable(int exp, int feeExpected) {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        assertEquals(feeExpected, registerBusiness.getFee(exp));
    }
}