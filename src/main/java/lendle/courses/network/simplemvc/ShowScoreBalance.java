/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.network.simplemvc;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class ShowScoreBalance {
    
    
          protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("id");
        Student customer=Student.getStudent(id);
        String address=null;
        if(customer==null){
        }else if(customer.getScore()<0){
            request.setAttribute("customer", customer);
            RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/score-report/LowScore.jsp");
        }else if(customer.getScore()>10000){
            RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/score-report/HighScore.jsp");
        }else{
            RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/score-report/Score.jsp");
        }
        request.getRequestDispatcher(address).forward(request, response);
    }
    
    
}
