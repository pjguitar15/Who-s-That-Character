/**
 * @author Philcob Suzuki Josol
 */
public class Question {
    private String silImgUrl;
    private String ansImgUrl;
    private String answer;

    public Question(String silImgUrl, String ansImgUrl, String answer) {
        this.silImgUrl = silImgUrl;
        this.ansImgUrl = ansImgUrl;
        this.answer = answer;
    }

    public String getSilImgUrl() {
        return silImgUrl;
    }

    public void setSilImgUrl(String silImgUrl) {
        this.silImgUrl = silImgUrl;
    }

    public String getAnsImgUrl() {
        return ansImgUrl;
    }

    public void setAnsImgUrl(String ansImgUrl) {
        this.ansImgUrl = ansImgUrl;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "silImgUrl='" + silImgUrl + '\'' +
                ", ansImgUrl='" + ansImgUrl + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
