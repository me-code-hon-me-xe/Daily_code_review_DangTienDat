package Day27_7_2023.model;

import java.sql.Time;

public class Student {
    private int id;
    private String first_name;
    private String last_name;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private Time created_at;
    private Time updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Time getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Time created_at) {
        this.created_at = created_at;
    }

    public Time getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Time updated_at) {
        this.updated_at = updated_at;
    }

    public Student(int id, String first_name, String last_name, int age, String gender, String email, String phone, String address, Time created_at, Time updated_at) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }


}
