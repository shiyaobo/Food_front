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
		//��һ�β�ѯ���еĲ�Ʒ
		//�ڶ��� �������Ĳ�Ʒ���� ��ѯ����Ʒ
		String typeId="";
		if(request.getParameter("typeId")!=null){
			typeId=request.getParameter("typeId");
		}
		//��index.jsp�д��ݹ����Ĳ���ID����session�У������¶���ʱ�õ�����ID
		HttpSession session=request.getSession();
		session.setAttribute("deskId", request.getParameter("deskId"));
		
		
		String curPage=request.getParameter("curPaage");
		Integer curPageInt=1;
		if(curPage!=null){
			curPageInt=Integer.valueOf(curPage);
		}
		//��Ʒ 
		
		PageTools foodList = mf.getFoodList(curPageInt,typeId);
		request.setAttribute("foodList", foodList);
		request.setCharacterEncoding("UTF-8");
		//��ϵ
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
