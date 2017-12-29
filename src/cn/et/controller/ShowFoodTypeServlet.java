package cn.et.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.et.model.MyFood;
import cn.et.model.PageTools;
import cn.et.model.foodType.MyFoodType;
import oracle.net.aso.f;




/**
 * Servlet implementation class ShowFoodTypeServlet
 */
public class ShowFoodTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFoodTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    MyFoodType mft=new MyFoodType();
    MyFood mf=new MyFood();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//第一次查询所有的菜品
		//第二次 传过来的菜品类型 查询出菜品
		String typeId="";
		if(request.getParameter("typeId")!=null){
			typeId=request.getParameter("typeId");
		}
		//将index.jsp中传递过来的餐桌ID存入session中，方便下订单时用到餐桌ID
		HttpSession session=request.getSession();
		session.setAttribute("deskId", request.getParameter("deskId"));
		
		
		String curPage=request.getParameter("curPaage");
		Integer curPageInt=1;
		if(curPage!=null){
			curPageInt=Integer.valueOf(curPage);
		}
		//菜品 
		
		PageTools foodList = mf.getFoodList(curPageInt,typeId);
		request.setAttribute("foodList", foodList);
		request.setCharacterEncoding("UTF-8");
		//菜系
//		request.setAttribute("foodTypeList", mft.getAllFoodType());
		request.getRequestDispatcher("/detail/caidan.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
