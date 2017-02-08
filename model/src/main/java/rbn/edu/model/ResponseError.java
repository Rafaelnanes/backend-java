package rbn.edu.model;

import java.util.List;

public class ResponseError {
    private int statusCode;
    private List<String> messages;

    public int getStatusCode() {
	return statusCode;
    }

    public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
    }

    public List<String> getMessages() {
	return messages;
    }

    public void setMessages(List<String> messages) {
	this.messages = messages;
    }

}