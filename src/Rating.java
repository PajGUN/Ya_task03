public class Rating {
    private String login;
    private int userId;
    private int documentId;
    private boolean judgement;
    private boolean judgementCorrect;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public boolean isJudgement() {
        return judgement;
    }

    public void setJudgement(boolean judgement) {
        this.judgement = judgement;
    }

    public boolean isJudgementCorrect() {
        return judgementCorrect;
    }

    public void setJudgementCorrect(boolean judgementCorrect) {
        this.judgementCorrect = judgementCorrect;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "login='" + login + '\'' +
                ", userId=" + userId +
                ", documentId=" + documentId +
                ", judgement=" + judgement +
                ", judgementCorrect=" + judgementCorrect +
                '}';
    }
}
