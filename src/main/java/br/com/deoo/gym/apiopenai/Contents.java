package br.com.deoo.gym.apiopenai;

public class Contents {
    private String role;
    private Parts parts;

    public Contents(String role, String text) {
        this.role = role;
        this.parts = new Parts(text);
    }

    public Parts getParts() {
        return parts;
    }

    public void setParts(Parts parts) {
        this.parts = parts;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    class Parts {
        private String text;

        public Parts(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}