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
public class ShowBalanceServlet {
    
    
          protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("id");
        BankCustomer customer=BankCustomer.getCustomer(id);
        String address=null;
        if(customer==null){
        }else if(customer.getBalance()<0){
            request.setAttribute("customer", customer);
            RequestDispatcher rd=request.getRequestDispatcher("/bank-account/NegativeBalance.jsp");
        }else if(customer.getBalance()>10000){
            RequestDispatcher rd=request.getRequestDispatcher("/bank-account/HighBalance.jsp");
        }else{
            RequestDispatcher rd=request.getRequestDispatcher("/bank-account/NormalBalance.jsp");

        }
        request.getRequestDispatcher(address).forward(request, response);
    }
    
    
}
