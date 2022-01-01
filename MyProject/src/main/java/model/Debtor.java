package model;

public class Debtor {
    String debtorName;
    int debtorId;
    String address1;
    String address2;
    String faxNo;
    String email;
    String bankName;
    int accountNo;
    String swiftAddress;

    public String getDebtorName () {
        return debtorName;
    }

    public void setDebtorName (String debtorName) {
        this.debtorName = debtorName;
    }

    public int getDebtorId () {
        return debtorId;
    }

    public void setDebtorId (int debtorId) {
        this.debtorId = debtorId;
    }

    public String getAddress1 () {
        return address1;
    }

    public void setAddress1 (String address1) {
        this.address1 = address1;
    }

    public String getAddress2 () {
        return address2;
    }

    public void setAddress2 (String address2) {
        this.address2 = address2;
    }

    public String getFaxNo () {
        return faxNo;
    }

    public void setFaxNo (String faxNo) {
        this.faxNo = faxNo;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getBankName () {
        return bankName;
    }

    public void setBankName (String bankName) {
        this.bankName = bankName;
    }

    public int getAccountNo () {
        return accountNo;
    }

    public void setAccountNo (int accountNo) {
        this.accountNo = accountNo;
    }

    public String getSwiftAddress () {
        return swiftAddress;
    }

    public void setSwiftAddress (String swiftAddress) {
        this.swiftAddress = swiftAddress;
    }
}
