package com.example.fitness.model;

import java.util.Date;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "marketing")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "month")
    private String month;

    @Column(name = "year")
    private int year;

    @Column(name = "activity")
    private String activity;

    @Column(name = "execution_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date execution_date;

    @Column(name = "expense")
    private int expense;

    @Column(name = "motive")
    private String motive;

    @Column(name = "result")
    private String result;

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Date getExecution_date() {
        return execution_date;
    }

    public void setExecution_date(Date execution_date) {
        this.execution_date = execution_date;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", activity='" + activity + '\'' +
                ", expense=" + expense +
                ", motive='" + motive + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
