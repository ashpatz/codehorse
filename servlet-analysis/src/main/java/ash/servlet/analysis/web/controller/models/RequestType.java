package ash.servlet.analysis.web.controller.models;

public enum RequestType {

    AUTH("authorization.oauth2"),
    SAML_ACS("ACS.saml2"),
    RESUME_AUTH("authorization.ping"),
    TOKEN("oauth2.token"),
    OTHER("other");

    private String type;

    RequestType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
