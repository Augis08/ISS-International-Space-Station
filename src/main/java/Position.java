public class Position extends IssPosition {
    private long timestamp;
    private IssPosition iss_position;
    private String message;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public IssPosition getIss_position() {
        return iss_position;
    }

    public void setIss_position(IssPosition iss_position) {
        this.iss_position = iss_position;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    // METHODS


    @Override
    public String toString() {
        return "Position{" +
                "timestamp=" + timestamp +
                ", iss_position=" + iss_position +
                '}';
    }
}