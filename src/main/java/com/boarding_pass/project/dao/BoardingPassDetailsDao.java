package com.boarding_pass.project.dao;

import com.boarding_pass.project.entity.User;

public interface BoardingPassDetailsDao {

    public void writeBoardingPassDetails();

    public User getBoardingPassDetailsById();

    public void deleteBoardingPassDetailsById();

    public void updateBoardingPassDetails();
}
