package com.boarding_pass.project.service;

import com.boarding_pass.project.entity.BoardingPass;

import java.util.List;

public interface BoardingPassService {

    public List<BoardingPass> listBoardingPass();

    public void addBoardingPass(BoardingPass boardingPass);

    public BoardingPass getBoardingPassById(int id);

    public void deleteBoardingPassById(int id);

    public void updateBoardingPass(BoardingPass boardingPass, int id);
}
