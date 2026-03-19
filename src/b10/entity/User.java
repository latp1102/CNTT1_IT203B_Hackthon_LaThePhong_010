package b10.entity;

import java.util.Scanner;

public class User {
    private String userId;
    private String userName;
    private int age;
    private String role;
    private double score;

    public User(String userId, String userName, int age,String role, double score) {
        this.userId = userId;
        this.role = role;
        this.age = age;
        this.score = score;
        this.userName = userName;
    }

    public User() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //    public void inputData(Scanner scanner){
//        this.id = id;
//        this.userName = userName;
//        this.age = age;
//        this.role = role;
//        this.score =score;
//    }
    public void inputData(Scanner scanner){
        do {
            System.out.println("Nhập id user: ");
            String id = scanner.nextLine().trim();
            if (id.matches("U\\d{3}")){
                this.userId=id;
                break;
            }else {
                System.out.println("Sai định dạng");
            }
        }while (true);
        System.out.println("Nhập tên: ");
        this.userName= scanner.nextLine().trim();
        do {
            System.out.println("Nhập tuôi: ");
            int age = Integer.parseInt(scanner.nextLine());
            if(age >= 18){
                this.age=age;
                break;
            }else {
                System.out.println("Tuổi lớn >= 18");
            }
        }while (true);
        do {
            System.out.println("Nhập vai trò: ");
            String role = scanner.nextLine().toUpperCase();
            if (role.equals("USER") || role.equals("ADMIN")){
                this.role=role;
                break;
            }else {
                System.out.println("Sai vai trò");
            }
        }while (true);
        do {
            System.out.println("Nhập điểm: ");
            double score = Double.parseDouble(scanner.nextLine());
            if(score >= 0 && score <= 10){
                this.score=score;
                break;
            }else {
                System.out.println("Điểm ko đúng");
            }
        }while (true);
    }
    public void displayData(){
        System.out.printf("| ID: %-5s | Tên: %-20s | Tuổi: %-5d | Vai trò: %-10s | Điểm: %-5.2f |\n", userId, userName, age, role, score);
    }
}
