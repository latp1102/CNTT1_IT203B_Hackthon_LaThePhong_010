package b10.ra.entity;

import java.util.Scanner;

public class Team {
    private String teamId;
    private String teamName;
    private int memberCount;
    private double averageWeight;

    public Team() {
    }

    public Team(double averageWeight, int memberCount, String teamId, String teamName) {
        this.averageWeight = averageWeight;
        this.memberCount = memberCount;
        this.teamId = teamId;
        this.teamName = teamName;
    }

    public double getAverageWeight() {
        return averageWeight;
    }

    public void setAverageWeight(double averageWeight) {
        this.averageWeight = averageWeight;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public void inputData(Scanner scanner){
        do {
            System.out.println("Nhập id team: ");
            String id = scanner.nextLine().trim();
            if (id.matches("T\\d{3}")){
                this.teamId=id;
                break;
            }else {
                System.out.println("Sai định dạng ID");
            }
        }while (true);
        do {
            System.out.println("Nhập tên: ");
            String teamName = scanner.nextLine();
            if(teamName.equals("Lớp") || teamName.equals("Đội thi")){
                this.teamName=teamName;
                break;
            }else {
                System.out.println("Sai định dạng tên");
            }
        }while (true);
        do {
            System.out.println("Nhập số lượng thành viên: ");
            int memberCount = Integer.parseInt(scanner.nextLine());
            if(memberCount >= 10){
                this.memberCount=memberCount;
                break;
            }else {
                System.out.println("Số lượng thành viên phải từ 10 trở lên");
            }
        }while (true);
        System.out.println("Nhập cân nặng: ");
        this.averageWeight=Double.parseDouble(scanner.nextLine());

    }
    public void displayData(){
        System.out.printf("| ID: %-5s | Tên: %-10s | MemberCount: %-5d | AverageWeight: %-5.2f |\n", teamId, teamName, memberCount, averageWeight);
    }
}
