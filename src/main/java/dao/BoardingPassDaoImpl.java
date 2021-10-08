package dao;

import entity.BoardingPass;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardingPassDaoImpl {

    @Autowired
    private Session session;

    public void writeBoardingPass(BoardingPass boardingPass){

    }

    public BoardingPass getBoardingPassById(int id){
        return null;
    }

    public void deleteBoardingPassById(int id){

    }

    public void updateBoardingPass(int id){

    }
}
