package com.redhat.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "explanation")
public class Explanation extends PanacheEntity {
    public String explanation;

    @ManyToOne
    @JoinColumn(name="acronym_id")
    @JsonIgnore
    public Acronym acronym;

    @Column(nullable = false, name = "is_checked", columnDefinition = "bit default 0")
    public boolean isChecked = false;

    public String authorEmail;

    public Explanation() {}

    public Explanation(String explanation, Acronym acronym) {
        this.explanation = explanation;
        this.acronym = acronym;
    }

    @Override
    public String toString() {
        return "Explanation{" +
                "id=" + id +
                ", explanation='" + explanation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Explanation that = (Explanation) o;
        return explanation.equals(that.explanation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(explanation);
    }
}