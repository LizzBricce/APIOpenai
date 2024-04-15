package br.com.deoo.gym.apiopenai;

public class ChatRequest {
    private Contents contents;

    public ChatRequest(String prompt) {
        this.contents = new Contents("user", prompt);
    }

    public Contents getContents() {
        return contents;
    }

    public void setContents(Contents contents) {
        this.contents = contents;
    }
}
