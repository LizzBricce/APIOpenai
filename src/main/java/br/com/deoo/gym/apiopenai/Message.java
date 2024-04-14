package br.com.deoo.gym.apiopenai;

public class Message {
    private String role;
    private String content;

    public Message(String role, String prompt) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
