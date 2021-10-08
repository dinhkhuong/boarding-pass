package dao;

import entity.User;

public interface BoardingPassDetailsDao {

    public void writeBoardingPassDetails();

    public User getBoardingPassDetailsById();

    public void deleteBoardingPassDetailsById();

    public void updateBoardingPassDetails();
}
