package finance;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.portable.RemarshalException;

import finance.*;

public class ModifyApplicationServlet extends HttpServlet
{
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String ApplicationNo=request.getParameter("ApplicationNo");
	//	String Date=request.getParameter("Date");
		String Comment=request.getParameter("Comment");
	//	String Tno=request.getParameter("Tno");
	//	String Transaction=request.getParameter("Transaction");
		Double Cost=Double.parseDouble(request.getParameter("Cost"));
		Double OfficeSupplies=Double.parseDouble(request.getParameter("OfficeSupplies"));
		Double MaterialExpense=Double.parseDouble(request.getParameter("MaterialExpense"));
		Double EquipmentExpense=Double.parseDouble(request.getParameter("EquipmentExpense"));
		Double InformationExpense=Double.parseDouble(request.getParameter("InformationExpense"));
		Double TravellingExpense=Double.parseDouble(request.getParameter("TravellingExpense"));
		Double EntertainmentExpense=Double.parseDouble(request.getParameter("EntertainmentExpense"));
		Double PostExpense=Double.parseDouble(request.getParameter("PostExpense"));
		Double PrintingExpense=Double.parseDouble(request.getParameter("PrintingExpense"));
		Double PageExpense=Double.parseDouble(request.getParameter("PageExpense"));
		Double CommunicationExpense=Double.parseDouble(request.getParameter("CommunicationExpense"));
		Double ConferenceExpense=Double.parseDouble(request.getParameter("ConferenceExpense"));
		Double TrainingExpense=Double.parseDouble(request.getParameter("TrainingExpense"));
		Double PorkingExpense=Double.parseDouble(request.getParameter("PorkingExpense"));
		Double FuelExpense=Double.parseDouble(request.getParameter("FuelExpense"));
		Double UpkeepExpense=Double.parseDouble(request.getParameter("UpkeepExpense"));
		Integer Number=Integer.parseInt(request.getParameter("Number"));
		try
		{
			ReimburseDao dao=new ReimburseDao();
			Application a=new Application();
			a.setApplicationNo(ApplicationNo);
			a.setCost(Cost);
			a.setComment(Comment);
			a.setOfficeSupplies(OfficeSupplies);
			a.setMaterialExpense(MaterialExpense);
			a.setEquipmentExpense(EquipmentExpense);
			a.setInformationExpense(InformationExpense);
			a.setTravellingExpense(TravellingExpense);
			a.setEntertainmentExpense(EntertainmentExpense);
			a.setPostExpense(PostExpense);
			a.setPrintingExpense(PrintingExpense);
			a.setPageExpense(PageExpense);
			a.setCommunicationExpense(CommunicationExpense);
			a.setConferenceExpense(ConferenceExpense);
			a.setTrainingExpense(TrainingExpense);
			a.setPorkingExpense(PorkingExpense);
			a.setFuelExpense(FuelExpense);
			a.setUpkeepExpense(UpkeepExpense);
			a.setNumber(Number);
			a.setExamine("已审核");
			dao.update(a);
			response.sendRedirect("ApplicationList.jsp");
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
