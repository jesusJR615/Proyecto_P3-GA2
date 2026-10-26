package p3g2.p3g2.models;

import java.util.Date;

/**
 * Error
 */
public class Error {
    private String message;
    private String description;
    private int status;
    private Date timestamp;

    public Error() {

    }

    public Error(String message, String description, int status, Date timestamp) {
        this.message = message;
        this.description = description;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Error{" +
                "message=" + message +
                ", description='" + description + '\'' +
                ", status=" + status + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

}