package tesky.mn2.integration;

public enum IntegrationPhilosophy {
    OPENED("aberta"), CLOSED("fechada");

    private String type;

    IntegrationPhilosophy(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static boolean isOpened(String type) {
        return type.equals(OPENED.getType());
    }

    public static boolean isClosed(String type) {
        return type.equals(CLOSED.getType());
    }
}
