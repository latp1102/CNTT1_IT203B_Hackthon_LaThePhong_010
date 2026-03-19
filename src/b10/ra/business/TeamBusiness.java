package b10.ra.business;
import b10.ra.entity.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TeamBusiness {
    private static TeamBusiness instance;
    private List<Team> teams;

    public TeamBusiness(List<Team> teams) {
        this.teams = teams;
    }
    private TeamBusiness(){
        teams = new ArrayList<>();
    }
    public static TeamBusiness getInstance(){
        if (instance==null){
            instance= new TeamBusiness();
        }
        return instance;
    }
    public void displayTeam(){
        if (teams.isEmpty()){
            System.out.println("Danh sách rỗng");
            return;
        }
        teams.forEach(Team::displayData);
    }
    public void add(Team team){
        boolean e = teams.stream().anyMatch(t -> t.getTeamId().equals(team.getTeamId()));
        if (e){
            System.out.println("Id team tồn tại");
        }else {
            teams.add(team);
        }
        System.out.println("Thêm thành công");
    }
    public Optional<Team> findById(String teamId){
        return teams.stream().filter(t -> t.getTeamId().equals(teamId)).findFirst();
    }
    public void updateTeam(String teamId, Scanner scanner){
        Optional<Team> optionalTeam = findById(teamId);
        if (!optionalTeam.isPresent()){
            System.out.println("id team ko tồn tại");
            return;
        }
        Team team = optionalTeam.get();
        System.out.println("1.Tên \n 2.Số lượng thành viên \n 3.Cân nặng \n");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                System.out.println("Nhập tên mới: ");
                team.setTeamName(scanner.nextLine());
                System.out.println("Cập nhật tên thành công");
                break;
            case 2:
                System.out.println("Nhập số lượng thành viên mới: ");
                team.setMemberCount(Integer.parseInt(scanner.nextLine()));
                System.out.println("Cập nhật số lượng thành công");
                break;
            case 3:
                System.out.println("Nhập cân nặng mới: ");
                team.setAverageWeight(Double.parseDouble(scanner.nextLine()));
                System.out.println("Cập nhật cân nặng thành công");
                break;
        }
    }
    public void deleteTeam(String teamId){
        int b = teams.size();
        teams.removeIf(u -> u.getTeamId().equals(teamId));
        if(teams.size()==b){
            System.out.println("Id người dùng ko tồn tại");
        }
        System.out.println("Xóa thành công");
    }
    public void searchTeam(String word){
        List<Team> result = teams.stream()
                .filter(u -> u.getTeamName().toLowerCase()
                        .contains(word.toLowerCase()))
                .collect(Collectors.toList());
        if(result.isEmpty()){
            System.out.println("Không tìm thấy");
        }else{
            result.forEach(Team::displayData);
            System.out.println("Tổng: "+result.size());
        }
    }
    public void filter(){
        List<Team> teamList = new ArrayList<>();
        for (Team t: teamList){
            if(t.getAverageWeight() >= 60.0){
                teamList.add(t);
            }
        }
        if(teamList.isEmpty()){
            System.out.println("Không có cân nặng trung bình >= 60.0");
        }else {
            System.out.println("Có cân nặng trung bình >= 60.0");
            teamList.forEach(Team::displayData);
        }
    }
    public void sortAverageWeight(){
        teams.stream()
                .sorted((t1, t2) -> Double.compare(t2.getAverageWeight(), t1.getAverageWeight()))
                .forEach(Team::displayData);
    }
}
