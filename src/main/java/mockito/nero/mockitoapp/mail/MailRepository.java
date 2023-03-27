package mockito.nero.mockitoapp.mail;

public class MailRepository {

    private Mail mail = new Mail();

    public String create() {
        return mail.getMessage();
    }
}
