public class Comment {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    Comment(){ //construtor vazio

    }

    Comment(String text){
        this.text = text;
    }

}
