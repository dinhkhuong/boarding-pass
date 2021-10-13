package com.boarding_pass.project.service;

import com.boarding_pass.project.dao.BoardingPassDao;
import com.boarding_pass.project.entity.BoardingPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BoardingPassServiceImpl implements BoardingPassService {

    @Autowired
    private BoardingPassDao boardingPassDao;

    @Override
    public List<BoardingPass> listBoardingPass() {
        return boardingPassDao.listBoardingPass();
    }

    @Override
    public void addBoardingPass(BoardingPass boardingPass) {
        boardingPassDao.addBoardingPass(boardingPass);
    }

    @Override
    public BoardingPass getBoardingPassById(int id) {
        return boardingPassDao.getBoardingPassById(id);
    }

    @Override
    public void deleteBoardingPassById(int id) {
        boardingPassDao.deleteBoardingPassById(id);
    }

    @Override
    public void updateBoardingPass(BoardingPass boardingPass, int id) {
        boardingPassDao.updateBoardingPass(boardingPass, id);
    }
}
