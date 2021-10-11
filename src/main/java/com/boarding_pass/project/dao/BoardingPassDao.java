package com.boarding_pass.project.dao;

import com.boarding_pass.project.entity.User;

public interface BoardingPassDao {

    public void writeBoardingPass();

    public User getBoardingPassById();

    public void deleteBoardingPassById();

    public void updateBoardingPass();
}
