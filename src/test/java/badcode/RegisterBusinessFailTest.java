package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessFailTest {

    @Test
    @DisplayName("Can get email main")
    public void case01() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        String email = registerBusiness.getEmailDomain("kanyarat@gmail.com");
        assertEquals("gmail.com", email);
    }

    @Test
    @DisplayName("Can't get email main")
    public void case02() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Exception exception = assertThrows(DomainEmailInvalidException.class, () -> registerBusiness.getEmailDomain("kanyarat๑gmail.com"));
        assertSame(DomainEmailInvalidException.class, exception.getClass());
    }

    @Test
    @DisplayName("test getFee: exp <= 1")
    public void case03() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        int fee = registerBusiness.getFee(1);
        assertEquals(500, fee);
    }

    @Test
    @DisplayName("test getFee: exp <= 3")
    public void case04() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        int fee = registerBusiness.getFee(3);
        assertEquals(250, fee);
    }

    @Test
    @DisplayName("test getFee: exp <= 5")
    public void case05() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        int fee = registerBusiness.getFee(5);
        assertEquals(100, fee);
    }

    @Test
    @DisplayName("test getFee: exp <= 9")
    public void case06() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        int fee = registerBusiness.getFee(9);
        assertEquals(50, fee);
    }

    @Test
    @DisplayName("test getFee: exp > 9")
    public void case07() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        int fee = registerBusiness.getFee(10);
        assertEquals(0, fee);
    }

    @Test
    @DisplayName("First name of Speaker มีค่าเป็น null ซึ่งทำให้เกิด exception ขึ้นมา")
    public void case08() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Exception exception = assertThrows(ArgumentNullException.class, () ->
                registerBusiness.register(null, new Speaker()));
        assertEquals("First name is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Last name of Speaker มีค่าเป็น null ซึ่งทำให้เกิด exception ขึ้นมา")
    public void case09() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("kanyarat");
        Exception exception = assertThrows(ArgumentNullException.class, () ->
                registerBusiness.register(null, speaker));
        assertEquals("Last name is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Email of Speaker มีค่าเป็น null ซึ่งทำให้เกิด exception ขึ้นมา")
    public void case010() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("kanyarat");
        speaker.setLastName("nasomboon");
        Exception exception = assertThrows(ArgumentNullException.class, () ->
                registerBusiness.register(null, speaker));
        assertEquals("Email is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Email of Speaker domain ไม่ได้อยู่ใน list ของ domain ทั้งหมด ซึ่งทำให้เกิด exception ขึ้นมา")
    public void case011() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("kanyarat");
        speaker.setLastName("nasomboon");
        speaker.setEmail("demo@xxx.com");
        Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> {
            registerBusiness.register(null, speaker);
        });
        assertEquals("Speaker doesn't meet our standard rules.", exception.getMessage());
    }

    @Test
    @DisplayName("saveSpeaker fail")
    public void case013() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("kanyarat");
        speaker.setLastName("nasomboon");
        speaker.setEmail("kanyarat@gmail.com");
        speaker.setExp(5);
        Exception exception = assertThrows(SaveSpeakerException.class, () -> {
            registerBusiness.register(null, speaker);
        });
        assertEquals("Can't save a speaker.", exception.getMessage());
    }
}