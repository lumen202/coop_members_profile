package dev.lumen.enums;

public enum Status {
    SINGLE(1, "Single"), MARRIED(2, "Married"), WIDOW(3, "Widow"), WIDOWER(4, "Widdower");

    private int code;
    private String display;

    private Status(int code, String display) {
        this.code = code;
        this.display = display;

    }

    public String getDisplay() {
        return this.display;
    }

    public int getCode() {
        return this.code;
    }

    public static Status fromCode(int code) {
        return switch (code) {
            case 0 -> Status.SINGLE;
            case 1 -> Status.MARRIED;
            case 2 -> Status.WIDOW;
            case 3 -> Status.WIDOWER;
            default -> null;
        };
    }
}
