package platform;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Code {
    private String code;
    private String date;
    private static final String DATE_FORMATTER= "yyyy/MM/dd HH:mm:ss";

    public Code() {
    }

    public Code(String code) {
        this.code = code;

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

        this.date = localDateTime.format(formatter);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }
}
