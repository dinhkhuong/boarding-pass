package com.boarding_pass.project.dao;

import com.boarding_pass.project.entity.BoardingPassDetails;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class BoardingPassDetailsDaoImpl implements BoardingPassDetailsDao {

    @Autowired
    private Session session;

    @Override
    public List<BoardingPassDetails> listBoardingPassDetails(){
        return session.createQuery("from BoardingPassDetails").getResultList();
    }

    @Override
    public void addBoardingPassDetails(BoardingPassDetails boardingPassDetails){
        session.save(boardingPassDetails);
        System.out.println("Boarding pass details saved");
    }
    @Override
    public BoardingPassDetails getBoardingPassDetailsById(int id){
        return session.get(BoardingPassDetails.class, id);
    }

    @Override
    public void deleteBoardingPassDetailsById(int id){
        BoardingPassDetails boardingPassDetails = session.get(BoardingPassDetails.class, id);
        session.delete(boardingPassDetails);
    }

    @Override
    public void updateBoardingPassDetails(BoardingPassDetails boardingPassDetails, int id){
        BoardingPassDetails boardingPassDetails1 = session.get(BoardingPassDetails.class, id);
        boardingPassDetails1 = boardingPassDetails;
        session.saveOrUpdate(boardingPassDetails1);
        System.out.println("Boarding pass details updated.");
    }
}
