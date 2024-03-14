package pro.sky.sheltertelegrambot.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table (name = "message_to_volunteer")
public class MessageToVolunteer {
    @Id
    private int id; // id от бота
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDateTime questionTime;
    private LocalDateTime answerTime;
    private String question;
    private String answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getQuestionTime() {
        return questionTime;
    }

    public void setQuestionTime(LocalDateTime questionTime) {
        this.questionTime = questionTime;
    }

    public LocalDateTime getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(LocalDateTime answerTime) {
        this.answerTime = answerTime;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageToVolunteer that = (MessageToVolunteer) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
