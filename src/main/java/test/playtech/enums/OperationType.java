package test.playtech.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OperationType {

    READ("read"),
    WRITE("write");

    private String operationName;
}
