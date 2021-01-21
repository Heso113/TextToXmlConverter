package olsson.hampus.src.containers;

public class Phone {
    private String mobilePhoneNumber;
    private String landlinePhoneNumber;

    public Phone() {
        
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getLandlinePhoneNumber() {
        return landlinePhoneNumber;
    }

    public void setLandlinePhoneNumber(String landlinePhoneNumber) {
        this.landlinePhoneNumber = landlinePhoneNumber;
    }

    public String generateXml(int numberOfIndents) {
        StringBuilder stringBuilder = new StringBuilder();
        String baseIndent = "";
        for (int i = 0; i < numberOfIndents; i++) {
            baseIndent += "\t";
        }
        stringBuilder.append(baseIndent).append("<phone>\n");
        if (this.mobilePhoneNumber != null) {
            stringBuilder.append(baseIndent).append("\t").append("<mobile>").append(this.mobilePhoneNumber).append("</mobile>\n");
        }
        if (this.landlinePhoneNumber != null) {
            stringBuilder.append(baseIndent).append("\t").append("<landline>").append(this.landlinePhoneNumber).append("</landline>\n");
        }
        stringBuilder.append(baseIndent).append("</phone>\n");
        return stringBuilder.toString();
    }
}
