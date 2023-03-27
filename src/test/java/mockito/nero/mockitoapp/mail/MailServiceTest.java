package mockito.nero.mockitoapp.mail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MailServiceTest {

    @Mock
    private advertisement advertisement;

    @InjectMocks
    private MailService mailService;


    @DisplayName("모킹 테스트해보자")
    @Test
    void mockTest() {

        //mocking
        doNothing().when(advertisement).getName();

        //when
        mailService.sand();
    }


}