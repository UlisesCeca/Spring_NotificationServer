package com.ulises.notificationsserver.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ulises.notificationsserver.services.entities.Context;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

public class EmailDTO {
    @Email(message = "You must introduce a valid to-email.")
    @NotNull(message = "to must not be empty.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String to;
    @NotNull(message = "from must not be empty.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String from;
    @NotNull(message = "subject must not be empty.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String subject;
    @NotNull(message = "body must not be empty.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String body;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<String> cc;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<String> bcc;
    @NotNull(message = "context must not be empty.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Context context;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
