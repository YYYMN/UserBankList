package by.novicov.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Account implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int account;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", account=" + account +
                '}';
    }
}
