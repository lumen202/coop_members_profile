package dev.lumen.enums;

public enum Office {
    HEAD_OFFICE(1, "Head Office"),
    BRANCH_OFFICE(2, "Branch Office"),
    SUPPORT_OFFICE(3, "Support Office");

    private int code;
    private String display;

    private Office(int code, String display) {
        this.code = code;
        this.display = display;
    }

    public int getCode() {
        return this.code;
    }

    public String getDisplay() {
        return this.display;
    }

    public static Office fromCode(int code) {
        return switch (code) {
            case 1 -> Office.HEAD_OFFICE;
            case 2 -> Office.BRANCH_OFFICE;
            case 3 -> Office.SUPPORT_OFFICE;
            default -> null;
        };
    }
}
