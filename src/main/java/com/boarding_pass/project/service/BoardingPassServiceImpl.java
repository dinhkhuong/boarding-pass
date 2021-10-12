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
    @Transactional
    public List<BoardingPass> listBoardingPass() {
        return boardingPassDao.listBoardingPass();
    }

    @Override
    @Transactional
    public void addBoardingPass(BoardingPass boardingPass) {
        boardingPassDao.addBoardingPass(boardingPass);
    }

    @Override
    @Transactional
    public BoardingPass getBoardingPassById(int id) {
        return boardingPassDao.getBoardingPassById(id);
    }

    @Override
    @Transactional
    public void deleteBoardingPassById(int id) {
        boardingPassDao.deleteBoardingPassById(id);
    }

    @Override
    @Transactional
    public void updateBoardingPass(BoardingPass boardingPass, int id) {
        boardingPassDao.updateBoardingPass(boardingPass, id);
    }
}
