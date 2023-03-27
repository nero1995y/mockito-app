package mockito.nero.mockitoapp.mail;

public class MailService {

    private final MailRepository mailRepository = new MailRepository();
    private final advertisement advertisement = new advertisement();

    public String sand() {

        // 여길 모킹해보자
        advertisement.getName();

        return mailRepository.create();
    }
}
