package mockito.nero.mockitoapp.mail;

import lombok.Getter;

@Getter
public class Mail {

    private static final String MESSAGE = "메일을 보냈습니다.";
    private String name;
    private int size;

    public String getMessage() {
        return MESSAGE;
    }
}
