package com.boarding_pass.project.service;

import com.boarding_pass.project.dao.BoardingPassDetailsDao;
import com.boarding_pass.project.entity.BoardingPassDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BoardingPassDetailsServiceImpl implements BoardingPassDetailsService {

    @Autowired
    private BoardingPassDetailsDao boardingPassDetailsDao;

    @Override
    @Transactional
    public List<BoardingPassDetails> listBoardingPassDetails() {
        return boardingPassDetailsDao.listBoardingPassDetails();
    }

    @Override
    @Transactional
    public void addBoardingPassDetails(BoardingPassDetails boardingPassDetails) {
        boardingPassDetailsDao.addBoardingPassDetails(boardingPassDetails);
    }

    @Override
    @Transactional
    public BoardingPassDetails getBoardingPassDetailsById(int id) {
        return boardingPassDetailsDao.getBoardingPassDetailsById(id);
    }

    @Override
    @Transactional
    public void deleteBoardingPassDetailsById(int id) {
        boardingPassDetailsDao.deleteBoardingPassDetailsById(id);
    }

    @Override
    @Transactional
    public void updateBoardingPassDetails(BoardingPassDetails boardingPassDetails, int id) {
        boardingPassDetailsDao.updateBoardingPassDetails(boardingPassDetails, id);
    }
}
