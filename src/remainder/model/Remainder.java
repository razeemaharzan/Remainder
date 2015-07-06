/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remainder.model;

import java.util.Date;

/**
 *
 * @author Rajya Laxmi Maharjan
 */
public class Remainder {

    private String message;

    private Date date;

    private Date remindDate;

    private Status status;

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getRemindDate() {
        return remindDate;
    }

    public void setRemindDate(Date remindDate) {
        this.remindDate = remindDate;
    }

    public Remainder(String message, Date date, Status status, Date remindDate) {

        this.message = message;
        this.date = date;
        this.status = status;
        this.remindDate = remindDate;
    }

}
