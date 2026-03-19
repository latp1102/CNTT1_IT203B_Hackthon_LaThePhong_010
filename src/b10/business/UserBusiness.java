package b10.business;

import b10.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserBusiness {
    private static UserBusiness instance;
    private List<User> users;

    public UserBusiness(List<User> users) {
        this.users = users;
    }
    private UserBusiness(){
        users = new ArrayList<>();
    }
    public static UserBusiness getInstance(){
        if (instance==null){
            instance= new UserBusiness();
        }
        return instance;
    }
    public void displayUser(){
        if (users.isEmpty()){
            System.out.println("Danh sách rỗng");
            return;
        }
        //users.forEach(User::displayData);
        users.forEach(u -> u.displayData());
    }
    public void add(User user){
        boolean exists = users.stream()
                .filter(u -> u.getUserId().equals(user.getUserId()))
                .findFirst()
                .isPresent();
        if (exists){
            System.out.println("Id tồn tại");
        }else {
            users.add(user);
        }
    }
    //
    public Optional<User> findById(String id){
        return users.stream().filter(u -> u.getUserId().equals(id)).findFirst();
    }
//    public void update(String id, Scanner scanner){
//        Optional<User> optionalUser = findById(id);
//        if (!optionalUser.isPresent()){
//            System.out.println("id người dùng ko tồn tại");
//            return;
//        }
//        User user = optionalUser.get();
//        System.out.println("1. Tên \n 2. Tuổi \n 3. Vai trò \n 4. Điểm");
//        int choice = Integer.parseInt(scanner.nextLine());
//        switch (choice){
//            case 1:
//                System.out.println("Tên mới: ");
//                user.setUserName(scanner.nextLine());
//                break;
//            case 2:
//                System.out.println("Tuổi mới: ");
//                user.setAge(Integer.parseInt(scanner.nextLine()));
//                break;
//            case 3:
//                System.out.println("Nhập vai trò: ");
//                user.setRole(scanner.nextLine());
//                break;
//            case 4:
//                System.out.println("Nhập điểm: ");
//                user.setScore(Double.parseDouble(scanner.nextLine()));
//                break;
//        }
//    }
    public void update(String id, Scanner scanner){
        Optional<User> optionalUser = findById(id);
        if (!optionalUser.isPresent()){
            System.out.println("id người dùng ko tồn tại");
            return;
        }
        User user = optionalUser.get();
        System.out.println("===== NHẬP THÔNG TIN MỚI =====");
        System.out.print("Tên mới: ");
        String name = scanner.nextLine();
        System.out.print("Tuổi mới: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (Exception e){
            System.out.println("Tuổi không hợp lệ!");
            return;
        }
        System.out.print("Vai trò: ");
        String role = scanner.nextLine();
        System.out.print("Điểm: ");
        double score;
        try {
            score = Double.parseDouble(scanner.nextLine());
        } catch (Exception e){
            System.out.println("Điểm không hợ");
            return;
        }
        // cập nhật 1 lần
        user.setUserName(name);
        user.setAge(age);
        user.setRole(role);
        user.setScore(score);
        System.out.println("Cập nhật thành công");
    }
    //
    public void search(String word){
        List<User> result = users.stream()
                .filter(u -> u.getUserName().toLowerCase()
                        .contains(word.toLowerCase()))
                .collect(Collectors.toList());
        if(result.isEmpty()){
            System.out.println("Không tìm thấy");
        }else{
            result.forEach(User::displayData);
            System.out.println("Tổng: "+result.size());
        }
    }
    public void delete(String id){
        int b = users.size();
        users.removeIf(u -> u.getUserId().equals(id));
        if(users.size()==b){
            System.out.println("Id người dùng ko tồn tại");
        }
    }
    public void filterAdmin(){
        users.stream().filter(u -> u.getRole().equals("ADMIN"))
                .forEach(User::displayData);
    }
    public void sortGiam(){
        users.stream()
                .sorted((u1, u2) -> Double.compare(u2.getScore(), u1.getScore()))
                .forEach(User::displayData);
    }
}
