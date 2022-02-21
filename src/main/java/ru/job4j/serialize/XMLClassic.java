package ru.job4j.serialize;

public class XMLClassic {
    private boolean legend;
    private int size;
    private String name;
    private Contact contact;
    private String[] status;

    public XMLClassic() {
        super();
    }

    public XMLClassic(boolean legend, int size, String name, Contact contact, String[] status) {
        this.legend = legend;
        this.size = size;
        this.name = name;
        this.contact = contact;
        this.status = status;
    }

    public boolean isLegend() {
        return legend;
    }

    public void setLegend(boolean legend) {
        this.legend = legend;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String[] getStatus() {
        return status;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }
}
