package com.udacity.bootstrap.dtos;

public class NumberValidate {

    private boolean valid;
    private String phone;
    private String location;
    private String type;
    private String carrier;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    @Override
    public String toString() {
        return "NumberValidate{" +
                "valid=" + valid +
                ", phone='" + phone + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", carrier='" + carrier + '\'' +
                '}';
    }

}
