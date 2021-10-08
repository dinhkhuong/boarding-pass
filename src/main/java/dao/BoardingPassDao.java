package dao;

import entity.User;

public interface BoardingPassDao {

    public void writeBoardingPass();

    public User getBoardingPassById();

    public void deleteBoardingPassById();

    public void updateBoardingPass();
}
