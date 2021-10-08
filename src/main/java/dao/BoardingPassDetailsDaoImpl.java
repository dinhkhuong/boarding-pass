package dao;

import entity.BoardingPassDetails;
import entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardingPassDetailsDaoImpl {

    @Autowired
    private Session session;
    public void writeBoardingPassDetails(){

    }

    public BoardingPassDetails getBoardingPassDetailsById(int id){
        return null;
    }

    public void deleteBoardingPassDetailsById(int id){

    }

    public void updateBoardingPassDetails(int id){

    }
}
