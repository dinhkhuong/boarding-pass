package com.boarding_pass.project.dao;

import com.boarding_pass.project.entity.BoardingPass;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BoardingPassDaoImpl implements BoardingPassDao{

    @Autowired
    private Session session;

    @Override
    @Transactional
    public List<BoardingPass> listBoardingPass(){
        return session.createQuery("from BoardingPass").getResultList();
    }

    @Override
    @Transactional
    public void addBoardingPass(BoardingPass boardingPass){
        session.beginTransaction();
        session.save(boardingPass);
        session.getTransaction().commit();
        System.out.println("Boarding pass added.");
    }

    @Override
    @Transactional
    public BoardingPass getBoardingPassById(int id){
        session.beginTransaction();
        BoardingPass boardingPass = session.get(BoardingPass.class, id);;
        session.getTransaction().commit();
        return boardingPass;
    }

    @Override
    @Transactional
    public void deleteBoardingPassById(int id){
        session.beginTransaction();
        BoardingPass boardingPass = session.get(BoardingPass.class, id);
        session.delete(boardingPass);
        session.getTransaction().commit();
        System.out.println("Boarding pass deleted.");
    }

    @Override
    @Transactional
    public void updateBoardingPass(BoardingPass boardingPass, int id){
        session.beginTransaction();
        BoardingPass boardingPass1 = session.get(BoardingPass.class, id);
        boardingPass1 = boardingPass;
        session.saveOrUpdate(boardingPass1);
        session.getTransaction().commit();
        System.out.println("Boarding pass updated.");
    }
}
