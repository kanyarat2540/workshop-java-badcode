package badcode;

import java.util.Arrays;

public class RegisterBusiness {

    public Integer register(SpeakerRepository repository, Speaker speaker) {
        Integer speakerId;
        String[] domains = {"gmail.com", "live.com"};

        if (!haveValue(speaker.getFirstName())) {
            throw new ArgumentNullException("First name is required.");
        }
        if (!haveValue(speaker.getLastName())) {
            throw new ArgumentNullException("Last name is required.");
        }
        if (!haveValue(speaker.getEmail())) {
            throw new ArgumentNullException("Email is required.");
        }

        // Your Tasks ...
        String emailDomain = getEmailDomain(speaker.getEmail()); // Avoid ArrayIndexOutOfBound
        boolean isEmailInDomain = Arrays.stream(domains).filter(emailDomain::equals).count() == 1;
        if (!isEmailInDomain)
            throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");

        int exp = speaker.getExp();
        speaker.setRegistrationFee(getFee(exp));

        try {
            speakerId = repository.saveSpeaker(speaker);
        } catch (Exception exception) {
            throw new SaveSpeakerException("Can't save a speaker.");
        }

        return speakerId;
    }

    int getFee(int exp) {
        int fee = 0;
        if (exp <= 1) {
            fee = 500;
        } else if (exp <= 3) {
            fee = 250;
        } else if (exp <= 5) {
            fee = 100;
        } else if (exp <= 9) {
            fee = 50;
        }
        return fee;
    }

    public String getEmailDomain(String email) {
        String[] inputs = email.trim().split("@");
        if (inputs.length == 2) return inputs[1];
        throw new DomainEmailInvalidException();
    }

    private Boolean haveValue(String value) {
        return value != null && !value.trim().equals("");
    }
}
