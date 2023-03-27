package mockito.nero.mockitoapp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class mockitoTest {

    @Mock
    private Member member;

    @DisplayName("mock 연습해보기")
    @Test
    void mock() {

        member.call();

        verify(member).call();

        // 호출이 없는 것을 검증한다.
        verify(member, never()).call2(anyString());
    }

    @DisplayName("호출 횟수를 검증한다")
    @Test
    void mock2() {

        for (int i = 0; i < 3; i++) {
            member.call();
        }

        verify(member, times(3)).call();
    }

    @DisplayName("atLeast, atMost 함께 사용하면 메소드 호출 최소/최대 횟수를 검증한다")
    @Test
    void mock3() {
        for (int i = 0; i < 3; i++) {
            member.call();
        }

        // 최소
        verify(member, atLeast(2)).call();

        // 최대
        verify(member, atMost(4)).call();
    }

    @DisplayName("argument를 제공하면 argument를 검증한다")
    @Test
    void mock4() {
        member.call2("nero");

        verify(member).call2("nero");
        // 타입 검증
        verify(member).call2(anyString());
    }

    @DisplayName("아무런 인터랙션이 없었다는 것을 증명한다")
    @Test
    void mock5() {
        verifyNoInteractions(member);
    }

    @DisplayName("inOrder")
    @Test
    void mock6() {
        member.call();
        member.call2("name");

        InOrder order = inOrder(member);

        order.verify(member).call();
        order.verify(member).call2("name");

    }

    @DisplayName("ArgumentCaptor 캡쳐한다")
    @Test
    void mock7() {
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

        member.call2("name");

        verify(member).call2(stringArgumentCaptor.capture());

        Assertions.assertThat("name").isEqualTo(stringArgumentCaptor.getValue());
    }

//    @DisplayName("thenReturn 리턴값을 지정할 수 있다")
//    @Test
//    void thenReturn() {
//
//        when(member.returnCall(any()))
//                .thenReturn("dummy return result");
//    }
}
