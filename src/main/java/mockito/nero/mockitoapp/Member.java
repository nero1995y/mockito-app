package mockito.nero.mockitoapp;

import org.springframework.stereotype.Component;

@Component
public class Member {
    private int id;

    public int getId() {
        return id;
    }

    public void call() {
        System.out.println("call");
    }

    public void call2(String name) {

        System.out.println(name + "call2");
    }

    public String returnCall(String name) {
        return name;
    }
}
