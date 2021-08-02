package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessSuccessTest {

    @Test
    @DisplayName("saveSpeaker success")
    public void case012() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("kanyarat");
        speaker.setLastName("nasomboon");
        speaker.setEmail("kanyarat@gmail.com");
        speaker.setExp(5);
        SpeakerRepository repository = new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return 1;
            }
        };
        Integer actualresult = registerBusiness.register(repository, speaker);
        assertEquals(1, actualresult);
    }
}